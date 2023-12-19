package cn.edu.xmu.examonline.service;

import cn.edu.xmu.examonline.dao.MajorDao;
import cn.edu.xmu.examonline.model.bo.Major;
import cn.edu.xmu.examonline.model.vo.MajorVo;
import cn.edu.xmu.examonline.util.Common;
import cn.edu.xmu.examonline.util.ReturnObj;
import cn.edu.xmu.examonline.util.ReturnStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MajorService {

    static final int MUST_MAJOR_ID = 1;

    @Autowired
    MajorDao majorDao;

    public ReturnObj<List<MajorVo>> getMajorByName(String name) {
        try {
            var ret = majorDao.getByName(name);
            if(ret.ok()) {
                var list = new ArrayList<MajorVo>();
                for (var bo : ret.getData())
                    list.add(Common.clone(bo, MajorVo.class));
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


    public ReturnObj<List<MajorVo>> getMajorList() {
        try {
            var ret = majorDao.getList();
            if(ret.ok()) {
                var list = new ArrayList<MajorVo>();
                for (var bo : ret.getData())
                    list.add(Common.clone(bo, MajorVo.class));
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

    public ReturnObj<MajorVo> getMajorById(int id) {
        try {
            var ret = majorDao.getById(id);
            if(ret.ok()) {
                return new ReturnObj<>(Common.clone(ret.getData(), MajorVo.class));
            }
            else {
                return new ReturnObj<>(ret.getStatus());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

    public ReturnObj<MajorVo> insertMajor(MajorVo major) {
        try {
            var ret = majorDao.insert(Common.clone(major, Major.class));
            if(ret.ok()) {
                return new ReturnObj<>(Common.clone(ret.getData(), MajorVo.class));
            }

            else {
                return new ReturnObj<>(ret.getStatus());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

    public ReturnObj<Object> deleteMajorById(int id) {
        try {
            return majorDao.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

    public ReturnObj<Object> updateMajorById(MajorVo major) {
        try {
            return majorDao.updateById(Common.clone(major, Major.class));
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }
}
