package com.hzh.nice.http.base;


import com.hzh.logger.L;
import com.hzh.nice.http.AppException;
import com.hzh.nice.http.inter.Result;
import com.hzh.nice.http.util.ParseFactory;

/**
 * Created by XuYang on 2016/12/28.
 */

public class ApiUtil {
    private static boolean isDebug = false;

    public static boolean isDebug() {
        return isDebug;
    }

    public static void setIsDebug(boolean isDebug) {
        ApiUtil.isDebug = isDebug;
    }

    /**
     * 获取代码执行所在方法名称
     *
     * @param ste 方法栈
     * @return 代码执行所在方法的方法名称
     */
    public static String createTag(StackTraceElement ste[]) {
        String methodName = "";
        boolean flag = false;
        for (StackTraceElement s : ste) {
            if (flag) {
                methodName = s.getMethodName();
                break;
            }
            flag = s.getMethodName().equals("getStackTrace");
        }
        return methodName;
    }

    public static Result parseResult(Class clazz, String result) throws AppException {
        Result res;
        try {
            res = ParseFactory.getInstance().parse(result, clazz);
        } catch (Exception e) {
            throw AppException.json(e);
        }
        return res;
    }

    public static void printRequest(String url, ApiParams params) {
        if (isDebug) {
            L.d(url);
            L.d(params);
        }
    }

    public static void printResult(String clazzName, String result) {
        if (isDebug) {
            L.d(clazzName);
            L.json(result);
        }
    }
}
