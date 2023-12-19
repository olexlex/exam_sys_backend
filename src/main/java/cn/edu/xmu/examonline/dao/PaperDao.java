package cn.edu.xmu.examonline.dao;

import cn.edu.xmu.examonline.mapper.PaperPoMapper;
import cn.edu.xmu.examonline.model.bo.Major;
import cn.edu.xmu.examonline.model.bo.Paper;
import cn.edu.xmu.examonline.model.po.MajorPo;
import cn.edu.xmu.examonline.model.po.PaperPo;
import cn.edu.xmu.examonline.util.Common;
import cn.edu.xmu.examonline.util.ReturnObj;
import cn.edu.xmu.examonline.util.ReturnStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PaperDao {

    @Autowired
    PaperPoMapper paperPoMapper;

    public ReturnObj<List<Paper>> getListByUserId(int id) {
        try {
            var ret = new ArrayList<Paper>();
            for(var po : paperPoMapper.selectByUserId(id))
                ret.add(Common.clone(po, Paper.class));
            return new ReturnObj<>(ret);
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

    public ReturnObj<Paper> getById(int id) {
        try {
            var po = paperPoMapper.selectByPrimaryKey(id);
            if(po == null) {
                return new ReturnObj<>(ReturnStatus.RESOURCE_ID_NOTEXIST);
            }
            return new ReturnObj<>(Common.clone(po, Paper.class));
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

    public ReturnObj<List<Paper>> getByUserIdAndName(Paper bo) {
        try {
            var ret = new ArrayList<Paper>();
            for(var po : paperPoMapper.selectByUserIdAndName(Common.clone(bo, PaperPo.class)))
                ret.add(Common.clone(po, Paper.class));
            return new ReturnObj<>(ret);
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

    public ReturnObj<Paper> insert(Paper paper) {
        try {
            var po = Common.clone(paper, PaperPo.class);
            paperPoMapper.insert(po);
            return new ReturnObj<>(Common.clone(po, Paper.class));
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

    public ReturnObj<Object> deleteById(int id) {
        try {
            var po = paperPoMapper.selectByPrimaryKey(id);
            if(po == null) {
                return new ReturnObj<>(ReturnStatus.RESOURCE_ID_NOTEXIST);
            }
            paperPoMapper.deleteByPrimaryKey(id);
            return new ReturnObj<>(ReturnStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

    public ReturnObj<Object> updateById(Paper paper) {
        try {
            var po = paperPoMapper.selectByPrimaryKey(paper.getId());
            if(po == null) {
                return new ReturnObj<>(ReturnStatus.RESOURCE_ID_NOTEXIST);
            }
            po = Common.clone(paper, PaperPo.class);
            paperPoMapper.updateByPrimaryKey(po);
            return new ReturnObj<>(ReturnStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

}
