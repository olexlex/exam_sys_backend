package cn.edu.xmu.examonline.dao;

import cn.edu.xmu.examonline.mapper.UserPoMapper;
import cn.edu.xmu.examonline.model.bo.User;
import cn.edu.xmu.examonline.model.po.UserPo;
import cn.edu.xmu.examonline.util.Common;
import cn.edu.xmu.examonline.util.ReturnObj;
import cn.edu.xmu.examonline.util.ReturnStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao {

    @Autowired
    private UserPoMapper userPoMapper;

    public ReturnObj<User> getById(int Id){
        try {
            UserPo userPo = userPoMapper.selectByPrimaryKey(Id);
            if(userPo == null)
                return new ReturnObj<>(ReturnStatus.RESOURCE_ID_NOTEXIST);
            else {
                User user = Common.clone(userPo, User.class);
                return new ReturnObj<User>(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

    // 因为name字段修改为unique因此返回单个用户
    public ReturnObj<User> getByName(String name){
        try {
            List<UserPo> userPoList = userPoMapper.selectByName(name);
            if(userPoList == null || userPoList.size() == 0)
                return new ReturnObj<>(ReturnStatus.RESOURCE_ID_NOTEXIST);
            else {
                var user = Common.clone(userPoList.get(0), User.class);
                return new ReturnObj<>(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

    public ReturnObj<List<User>> getByType(int typeId){
        try {
            List<UserPo> userPoList = userPoMapper.selectByType(typeId);
            if(userPoList == null)
                return new ReturnObj<>(ReturnStatus.RESOURCE_ID_NOTEXIST);
            else {
                List<User> userList = new ArrayList<>();
                for(var po : userPoList)
                    userList.add(Common.clone(po, User.class));
                return new ReturnObj<>(userList);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

    public ReturnObj<List<User>> getList() {
        try {
            List<UserPo> userPoList = userPoMapper.selectAll();
            if(userPoList == null)
                return new ReturnObj<>(ReturnStatus.RESOURCE_ID_NOTEXIST);
            else {
                List<User> userList = new ArrayList<>();
                for (var po : userPoList)
                    userList.add(Common.clone(po, User.class));
                return new ReturnObj<>(userList);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

    public ReturnObj<User> insert(User user){
        try {
            var po = Common.clone(user, UserPo.class);
            userPoMapper.insert(po);
            return new ReturnObj<>(Common.clone(po, User.class));
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

    public ReturnObj<Object> deleteById(int id) {
        try {
            var po = userPoMapper.selectByPrimaryKey(id);
            if(po == null) {
                return new ReturnObj<>(ReturnStatus.RESOURCE_ID_NOTEXIST);
            }
            userPoMapper.deleteByPrimaryKey(id);
            return new ReturnObj<>(ReturnStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

    public ReturnObj<Object> deleteByName(String name) {
        try {
            var po = userPoMapper.selectByName(name);
            if(po == null) {
                return new ReturnObj<>(ReturnStatus.RESOURCE_ID_NOTEXIST);
            }
            userPoMapper.deleteByName(name);
            return new ReturnObj<>(ReturnStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

    public ReturnObj<Object> updateById(User user){
        try {
            var po = userPoMapper.selectByPrimaryKey(user.getId());
            if(po == null) {
                return new ReturnObj<>(ReturnStatus.RESOURCE_ID_NOTEXIST);
            }
            po = Common.clone(user, UserPo.class);
            userPoMapper.updateByPrimaryKey(po);
            return new ReturnObj<>(ReturnStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

}
