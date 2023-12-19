package cn.edu.xmu.examonline.dao;

import cn.edu.xmu.examonline.mapper.PaperQuestPoMapper;
import cn.edu.xmu.examonline.model.bo.Paper;
import cn.edu.xmu.examonline.model.bo.PaperQuest;
import cn.edu.xmu.examonline.model.po.PaperPo;
import cn.edu.xmu.examonline.model.po.PaperQuestPo;
import cn.edu.xmu.examonline.util.Common;
import cn.edu.xmu.examonline.util.ReturnObj;
import cn.edu.xmu.examonline.util.ReturnStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PaperQuestDao {

    @Autowired
    PaperQuestPoMapper paperQuestPoMapper;

    public ReturnObj<PaperQuest> selectByPrimaryKey(PaperQuest bo) {
        try {
            var po = paperQuestPoMapper.selectByPrimaryKey(Common.clone(bo, PaperQuestPo.class));
            if(po == null)
                return new ReturnObj<>(ReturnStatus.RESOURCE_ID_NOTEXIST);
            return new ReturnObj<>(Common.clone(po, PaperQuest.class));
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

    public ReturnObj<PaperQuest> insert(PaperQuest bo) {
        try {
            var po = Common.clone(bo, PaperQuestPo.class);
            paperQuestPoMapper.insert(po);
            return new ReturnObj<>(Common.clone(po, PaperQuest.class));
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

    public ReturnObj<Object> updateByPaperAndQuestId(PaperQuest bo) {
        try {
            var po = Common.clone(bo, PaperQuestPo.class);
            paperQuestPoMapper.updateByPrimaryKey(po);
            return new ReturnObj<>(ReturnStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

    public ReturnObj<Object> deleteByPaperId(int id) {
        try {
            paperQuestPoMapper.deleteByPaperId(id);
            return new ReturnObj<>(ReturnStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

    public ReturnObj<Object> deleteByQuestId(int id) {
        try {
            paperQuestPoMapper.deleteByQuestId(id);
            return new ReturnObj<>(ReturnStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

}
