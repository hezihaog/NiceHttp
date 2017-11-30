package com.hzh.nice.http.util;


import com.hzh.nice.http.AppException;
import com.hzh.nice.http.NiceApiClient;
import com.hzh.nice.http.base.ApiParams;
import com.hzh.nice.http.inter.Printer;
import com.hzh.nice.http.inter.Result;

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
     * @param clazz 解析目标bean
     * @param json  json字符串
     * @return 数据bean
     * @throws AppException 可能解析失败产生的异常
     */
    public static Result parseResult(Class clazz, String json) throws AppException {
        Result res;
        try {
            res = ParseFactory.getInstance().parse(NiceApiClient.getInstance().getParser(), json, clazz);
        } catch (Exception e) {
            throw AppException.json(e);
        }
        return res;
    }

    /**
     * 打印请求
     *
     * @param url    请求地址
     * @param params 请求参数
     */
    public static void printRequest(String url, ApiParams params) {
        Printer printer = NiceApiClient.getInstance().getPrinter();
        if (printer != null) {
            printer.printRequest(url, params);
        }
    }

    /**
     * 打印结果
     *
     * @param clazzName json反序列化数据bean的className
     * @param json      请求回来的json字符串
     */
    public static void printResult(String clazzName, String json) {
        Printer printer = NiceApiClient.getInstance().getPrinter();
        if (printer != null) {
            printer.printResult(clazzName, json);
        }
    }
}
