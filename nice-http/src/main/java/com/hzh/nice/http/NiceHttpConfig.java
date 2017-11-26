package com.hzh.nice.http;

import com.hzh.nice.http.base.Api;

/**
 * Package: com.hzh.nice.http
 * FileName: NiceHttpConfig
 * Date: on 2017/11/9  下午6:24
 * Auther: zihe
 * Descirbe: 配置类
 * Email: hezihao@linghit.com
 */

public class NiceHttpConfig {
    private Api api;
    private boolean isDebug = false;

    private NiceHttpConfig(Builder builder) {
        this.api = builder.api;
        this.isDebug = builder.isDebug;
    }

    public static Builder newBuild(Api api) {
        return new Builder(api);
    }

    public Api getApi() {
        return api;
    }

    public boolean isDebug() {
        return isDebug;
    }

    public static class Builder {
        private Api api;
        private boolean isDebug = false;

        private Builder(Api api) {
            this.api = api;
        }

        public Builder setDebug(boolean debug) {
            isDebug = debug;
            return this;
        }

        public boolean isDebug() {
            return isDebug;
        }

        public Api getApi() {
            return api;
        }

        public NiceHttpConfig build() {
            return new NiceHttpConfig(this);
        }
    }
}
