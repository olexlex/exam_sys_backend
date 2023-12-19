package cn.edu.xmu.examonline.dao;

import cn.edu.xmu.examonline.mapper.UserProfilePoMapper;
import cn.edu.xmu.examonline.model.bo.User;
import cn.edu.xmu.examonline.model.bo.UserProfile;
import cn.edu.xmu.examonline.model.po.UserPo;
import cn.edu.xmu.examonline.model.po.UserProfilePo;
import cn.edu.xmu.examonline.util.Common;
import cn.edu.xmu.examonline.util.ReturnObj;
import cn.edu.xmu.examonline.util.ReturnStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserProfileDao {

    @Autowired
    private UserProfilePoMapper userProfilePoMapper;

    public ReturnObj<UserProfile> getById (int id) {//可能需要修改与sql一致
        try {
            UserProfilePo userProfilePo = userProfilePoMapper.selectByPrimaryKey(id);
            if (userProfilePo == null){
                return new ReturnObj<>(ReturnStatus.RESOURCE_ID_NOTEXIST);
            }
            else{
                UserProfile userProfile = Common.clone(userProfilePo, UserProfile.class);
                return new ReturnObj<>(userProfile);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

    public ReturnObj<List<UserProfile>> getByName(String name){
        try {
            List<UserProfilePo> userProfilePoList = userProfilePoMapper.selectByName(name);
            if(userProfilePoList == null)
                return new ReturnObj<>(ReturnStatus.RESOURCE_ID_NOTEXIST);
            else {
                List<UserProfile> userProfileList = new ArrayList<>();
                for(var po : userProfilePoList)
                    userProfileList.add(Common.clone(po, UserProfile.class));
                return new ReturnObj<>(userProfileList);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }

    }

    public ReturnObj<List<UserProfile>> getList() {
        try {
            List<UserProfilePo> userPoList = userProfilePoMapper.selectAll();
            if(userPoList == null)
                return new ReturnObj<>(ReturnStatus.RESOURCE_ID_NOTEXIST);
            else {
                List<UserProfile> userList = new ArrayList<>();
                for (var po : userPoList)
                    userList.add(Common.clone(po, UserProfile.class));
                return new ReturnObj<>(userList);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

    public ReturnObj<UserProfile> insert(UserProfile userProfile){
        try {
            var po = Common.clone(userProfile, UserProfilePo.class);
            userProfilePoMapper.insert(po);
            return new ReturnObj<>(Common.clone(po, UserProfile.class));
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

    public ReturnObj<Object> deleteById(int id) {
        try {
            var po = userProfilePoMapper.selectByPrimaryKey(id);
            if(po == null) {
                return new ReturnObj<>(ReturnStatus.RESOURCE_ID_NOTEXIST);
            }
            userProfilePoMapper.deleteByPrimaryKey(id);
            return new ReturnObj<>(ReturnStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

    public ReturnObj<Object> deleteByName(String name) {
        try {
            var po = userProfilePoMapper.selectByName(name);
            if(po == null) {
                return new ReturnObj<>(ReturnStatus.RESOURCE_ID_NOTEXIST);
            }
            userProfilePoMapper.deleteByName(name);
            return new ReturnObj<>(ReturnStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

    public ReturnObj<Object> updateById(UserProfile user){
        try {
            var po = userProfilePoMapper.selectByPrimaryKey(user.getId());
            if(po == null) {
                return new ReturnObj<>(ReturnStatus.RESOURCE_ID_NOTEXIST);
            }
            po = Common.clone(user, UserProfilePo.class);
            userProfilePoMapper.updateByPrimaryKey(po);
            return new ReturnObj<>(ReturnStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

}
