package cn.edu.xmu.examonline.service;

import cn.edu.xmu.examonline.dao.UserDao;
import cn.edu.xmu.examonline.model.vo.LoginVo;
import cn.edu.xmu.examonline.util.JwtUtil;
import cn.edu.xmu.examonline.util.ReturnObj;
import cn.edu.xmu.examonline.util.ReturnStatus;
import cn.edu.xmu.examonline.authorization.exception.AuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class AuthService {

    // 用户登录token过期时间
    private final static int TOKEN_EXPIRE_SECOND = 60 * 60;


    // 用户token列表 这里原本应该用redis 简化直接使用Set
    private Set<String> tokenSet = new HashSet<>();
    
    @Autowired
    UserDao userDao;


    public Map<String, String> verifyToken(String token) throws AuthException {
        if(!tokenSet.contains(token))
            throw new AuthException(ReturnStatus.TOKEN_INVALID);

        try {
            var verify = JwtUtil.verify(token);
            var payload = new HashMap<String, String>();
            payload.put("userName", verify.getClaim("userName").asString());
            payload.put("userType", verify.getClaim("userType").asString());
            payload.put("userId", verify.getClaim("userId").asString());
            return payload;
        } catch (Exception e) {
            throw new AuthException(ReturnStatus.TOKEN_INVALID);
        }
    }

    public Map<String, String> verifyTokenWithAdminRequired(String token) throws AuthException {
        var payload = verifyToken(token);
        if(!payload.get("userType").equals("1"))
            throw new AuthException(ReturnStatus.FORBIDDEN);
        return payload;
    }

    public ReturnObj<LoginVo> login(String username, String password) {
        try {
            var ret = userDao.getByName(username);
            if(!ret.ok() || !ret.getData().getPassword().equals(password))
                return new ReturnObj<>(ReturnStatus.AUTH_WRONG_NAME_OR_PASSWORD);

            var payload = new HashMap<String, String>();
            payload.put("userName", ret.getData().getName());
            payload.put("userType", ret.getData().getTypeId().toString());
            payload.put("userId", ret.getData().getId().toString());

            var token = JwtUtil.getToken(payload, TOKEN_EXPIRE_SECOND);
            tokenSet.add(token);

            var vo = new LoginVo();
            vo.setId(ret.getData().getId());
            vo.setType(ret.getData().getTypeId());
            vo.setToken(token);

            return new ReturnObj<>(vo);

        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

    public ReturnObj<Object> logout(String token) {
        try {
            if(tokenSet.contains(token))
                tokenSet.remove(token);
            return new ReturnObj<>(ReturnStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObj<>(ReturnStatus.INTERNAL_SERVER_ERR);
        }
    }

}
