package com.hzh.nice.http.base;


import com.hzh.nice.http.callback.ApiCallback;
import com.hzh.nice.http.inter.Result;

/**
 * 接口请求类
 */
public interface Api {
    /**
     * 同步get
     *
     * @param url    请求地址
     * @param params 请求参数
     * @param clazz  对应的实体bean
     * @return
     * @throws Exception
     */
    Result getSync(String url, ApiParams params, final Class clazz) throws Exception;

    /**
     * 异步get
     *
     * @param callback 回调实例对象
     * @param url      请求地址
     * @param params   请求参数
     * @param clazz    对应的实体bean
     * @param tag      请求的方法名
     */
    void get(final ApiCallback callback, final String url, final ApiParams params, final Class clazz, final String tag);

    /**
     * 同步post
     *
     * @param url    请求地址
     * @param params 请求参数
     * @param clazz  对应的实体bean
     * @return
     * @throws Exception
     */
    Result postSync(String url, ApiParams params, final Class clazz) throws Exception;

    /**
     * 异步post
     *
     * @param callback 回调实例
     * @param url      请求地址
     * @param params   请求参数
     * @param clazz    对应的实体bean
     * @param tag      调用的方法名
     */
    void post(final ApiCallback callback, final String url, final ApiParams params, final Class clazz, final String tag);
}