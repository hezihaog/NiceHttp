package com.hzh.nice.http.sample;

import android.app.Application;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.hzh.logger.L;
import com.hzh.nice.http.NiceApiClient;
import com.hzh.nice.http.NiceHttpConfig;
import com.hzh.nice.http.base.ApiParams;
import com.hzh.nice.http.inter.Parser;
import com.hzh.nice.http.inter.Printer;
import com.hzh.nice.http.inter.Result;
import com.hzh.nice.http.okhttp3.connection.ApiByOkHttp;

import java.io.IOException;

/**
 * @package com.hzh.nice.http.sample
 * @fileName AppContext
 * @date on 2017/11/4  下午11:42
 * @auther zihe
 * @descirbe App所用Application类
 * @email hezihao@linghit.com
 */

public class AppContext extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //gson
        Parser gsonParser = new GsonParser();
        //fastJson
        Parser fastJsonParser = new FastJsonParser();
        //jackson
        Parser jacksonParser = new JacksonParser();

        //初始化
        NiceApiClient.init(getApplicationContext(),
                NiceHttpConfig
                        .newBuild(new ApiByOkHttp(getApplicationContext()), jacksonParser)
                        .customPrinter(new MyLogPrinter())
                        .setDebug(BuildConfig.DEBUG).build());
    }

    /**
     * 使用者自定义配置打印Log
     */
    private static class MyLogPrinter implements Printer {

        @Override
        public void setDebug(boolean isDebug) {
            L.configAllowLog(isDebug);
        }

        @Override
        public void printRequest(String url, ApiParams params) {
            L.d(url);
            L.d(params);
        }

        @Override
        public void printResult(String clazzName, String json) {
            L.d(clazzName);
            L.json(json);
        }

        @Override
        public void v(String msg, Object... args) {
            L.v(msg, args);
        }

        @Override
        public void v(Object object) {
            L.v(object);
        }

        @Override
        public void d(String msg, Object... args) {
            L.d(msg, args);
        }

        @Override
        public void d(Object object) {
            L.d(object);
        }

        @Override
        public void i(String msg, Object... args) {
            L.i(msg, args);
        }

        @Override
        public void i(Object object) {
            L.i(object);
        }

        @Override
        public void w(String msg, Object... args) {
            L.w(msg, args);
        }

        @Override
        public void w(Object object) {
            L.w(object);
        }

        @Override
        public void e(String msg, Object... args) {
            L.e(msg, args);
        }

        @Override
        public void e(Object object) {
            L.e(object);
        }

        @Override
        public void wtf(String msg, Object... args) {
            L.wtf(msg, args);
        }

        @Override
        public void wtf(Object object) {
            L.wtf(object);
        }

        @Override
        public void json(String json) {
            L.json(json);
        }
    }

    /**
     * Gson反序列化Json转换器
     */
    private static class GsonParser implements Parser {

        @Override
        public <T extends Result> T parse(String json, Class<T> clazz) {
            return new Gson().fromJson(json, clazz);
        }
    }

    /**
     * FastJson反序列化Json转换器
     */
    private static class FastJsonParser implements Parser {

        @Override
        public <T extends Result> T parse(String json, Class<T> clazz) {
            return JSON.parseObject(json, clazz);
        }
    }

    /**
     * Jackson反序列化Json转换器
     */
    private static class JacksonParser implements Parser {

        @Override
        public <T extends Result> T parse(String json, Class<T> clazz) {
            ObjectMapper mapper = new ObjectMapper();
            try {
                return mapper.readValue(json, clazz);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}