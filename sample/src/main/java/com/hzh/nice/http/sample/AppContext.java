package com.hzh.nice.http.sample;

import android.app.Application;

import com.google.gson.Gson;
import com.hzh.nice.http.NiceApiClient;
import com.hzh.nice.http.NiceHttpConfig;
import com.hzh.nice.http.inter.Parser;
import com.hzh.nice.http.inter.Result;
import com.hzh.nice.http.okhttp3.connection.ApiByOkHttp;

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
        GsonParser parser = new GsonParser();
        //初始化
        NiceApiClient.init(getApplicationContext(),
                NiceHttpConfig.newBuild(new ApiByOkHttp(getApplicationContext(), parser),
                        parser).setDebug(BuildConfig.DEBUG).build());
    }

    /**
     * Gson转换器
     */
    private static class GsonParser implements Parser {

        @Override
        public <T extends Result> T parse(String json, Class<T> clazz) {
            return new Gson().fromJson(json, clazz);
        }
    }
}