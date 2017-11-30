package com.hzh.nice.http;

import android.content.Context;

import com.hzh.logger.L;
import com.hzh.nice.http.base.Api;


/**
 * 接口请求类
 */
public class NiceApiClient {
    private static boolean isInited = false;
    private Context context;
    private Api api;

    private NiceApiClient() {
    }

    private static class Singleton {
        private static final NiceApiClient instance = new NiceApiClient();
    }

    /**
     * 获取接口请求类实例
     *
     * @return 接口请求类实例
     */
    public static NiceApiClient getInstance() {
        if (!isInited) {
            throw new IllegalStateException("必须首先调用init()方法初始化");
        }
        return Singleton.instance;
    }

    /**
     * 初始化
     *
     * @param context 上下文
     * @param config  配置类
     * @return
     */
    public static NiceApiClient init(Context context, NiceHttpConfig config) {
        NiceApiClient instance = Singleton.instance;
        instance.context = context;
        instance.api = config.getApi();
        L.configAllowLog(config.isDebug());
        isInited = true;
        return instance;
    }

    public <T extends Api> T getApi() {
        return (T) api;
    }
}