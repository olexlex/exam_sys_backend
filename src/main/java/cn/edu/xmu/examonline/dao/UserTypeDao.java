package cn.edu.xmu.examonline.dao;

import cn.edu.xmu.examonline.mapper.UserTypePoMapper;
import cn.edu.xmu.examonline.model.bo.User;
import cn.edu.xmu.examonline.model.bo.UserType;
import cn.edu.xmu.examonline.model.po.UserPo;
import cn.edu.xmu.examonline.model.po.UserTypePo;
import cn.edu.xmu.examonline.util.Common;
import cn.edu.xmu.examonline.util.ReturnObj;
import cn.edu.xmu.examonline.util.ReturnStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserTypeDao {

    @Autowired
    private UserTypePoMapper userTypePoMapper;

    public ReturnObj<UserType> getById(int id){
        try {
            UserTypePo userTypePo = userTypePoMapper.selectByPrimaryKey(id);

            if (userTypePo == null) {
                return new ReturnObj<>(ReturnStatus.RESOURCE_ID_NOTEXIST);
            } else {
                UserType userType = Common.clone(userTypePo, UserType.class);
                return new ReturnObj<>(userType);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

    public ReturnObj<List<UserType>> getByName(String name){
        try {
            List<UserTypePo> userTypePoList = userTypePoMapper.selectByName(name);
            if(userTypePoList == null)
                return new ReturnObj<>(ReturnStatus.RESOURCE_ID_NOTEXIST);
            else {
                List<UserType> userTypeList = new ArrayList<>();
                for(var po : userTypePoList)
                    userTypeList.add(Common.clone(po, UserType.class));
                return new ReturnObj<>(userTypeList);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }

    }

    public ReturnObj<List<UserType>> getList() {
        try {
            var ret = userTypePoMapper.selectAll();
            if(ret == null)
                return new ReturnObj<>(ReturnStatus.RESOURCE_ID_NOTEXIST);
            else {
                List<UserType> userList = new ArrayList<>();
                for (var po : ret)
                    userList.add(Common.clone(po, UserType.class));
                return new ReturnObj<>(userList);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

    public ReturnObj<UserType> insert(UserType userType){
        try {
            var po = Common.clone(userType, UserTypePo.class);
            userTypePoMapper.insert(po);
            return new ReturnObj<>(Common.clone(po, UserType.class));
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

    public ReturnObj<Object> deleteById(int id) {
        try {
            var po = userTypePoMapper.selectByPrimaryKey(id);
            if(po == null) {
                return new ReturnObj<>(ReturnStatus.RESOURCE_ID_NOTEXIST);
            }
            userTypePoMapper.deleteByPrimaryKey(id);
            return new ReturnObj<>(ReturnStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

    public ReturnObj<Object> deleteByName(String name) {
        try {
            var po = userTypePoMapper.selectByName(name);
            if(po == null) {
                return new ReturnObj<>(ReturnStatus.RESOURCE_ID_NOTEXIST);
            }
            userTypePoMapper.deleteByName(name);
            return new ReturnObj<>(ReturnStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

    public ReturnObj<Object> updateById(UserType user){
        try {
            var po = userTypePoMapper.selectByPrimaryKey(user.getId());
            if(po == null) {
                return new ReturnObj<>(ReturnStatus.RESOURCE_ID_NOTEXIST);
            }
            po = Common.clone(user, UserTypePo.class);
            userTypePoMapper.updateByPrimaryKey(po);
            return new ReturnObj<>(ReturnStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }


}
