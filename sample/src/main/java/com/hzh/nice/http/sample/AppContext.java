package com.hzh.nice.http.sample;

import android.app.Application;

import com.hzh.nice.http.NiceApiClient;
import com.hzh.nice.http.NiceHttpConfig;
import com.hzh.nice.http.impl.ApiByOkHttp;
import com.hzh.nice.http.util.LogUtil;

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
        //初始化
        NiceApiClient.init(getApplicationContext(),
                NiceHttpConfig.newBuild(new ApiByOkHttp(getApplicationContext())).setDebug(BuildConfig.DEBUG).build());
        LogUtil.getInstance().setDebugEnable(BuildConfig.DEBUG);
    }
}