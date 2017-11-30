package com.hzh.nice.http;

import com.hzh.nice.http.base.Api;
import com.hzh.nice.http.iml.NoOperationPrinter;
import com.hzh.nice.http.inter.Parser;
import com.hzh.nice.http.inter.Printer;

/**
 * Package: com.hzh.nice.http
 * FileName: NiceHttpConfig
 * Date: on 2017/11/9  下午6:24
 * Auther: zihe
 * Descirbe: 配置类
 * Email: hezihao@linghit.com
 */

public class NiceHttpConfig {
    //Api实现类
    private Api api;
    //是否为debug模式
    private boolean isDebug = false;
    //json反序列化解析器
    private Parser parser;
    //Log输出器
    private Printer printer;

    private NiceHttpConfig(Builder builder) {
        this.api = builder.api;
        this.isDebug = builder.isDebug;
        this.parser = builder.getParser();
        this.printer = builder.printer;
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

    public Printer getPrinter() {
        return printer;
    }

    public static class Builder {
        private Api api;
        private Parser parser;
        private boolean isDebug = false;
        private Printer printer = new NoOperationPrinter();

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

        /**
         * Log打印实现类，使用者使用该方法去转调自己的Log框架
         *
         * @param printer 打印接口
         */
        public Builder customPrinter(Printer printer) {
            this.printer = printer;
            return this;
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
