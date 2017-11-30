package com.hzh.nice.http;

import com.hzh.nice.http.base.Api;
import com.hzh.nice.http.inter.Parser;

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
    private Parser parser;

    private NiceHttpConfig(Builder builder) {
        this.api = builder.api;
        this.isDebug = builder.isDebug;
    }

    public static Builder newBuild(Api api, Parser parser) {
        return new Builder(api, parser);
    }

    public Api getApi() {
        return api;
    }

    public boolean isDebug() {
        return isDebug;
    }

    public Parser getParser() {
        return parser;
    }

    public static class Builder {
        private Api api;
        private Parser parser;
        private boolean isDebug = false;

        private Builder(Api api, Parser parser) {
            this.api = api;
            this.parser = parser;
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

        public Parser getParser() {
            return parser;
        }

        public NiceHttpConfig build() {
            return new NiceHttpConfig(this);
        }
    }
}
