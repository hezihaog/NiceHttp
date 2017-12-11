package com.hzh.nice.http.sample;

import com.hzh.nice.http.NiceApiClient;
import com.hzh.nice.http.base.ApiParams;
import com.hzh.nice.http.util.ApiUtil;
import com.hzh.nice.http.callback.ApiCallback;
import com.hzh.nice.http.sample.bean.SearchEntity;
import com.hzh.nice.http.sample.util.Const;

/**
 * Package: com.hzh.nice.http.sample
 * FileName: RequestManager
 * Date: on 2017/11/26  下午9:15
 * Auther: zihe
 * Descirbe:
 * Email: hezihao@linghit.com
 */

public class RequestManager {
    public static void search(ApiCallback callback, String type, String count, String page) {
        ApiParams params = new ApiParams();
        params.add("count", count);
        params.add("page", page);
        NiceApiClient.getInstance().getApi()
                .get(callback, Const.Api.domain
                        + Const.Api.search
                        + "/" + type, params, SearchEntity.class, ApiUtil.createTag(Thread.currentThread().getStackTrace()));
    }
}