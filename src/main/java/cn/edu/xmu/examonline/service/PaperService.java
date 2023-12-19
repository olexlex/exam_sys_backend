package cn.edu.xmu.examonline.service;

import cn.edu.xmu.examonline.dao.*;
import cn.edu.xmu.examonline.model.bo.Major;
import cn.edu.xmu.examonline.model.bo.Paper;
import cn.edu.xmu.examonline.model.bo.PaperQuest;
import cn.edu.xmu.examonline.model.bo.Quest;
import cn.edu.xmu.examonline.model.vo.PaperUserAnswerVo;
import cn.edu.xmu.examonline.model.vo.PaperQuestVo;
import cn.edu.xmu.examonline.model.vo.PaperVo;
import cn.edu.xmu.examonline.util.Common;
import cn.edu.xmu.examonline.util.ReturnObj;
import cn.edu.xmu.examonline.util.ReturnStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PaperService {

    private Random randomGenerator = new Random();

    @Autowired
    PaperDao paperDao;

    @Autowired
    QuestDao questDao;

    @Autowired
    PaperQuestDao paperQuestDao;

    @Autowired
    UserDao userDao;

    @Autowired
    MajorDao majorDao;


    private void getPaperMajorName(PaperVo vo)
    {
        if(vo.getMajor1Id() != null)
            vo.setMajor1Name(majorDao.getById(vo.getMajor1Id()).getData().getName());
        if(vo.getMajor2Id() != null)
            vo.setMajor2Name(majorDao.getById(vo.getMajor2Id()).getData().getName());
        if(vo.getMajor3Id() != null)
            vo.setMajor3Name(majorDao.getById(vo.getMajor3Id()).getData().getName());
    }


    public ReturnObj<List<PaperVo>> getPaperListByUserId(int id) {
        try {
            var userRet = userDao.getById(id);
            if(!userRet.ok())
                return new ReturnObj<>(ReturnStatus.RESOURCE_ID_NOTEXIST);

            var ret = paperDao.getListByUserId(id);
            if(ret.ok()) {
                var list = new ArrayList<PaperVo>();
                for (var bo : ret.getData())
                    list.add(Common.clone(bo, PaperVo.class));
                for (var vo : list)
                    getPaperMajorName(vo);
                return new ReturnObj<>(list);
            }
            else {
                return new ReturnObj<>(ret.getStatus());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

    public ReturnObj<List<PaperVo>> getPaperListByUserIdAndName(Integer id, String name) {
        try {
            var userRet = userDao.getById(id);
            if(!userRet.ok())
                return new ReturnObj<>(ReturnStatus.RESOURCE_ID_NOTEXIST);

            var paper = new Paper();
            paper.setId(id);
            paper.setName(name);
            var ret = paperDao.getByUserIdAndName(paper);
            if(ret.ok()) {
                var list = new ArrayList<PaperVo>();
                for (var bo : ret.getData())
                    list.add(Common.clone(bo, PaperVo.class));
                for (var vo : list)
                    getPaperMajorName(vo);
                return new ReturnObj<>(list);
            }
            else {
                return new ReturnObj<>(ret.getStatus());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

    public ReturnObj<PaperVo> getPaperById(int id) {
        try {
            var ret = paperDao.getById(id);
            if(ret.ok()) {
                var vo = Common.clone(ret.getData(), PaperVo.class);
                getPaperMajorName(vo);
                return new ReturnObj<>(vo);
            }
            else {
                return new ReturnObj<>(ret.getStatus());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

    public ReturnObj<Integer> getPaperUserById(int paperId) {
        var ret = getPaperById(paperId);
        if(!ret.ok())
            return new ReturnObj<>(ret.getStatus());
        return new ReturnObj<>(ret.getData().getUserId());
    }

    public ReturnObj<PaperVo> createPaper(PaperVo paperProto) {
        try {
            // 检查用户
            var userRet = userDao.getById(paperProto.getUserId());
            if(!userRet.ok())
                return new ReturnObj<>(ReturnStatus.RESOURCE_ID_NOTEXIST);

            Integer major1 = paperProto.getMajor1Id();
            Integer major2 = paperProto.getMajor2Id();
            Integer major3 = paperProto.getMajor3Id();

            // 专业重复
            if(major1 != null && major1.equals(major2)
                    || major2 != null && major2.equals(major3)
                    || major3 != null && major3.equals(major1))
                return new ReturnObj<>(ReturnStatus.PAPER_MAJOR_INVALID);

            // 获取专业信息
            var majorList = new ArrayList<Major>();
            if(major1 != null) {
                var ret = majorDao.getById(major1);
                if(ret.ok())
                    majorList.add(ret.getData());
            }
            if(major2 != null) {
                var ret = majorDao.getById(major2);
                if(ret.ok())
                    majorList.add(ret.getData());
            }
            if(major3 != null) {
                var ret = majorDao.getById(major3);
                if(ret.ok())
                    majorList.add(ret.getData());
            }

            // 专业为空
            if(majorList.isEmpty())
                return new ReturnObj<>(ReturnStatus.PAPER_MAJOR_INVALID);

            // 抽取题目
            var quests = new ArrayList<Quest>();
            for(var major : majorList) {
                var ret1 = questDao.getListByMajorIdAndType(major.getId(), 1);
                var ret2 = questDao.getListByMajorIdAndType(major.getId(), 2);
                var ret3 = questDao.getListByMajorIdAndType(major.getId(), 3);
                var ret4 = questDao.getListByMajorIdAndType(major.getId(), 4);

                // 判断题目不足
                if(!ret1.ok() || ret1.getData().size() < major.getSingleSelectionNum()
                || !ret2.ok() || ret2.getData().size() < major.getMultipleSelectionNum()
                || !ret3.ok() || ret3.getData().size() < major.getJudgementNum()
                || !ret4.ok() || ret4.getData().size() < major.getShortAnswerNum())
                    return new ReturnObj<>(ReturnStatus.PAPER_MAJOR_NOT_ENOUGH_QUEST);

                // 洗牌
                Common.randomShuffle(ret1.getData(), randomGenerator);
                Common.randomShuffle(ret2.getData(), randomGenerator);
                Common.randomShuffle(ret3.getData(), randomGenerator);
                Common.randomShuffle(ret4.getData(), randomGenerator);

                // 抽取
                for(int i = 0; i < major.getSingleSelectionNum(); i++)
                    quests.add(ret1.getData().get(i));
                for(int i = 0; i < major.getMultipleSelectionNum(); i++)
                    quests.add(ret2.getData().get(i));
                for(int i = 0; i < major.getJudgementNum(); i++)
                    quests.add(ret3.getData().get(i));
                for(int i = 0; i < major.getShortAnswerNum(); i++)
                    quests.add(ret4.getData().get(i));
            }

            // 按题型排序
            quests.sort(Comparator.comparingInt(Quest::getTypeId));

            paperProto.setStartTime(new Date());
            paperProto.setIsEnded(false);
            paperProto.setQuestNum(quests.size());
            Paper paper = Common.clone(paperProto, Paper.class);

            // 插入试卷
            var ret = paperDao.insert(paper);
            if(!ret.ok())
                return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
            paper = ret.getData();

            // 插入题目
            for(int i = 0; i < quests.size(); i++)
            {
                PaperQuest paperQuest = new PaperQuest();
                paperQuest.setPaperId(paper.getId());
                paperQuest.setQuestId(quests.get(i).getId());
                paperQuest.setQuestIndex(i);
                paperQuest.setQuestAnswer("");
                // 插入
                if(!paperQuestDao.insert(paperQuest).ok())
                {
                    // 如果失败 需要删除之前的试卷和已经插入的paper_quest
                    paperQuestDao.deleteByPaperId(paper.getId());
                    paperDao.deleteById(paper.getId());
                    return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
                }
            }

            var vo = Common.clone(paper, PaperVo.class);
            getPaperMajorName(vo);
            return new ReturnObj<>(vo);

        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

    public ReturnObj<Object> deletePaperById(int id) {
        try {
            // 保存试卷副本
            var ret = paperDao.getById(id);
            if(ret.getData() == null)
                return new ReturnObj<>(ReturnStatus.RESOURCE_ID_NOTEXIST);

            // 删除试卷题目关系
            if(!paperQuestDao.deleteByPaperId(id).ok())
            {
                // 删除失败
                return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
            }

            // 删除试卷
            if(!paperDao.deleteById(id).ok())
                return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);

            return new ReturnObj<>(ReturnStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

    public ReturnObj<Object> submitPaper(PaperUserAnswerVo paperUserAnswerVo) {
        try {

            var paperRet = paperDao.getById(paperUserAnswerVo.getId());
            if(!paperRet.ok())
                return new ReturnObj<>(paperRet.getStatus());
            var paper = paperRet.getData();

            // 之前已经结束
            if(paper.getIsEnded())
                return new ReturnObj<>(ReturnStatus.PAPER_ENDED);

            // 更新试卷答案
            for(var paperQuestVo : paperUserAnswerVo.getAnswers())
            {
                var bo = Common.clone(paperQuestVo, PaperQuest.class);

                // 题目和试卷ID不一致
                if(!bo.getPaperId().equals(paper.getId()))
                    return new ReturnObj<>(ReturnStatus.PAPER_QUEST_ANSWER_INVALID);

                if(!paperQuestDao.updateByPaperAndQuestId(bo).ok())
                    return new ReturnObj<>(ReturnStatus.PAPER_QUEST_ANSWER_INVALID);
            }

            // 更新试卷为已结束
            paper.setIsEnded(true);
            paper.setEndTime(new Date());
            if(!paperDao.updateById(paper).ok())
                return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);

            return new ReturnObj<>(ReturnStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

    public ReturnObj<PaperUserAnswerVo> getPaperUserAnswerById(int id) {
        try {

            var paperRet = paperDao.getById(id);
            if(!paperRet.ok())
                return new ReturnObj<>(paperRet.getStatus());

            var paperAnswerVo = new PaperUserAnswerVo();
            paperAnswerVo.setAnswers(new ArrayList<>());

            // 获取试卷题目列表
            var questListRet = questDao.getListByPaperIdOrderByIndex(id);
            if(!questListRet.ok())
                return new ReturnObj<>(questListRet.getStatus());

            // 获取试卷题目答案
            for(var quest : questListRet.getData())
            {
                var key = new PaperQuest();
                key.setPaperId(id);
                key.setQuestId(quest.getId());
                var ret = paperQuestDao.selectByPrimaryKey(key);
                if(!ret.ok())
                    return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
                var vo = Common.clone(ret.getData(), PaperQuestVo.class);
                paperAnswerVo.getAnswers().add(vo);
            }

            return new ReturnObj<>(ReturnStatus.OK, paperAnswerVo);

        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

    /**
     * 获取用户简答答案使用
     */
    public String getUserAnswerByIds(int paperId, int questId){
        PaperQuest bo = new PaperQuest();
        bo.setPaperId(paperId);
        bo.setQuestId(questId);

        var res = paperQuestDao.selectByPrimaryKey(bo).getData();
        return res.getQuestAnswer();
    }

    /**
     * 获取简答题标答使用
     */
    public String getStandardAnswerById(int id){
        return questDao.getById(id).getData().getAnswer();
    }


}
