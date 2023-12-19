package cn.edu.xmu.examonline.service;

import cn.edu.xmu.examonline.dao.MajorDao;
import cn.edu.xmu.examonline.dao.PaperDao;
import cn.edu.xmu.examonline.dao.PaperQuestDao;
import cn.edu.xmu.examonline.dao.QuestDao;
import cn.edu.xmu.examonline.model.bo.Quest;
import cn.edu.xmu.examonline.model.vo.QuestVo;
import cn.edu.xmu.examonline.util.Common;
import cn.edu.xmu.examonline.util.ReturnObj;
import cn.edu.xmu.examonline.util.ReturnStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestService {

    @Autowired
    QuestDao questDao;

    @Autowired
    MajorDao majorDao;

    @Autowired
    PaperDao paperDao;


    private void getQuestMajorName(QuestVo vo)
    {
        vo.setMajorName(majorDao.getById(vo.getMajorId()).getData().getName());
    }

    public ReturnObj<List<QuestVo>> getQuestList() {
        try {
            var ret = questDao.getList();
            if(ret.ok()) {
                var list = new ArrayList<QuestVo>();
                for (var bo : ret.getData())
                    list.add(Common.clone(bo, QuestVo.class));
                for (var vo : list)
                    getQuestMajorName(vo);
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

    public ReturnObj<List<QuestVo>> getQuestByMajorId(int id) {
        try {
            var majorRet = majorDao.getById(id);
            if(!majorRet.ok())
                return new ReturnObj<>(ReturnStatus.RESOURCE_ID_NOTEXIST);

            var ret = questDao.getListByMajorId(id);
            if(ret.ok()) {
                var list = new ArrayList<QuestVo>();
                for (var bo : ret.getData())
                    list.add(Common.clone(bo, QuestVo.class));
                for (var vo : list)
                    getQuestMajorName(vo);
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

    public ReturnObj<List<QuestVo>> getQuestByMajorIdAndType(int id, int type) {
        try {
            var majorRet = majorDao.getById(id);
            if(!majorRet.ok())
                return new ReturnObj<>(ReturnStatus.RESOURCE_ID_NOTEXIST);

            var ret = questDao.getListByMajorIdAndType(id, type);
            if(ret.ok()) {
                var list = new ArrayList<QuestVo>();
                for (var bo : ret.getData())
                    list.add(Common.clone(bo, QuestVo.class));
                for (var vo : list)
                    getQuestMajorName(vo);
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

    public ReturnObj<List<QuestVo>> getQuestByPaperIdOrderByIndex(int id) {
        try {
            var paperRet = paperDao.getById(id);
            if(!paperRet.ok())
                return new ReturnObj<>(ReturnStatus.RESOURCE_ID_NOTEXIST);

            var ret = questDao.getListByPaperIdOrderByIndex(id);
            if(ret.ok()) {
                var list = new ArrayList<QuestVo>();
                for (var bo : ret.getData()) {
                    // 若试卷未结束则不暴露答案
                    if(!paperRet.getData().getIsEnded())
                        bo.setAnswer(null);
                    list.add(Common.clone(bo, QuestVo.class));
                }
                for (var vo : list)
                    getQuestMajorName(vo);
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

    public ReturnObj<QuestVo> getQuestById(int id) {
        try {
            var ret = questDao.getById(id);
            if(ret.ok()) {
                var vo = Common.clone(ret.getData(), QuestVo.class);
                getQuestMajorName(vo);
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

    public ReturnObj<QuestVo> insertQuest(QuestVo quest) {
        try {
            var ret = questDao.insert(Common.clone(quest, Quest.class));
            if(ret.ok()) {
                var vo = Common.clone(ret.getData(), QuestVo.class);
                getQuestMajorName(vo);
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

    public ReturnObj<Object> deleteQuestById(int id) {
        try {
            return questDao.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

    public ReturnObj<Object> updateQuestById(QuestVo quest) {
        try {
            return questDao.updateById(Common.clone(quest, Quest.class));
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }
}
