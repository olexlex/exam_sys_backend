package cn.edu.xmu.examonline.service;

import cn.edu.xmu.examonline.dao.UserDao;
import cn.edu.xmu.examonline.dao.UserProfileDao;
import cn.edu.xmu.examonline.dao.UserTypeDao;
import cn.edu.xmu.examonline.model.bo.User;
import cn.edu.xmu.examonline.model.bo.UserProfile;
import cn.edu.xmu.examonline.model.bo.UserType;
import cn.edu.xmu.examonline.model.vo.UserProfileVo;
import cn.edu.xmu.examonline.model.vo.UserTypeVo;
import cn.edu.xmu.examonline.model.vo.UserVo;
import cn.edu.xmu.examonline.util.Common;
import cn.edu.xmu.examonline.util.ReturnObj;
import cn.edu.xmu.examonline.util.ReturnStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserProfileDao userProfileDao;

    @Autowired
    private UserTypeDao userTypeDao;

    @Autowired
    private PaperService paperService;

    /**
     * 对用户（User表）进行查询操作
     * @return VO
     */
    public ReturnObj<List<UserVo>> getUserList(){
        try{
            var ret = userDao.getList();
            if(ret.ok()){
                var list = new ArrayList<UserVo>();
                for(var bo : ret.getData()){
                    list.add(Common.clone(bo, UserVo.class));
                }
                return new ReturnObj<List<UserVo>>(list);
            }
            else{
                return new ReturnObj<>(ret.getStatus());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

    public ReturnObj<UserVo> getUserById(int id){
        try{
            var ret = userDao.getById(id);
            if(ret.ok()){
                return new ReturnObj<>(Common.clone(ret.getData(), UserVo.class));
            }
            else {
                return new ReturnObj<>(ret.getStatus());
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

    public ReturnObj<UserVo> getUserByName(String name){
        try{
            var ret = userDao.getByName(name);
            if(ret.ok()){
                return new ReturnObj<>(Common.clone(ret.getData(), UserVo.class));
            }
            else{
                return new ReturnObj<>(ret.getStatus());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

    public ReturnObj<List<UserVo>> getUserListByType(int type){
        try{
            if(!userTypeDao.getById(type).ok())
                return new ReturnObj<>(ReturnStatus.RESOURCE_ID_NOTEXIST);

            var ret = userDao.getByType(type);
            if(ret.ok()){
                var list = new ArrayList<UserVo>();
                for(var bo : ret.getData()){
                    list.add(Common.clone(bo, UserVo.class));
                }
                return new ReturnObj<>(list);
            }
            else{
                return new ReturnObj<>(ret.getStatus());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

    /**
     * 创建普通用户，同时创建用户Profile
     * @return VO
     */
    public ReturnObj<UserVo> createCommonUser(UserVo user){
        try {

            var userRet = userDao.getByName(user.getName());
            if(userRet.ok())
                return new ReturnObj<>(ReturnStatus.USER_NAME_DUPLICATED);

            user.setTypeId(2);

            var ret = userDao.insert(Common.clone(user, User.class));
            if(!ret.ok())
                return new ReturnObj<>(ret.getStatus());

            var profile = new UserProfile();
            profile.setUserId(ret.getData().getId());
            var profileRet = userProfileDao.insert(profile);
            if(!profileRet.ok())
                return new ReturnObj<>(profileRet.getStatus());

            return new ReturnObj<>(Common.clone(ret.getData(), UserVo.class));
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

    /**
     * 创建管理员用户，同时创建用户Profile
     * @return VO
     */
    public ReturnObj<UserVo> createAdminUser(UserVo user){
        try {

            var userRet = userDao.getByName(user.getName());
            if(userRet.ok())
                return new ReturnObj<>(ReturnStatus.USER_NAME_DUPLICATED);

            user.setTypeId(1);

            var ret = userDao.insert(Common.clone(user, User.class));
            if(!ret.ok())
                return new ReturnObj<>(ret.getStatus());

            var profile = new UserProfile();
            profile.setUserId(ret.getData().getId());
            var profileRet = userProfileDao.insert(profile);
            if(!profileRet.ok())
                return new ReturnObj<>(profileRet.getStatus());

            return new ReturnObj<>(Common.clone(ret.getData(), UserVo.class));
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

    /**
     * 对用户（User表）进行更新操作
     * @return Object
     */
    public ReturnObj<Object> updateUserById(UserVo user){
        try{
            return userDao.updateById(Common.clone(user, User.class));
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

    /**
     * 对用户（User表）进行删除操作 同时删除用户Profile 和用户的试卷
     * @return Object
     */

    public ReturnObj<Object> deleteUserById(int id){
        try{
            var paperRet = paperService.getPaperListByUserId(id);
            if(!paperRet.ok())
                return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);

            var paperList = paperRet.getData();
            for(var paper : paperList){
                var paperDeleteRet = paperService.deletePaperById(paper.getId());
                if(!paperDeleteRet.ok())
                    return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
            }

            var ret = userProfileDao.deleteById(id);
            if(!ret.ok())
                return ret;

            return userDao.deleteById(id);

        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }



    /**
     * 对用户详细信息（UserProfile表）进行查询操作
     * @return VO
     */
    public ReturnObj<List<UserProfileVo>> getUserProfileList(){
        try{
            var ret = userProfileDao.getList();
            if(ret.ok()){
                var list = new ArrayList<UserProfileVo>();
                for(var bo : ret.getData()){
                    var vo = Common.clone(bo, UserProfileVo.class);
                    var userRet = userDao.getById(bo.getUserId());
                    vo.setTypeId(userRet.getData().getTypeId());
                    list.add(vo);
                }
                return new ReturnObj<List<UserProfileVo>>(list);
            }
            else{
                return new ReturnObj<>(ret.getStatus());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

    public ReturnObj<UserProfileVo> getUserProfileById(int id){
        try{
            var ret = userProfileDao.getById(id);
            if(ret.ok()){
                return new ReturnObj<>(Common.clone(ret.getData(), UserProfileVo.class));
            }
            else {
                return new ReturnObj<>(ret.getStatus());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

    public ReturnObj<List<UserProfileVo>> getUserProfileByName(String name){
        try{
            var ret = userProfileDao.getByName(name);
            if(ret.ok()){
                var list = new ArrayList<UserProfileVo>();
                for(var bo : ret.getData()){
                    list.add(Common.clone(bo, UserProfileVo.class));
                }
                return new ReturnObj<List<UserProfileVo>>(list);
            }
            else{
                return new ReturnObj<>(ret.getStatus());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

    /**
     * 对用户详细信息（UserProfile表）进行插入操作
     * @return VO
     */
    public ReturnObj<UserProfileVo> insertUserProfile(UserProfileVo user){
        try {
            var ret = userProfileDao.insert(Common.clone(user, UserProfile.class));
            if(ret.ok()) {
                return new ReturnObj<>(Common.clone(ret.getData(), UserProfileVo.class));
            }
            else{
                return new ReturnObj<>(ret.getStatus());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

    /**
     * 对用户详细信息（UserProfile表）进行更新操作
     * @return Object
     */
    public ReturnObj<Object> updateUserProfileById(UserProfileVo user){
        try{
            return userProfileDao.updateById(Common.clone(user, UserProfile.class));
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

    /**
     * 对用户详细信息（UserProfile表）进行删除操作
     * @return Object
     */

    public ReturnObj<Object> deleteUserProfileById(int id){
        try{
            return userProfileDao.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }



    /**
     * 对用户详细信息（UserType表）进行查询操作
     * @return VO
     */
    public ReturnObj<List<UserTypeVo>> getUserTypeList(){
        try{
            var ret = userTypeDao.getList();
            if(ret.ok()){
                var list = new ArrayList<UserTypeVo>();
                for(var bo : ret.getData()){
                    list.add(Common.clone(bo, UserTypeVo.class));
                }
                return new ReturnObj<List<UserTypeVo>>(list);
            }
            else{
                return new ReturnObj<>(ret.getStatus());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

    public ReturnObj<UserTypeVo> getUserTypeById(int id){
        try{
            var ret = userDao.getById(id);
            if(ret.ok()){
                return new ReturnObj<>(Common.clone(ret.getData(), UserTypeVo.class));
            }
            else {
                return new ReturnObj<>(ret.getStatus());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

    public ReturnObj<List<UserTypeVo>> getUserTypeByName(String name){
        try{
            var ret = userTypeDao.getByName(name);
            if(ret.ok()){
                var list = new ArrayList<UserTypeVo>();
                for(var bo : ret.getData()){
                    list.add(Common.clone(bo, UserTypeVo.class));
                }
                return new ReturnObj<List<UserTypeVo>>(list);
            }
            else{
                return new ReturnObj<>(ret.getStatus());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

    /**
     * 对用户详细信息（UserType表）进行插入操作
     * @return VO
     */
    public ReturnObj<UserTypeVo> insertUserType(UserTypeVo user){
        try {
            var ret = userTypeDao.insert(Common.clone(user, UserType.class));
            if(ret.ok()) {
                return new ReturnObj<>(Common.clone(ret.getData(), UserTypeVo.class));
            }
            else{
                return new ReturnObj<>(ret.getStatus());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

    /**
     * 对用户详细信息（UserType表）进行更新操作
     * @return Object
     */
    public ReturnObj<Object> updateUserTypeById(UserTypeVo user){
        try{
            return userTypeDao.updateById(Common.clone(user, UserType.class));
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

    /**
     * 对用户详细信息（UserType表）进行删除操作
     * @return Object
     */

    public ReturnObj<Object> deleteUserTypeById(int id){
        try{
            return userTypeDao.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

}
