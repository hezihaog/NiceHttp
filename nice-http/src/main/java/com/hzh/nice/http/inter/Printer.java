package com.hzh.nice.http.inter;

import com.hzh.nice.http.base.ApiParams;

/**
 * Package: com.hzh.nice.http.inter
 * FileName: Printer
 * Date: on 2017/11/30  下午10:47
 * Auther: zihe
 * Descirbe: Log打印抽象接口
 * Email: hezihao@linghit.com
 */

public interface Printer {
    /**
     * 是否是debug模式
     *
     * @param isDebug true为是debug模式，false为不是，可在此回调中设置Log是否输出
     */
    void setDebug(boolean isDebug);

    /**
     * 打印请求
     *
     * @param url    请求地址
     * @param params 请求参数
     */
    void printRequest(String url, ApiParams params);

    /**
     * 打印结果
     *
     * @param clazzName json反序列化数据bean的className
     * @param json      请求回来的json字符串
     */
    void printResult(String clazzName, String json);

    /**
     * verbose输出
     *
     * @param msg
     * @param args
     */
    void v(String msg, Object... args);

    void v(Object object);

    /**
     * debug输出
     *
     * @param msg
     * @param args
     */
    void d(String msg, Object... args);

    void d(Object object);

    /**
     * info输出
     *
     * @param msg
     * @param args
     */
    void i(String msg, Object... args);

    void i(Object object);

    /**
     * warn输出
     *
     * @param msg
     * @param args
     */
    void w(String msg, Object... args);

    void w(Object object);

    /**
     * error输出
     *
     * @param msg
     * @param args
     */
    void e(String msg, Object... args);

    void e(Object object);

    /**
     * assert输出
     *
     * @param msg
     * @param args
     */
    void wtf(String msg, Object... args);

    void wtf(Object object);

    /**
     * 打印json
     *
     * @param json
     */
    void json(String json);
}
