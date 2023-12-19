package cn.edu.xmu.examonline.dao;

import cn.edu.xmu.examonline.mapper.*;
import cn.edu.xmu.examonline.model.bo.Major;
import cn.edu.xmu.examonline.model.po.MajorPo;
import cn.edu.xmu.examonline.util.Common;
import cn.edu.xmu.examonline.util.ReturnStatus;
import cn.edu.xmu.examonline.util.ReturnObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MajorDao {

    @Autowired
    private MajorPoMapper majorPoMapper;

    public ReturnObj<List<Major>> getByName(String name) {
        try {
            var ret = new ArrayList<Major>();
            var list = majorPoMapper.selectByName(name);
            if(list != null)
                for(var po : list)
                    ret.add(Common.clone(po, Major.class));
            return new ReturnObj<>(ret);
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

    public ReturnObj<List<Major>> getList() {
        try {
            var ret = new ArrayList<Major>();
            var list = majorPoMapper.selectAll();
            if(list != null)
                for(var po : list)
                    ret.add(Common.clone(po, Major.class));
            return new ReturnObj<>(ret);
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

    public ReturnObj<Major> getById(int id) {
        try {
            var po = majorPoMapper.selectByPrimaryKey(id);
            if(po == null) {
                return new ReturnObj<>(ReturnStatus.RESOURCE_ID_NOTEXIST);
            }
            return new ReturnObj<>(Common.clone(po, Major.class));
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

    public ReturnObj<Major> insert(Major major) {
        try {
            var po = Common.clone(major, MajorPo.class);
            majorPoMapper.insert(po);
            return new ReturnObj<>(Common.clone(po, Major.class));
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

    public ReturnObj<Object> deleteById(int id) {
        try {
            var po = majorPoMapper.selectByPrimaryKey(id);
            if(po == null) {
                return new ReturnObj<>(ReturnStatus.RESOURCE_ID_NOTEXIST);
            }
            majorPoMapper.deleteByPrimaryKey(id);
            return new ReturnObj<>(ReturnStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

    public ReturnObj<Object> updateById(Major major) {
        try {
            var po = majorPoMapper.selectByPrimaryKey(major.getId());
            if(po == null) {
                return new ReturnObj<>(ReturnStatus.RESOURCE_ID_NOTEXIST);
            }
            po = Common.clone(major, MajorPo.class);
            majorPoMapper.updateByPrimaryKey(po);
            return new ReturnObj<>(ReturnStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

}
