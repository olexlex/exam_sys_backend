package cn.edu.xmu.examonline.util;

import org.springframework.http.ResponseEntity;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Common {

    /**
     * 从一个类型对象克隆出一个另一个类型对象
     * 只会执行setter和getter匹配的字段的浅拷贝
     * 当需要在po、bo、vo互相转换时使用
     * @param src 源对象
     * @param dstClass 目标类型
     * @param <T1> 源类型
     * @param <T2> 目标类型
     * @return 目标对象
     */
    public static <T1, T2> T2 clone(T1 src, Class<T2> dstClass) {
        try {
            var srcClass = src.getClass();
            var dst = dstClass.getConstructor().newInstance();
            cloneTo(src, dst);
            return dst;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 从一个类型对象克隆部分或全部字段到另一个类型对象
     * 只会执行setter和getter匹配的字段的浅拷贝
     * 当需要在po、bo、vo互相转换时使用
     * @param src 源对象
     * @param dst 目标对象
     * @param <T1> 源类型
     * @param <T2> 目标类型
     */
    public static <T1, T2> void cloneTo(T1 src, T2 dst) {
        try {
            var srcClass = src.getClass();
            var dstClass = dst.getClass();
            for(var srcMethod : srcClass.getMethods()) {
                var name = srcMethod.getName();
                if(!name.startsWith("get") || srcMethod.getReturnType().equals(void.class))
                    continue;
                name = "set" + name.substring(3);
                Method dstMethod = null;
                try { dstMethod = dstClass.getMethod(name, srcMethod.getReturnType()); }
                catch (NoSuchMethodException e) { continue; }
                dstMethod.invoke(dst, srcMethod.invoke(src));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 从返回对象构建HTTP回应对象
     * @param returnObj 返回对象
     * @return HTTP回应对象
     */
    public static Object getResponseObject(ReturnObj returnObj) {
            Map<String, Object> obj = new HashMap<String, Object>();
            obj.put("errno", returnObj.getStatus().getNo());
            obj.put("errmsg", returnObj.getStatus().getMessage());
            obj.put("data", returnObj.getData());
            return new ResponseEntity(obj, returnObj.getStatus().getHttpStatus());
    }

    /**
     * 从返回状态构建HTTP回应对象
     * @param status 返回状态
     * @return HTTP回应对象
     */
    public static Object getResponseObject(ReturnStatus status) {
        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put("errno", status.getNo());
        obj.put("errmsg", status.getMessage());
        obj.put("data", null);
        return new ResponseEntity(obj, status.getHttpStatus());
    }

    /**
     * 随机排列顺序
     * @param list 要随机排列的ArrayList
     * @param rng 随机数生成器
     * @param <T> 元素类型
     */
    public static <T>void randomShuffle(ArrayList<T> list, Random rng) {
        for(int i = 1; i < list.size(); i++) {
            int j = rng.nextInt(i + 1);
            var tmp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, tmp);
        }
    }
}
