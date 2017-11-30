package com.hzh.nice.http;

import android.content.Context;

import com.hzh.nice.http.base.Api;
import com.hzh.nice.http.inter.Parser;
import com.hzh.nice.http.inter.Printer;


/**
 * 接口请求类
 */
public class NiceApiClient {
    //是否已经初始化
    private static boolean isInited = false;
    private Context context;
    //Api实现类
    private Api api;
    //Json反序列化解析器
    private Parser parser;
    //Log打印器
    private Printer printer;

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
            throw new RuntimeException("必须首先调用init()方法初始化");
        }
        return Singleton.instance;
    }

    /**
     * 初始化
     *
     * @param context 上下文
     * @param config  配置类
     */
    public static NiceApiClient init(Context context, NiceHttpConfig config) {
        NiceApiClient instance = Singleton.instance;
        instance.context = context.getApplicationContext();
        instance.api = config.getApi();
        instance.parser = config.getParser();
        instance.printer = config.getPrinter();
        instance.printer.setDebug(config.isDebug());
        isInited = true;
        return instance;
    }

    /**
     * 获取具体Api实现类
     *
     * @return api实现类
     */
    public <T extends Api> T getApi() {
        return (T) api;
    }

    /**
     * 获取配置的Json反序列化解析器
     *
     * @return 配置的parser解析器实例
     */
    public Parser getParser() {
        return parser;
    }

    /**
     * 获取配置的Log打印器
     *
     * @return 配置Log打印器
     */
    public Printer getPrinter() {
        return printer;
    }
}