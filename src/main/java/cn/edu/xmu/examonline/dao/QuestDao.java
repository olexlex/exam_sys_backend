package cn.edu.xmu.examonline.dao;

import cn.edu.xmu.examonline.mapper.*;
import cn.edu.xmu.examonline.model.bo.Quest;
import cn.edu.xmu.examonline.model.po.QuestPo;
import cn.edu.xmu.examonline.util.Common;
import cn.edu.xmu.examonline.util.ReturnStatus;
import cn.edu.xmu.examonline.util.ReturnObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class QuestDao {

    @Autowired
    private QuestPoMapper questPoMapper;


    public ReturnObj<List<Quest>> getList() {
        try {
            var ret = new ArrayList<Quest>();
            for(var po : questPoMapper.selectAll())
                ret.add(Common.clone(po, Quest.class));
            return new ReturnObj<>(ret);
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

    public ReturnObj<List<Quest>> getListByMajorId(int id) {
        try {
            var ret = new ArrayList<Quest>();
            for(var po : questPoMapper.selectByMajorId(id))
                ret.add(Common.clone(po, Quest.class));
            return new ReturnObj<>(ret);
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

    public ReturnObj<ArrayList<Quest>> getListByMajorIdAndType(int id, int type) {
        try {
            var ret = new ArrayList<Quest>();
            for(var po : questPoMapper.selectByMajorId(id))
                if(po.getTypeId() == type)
                    ret.add(Common.clone(po, Quest.class));
            return new ReturnObj<>(ret);
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

    public ReturnObj<List<Quest>> getListByPaperIdOrderByIndex(int id) {
        try {
            var ret = new ArrayList<Quest>();
            for(var po : questPoMapper.selectByPaperId(id))
                ret.add(Common.clone(po, Quest.class));
            return new ReturnObj<>(ret);
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

    public ReturnObj<Quest> getById(int id) {
        try {
            var po = questPoMapper.selectByPrimaryKey(id);
            if(po == null) {
                return new ReturnObj<>(ReturnStatus.RESOURCE_ID_NOTEXIST);
            }
            return new ReturnObj<>(Common.clone(po, Quest.class));
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

    public ReturnObj<Quest> insert(Quest quest) {
        try {
            var po = Common.clone(quest, QuestPo.class);
            questPoMapper.insert(po);
            return new ReturnObj<>(Common.clone(po, Quest.class));
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

    public ReturnObj<Object> deleteById(int id) {
        try {
            var po = questPoMapper.selectByPrimaryKey(id);
            if(po == null) {
                return new ReturnObj<>(ReturnStatus.RESOURCE_ID_NOTEXIST);
            }
            questPoMapper.deleteByPrimaryKey(id);
            return new ReturnObj<>(ReturnStatus.OK);
        } catch (DataIntegrityViolationException e) {
            return new ReturnObj<>(ReturnStatus.QUEST_IN_PAPER);
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

    public ReturnObj<Object> updateById(Quest quest) {
        try {
            var po = questPoMapper.selectByPrimaryKey(quest.getId());
            if(po == null) {
                return new ReturnObj<>(ReturnStatus.RESOURCE_ID_NOTEXIST);
            }
            po = Common.clone(quest, QuestPo.class);
            questPoMapper.updateByPrimaryKey(po);
            return new ReturnObj<>(ReturnStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

}
