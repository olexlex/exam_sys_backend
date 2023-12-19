package cn.edu.xmu.examonline.authorization;

import cn.edu.xmu.examonline.authorization.exception.AuthException;
import cn.edu.xmu.examonline.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
public class AuthMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Autowired
    AuthService authService;

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        if (methodParameter.getParameterType().isAssignableFrom(AuthInfo.class)
                && methodParameter.hasParameterAnnotation(Auth.class)) {
            return true;
        }
        return false;
    }


    @Override
    public Object resolveArgument(MethodParameter methodParameter,
                                  ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest nativeWebRequest,
                                  WebDataBinderFactory webDataBinderFactory) throws AuthException {
        String token = nativeWebRequest.getHeader("Token");
        var payload = authService.verifyToken(token);
        var info = new AuthInfo();
        info.setUserId(Integer.parseInt(payload.get("userId")));
        info.setUserType(Integer.parseInt(payload.get("userType")));
        info.setUserName(payload.get("userName"));
        info.setToken(token);
        return info;
    }
}