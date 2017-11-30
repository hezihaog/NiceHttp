package com.hzh.nice.http.base;


import com.hzh.logger.L;
import com.hzh.nice.http.AppException;
import com.hzh.nice.http.inter.Parser;
import com.hzh.nice.http.inter.Result;
import com.hzh.nice.http.util.ParseFactory;

/**
 * Created by XuYang on 2016/12/28.
 * Api工具类
 */

public class ApiUtil {
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

    /**
     * 解析json
     *
     * @param parser 解析器
     * @param clazz  解析目标bean
     * @param json   json字符串
     * @return 数据bean
     * @throws AppException 可能解析失败产生的异常
     */
    public static Result parseResult(Parser parser, Class clazz, String json) throws AppException {
        Result res;
        try {
            res = ParseFactory.getInstance().parse(parser, json, clazz);
        } catch (Exception e) {
            throw AppException.json(e);
        }
        return res;
    }

    public static void printRequest(String url, ApiParams params) {
        L.d(url);
        L.d(params);
    }

    public static void printResult(String clazzName, String result) {
        L.d(clazzName);
        L.json(result);
    }
}
