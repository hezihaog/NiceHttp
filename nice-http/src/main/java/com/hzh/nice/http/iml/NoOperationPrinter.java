package com.hzh.nice.http.iml;

import com.hzh.nice.http.base.ApiParams;
import com.hzh.nice.http.inter.Printer;

/**
 * Package: com.hzh.nice.http.iml
 * FileName: PrinterIml
 * Date: on 2017/11/30  下午11:03
 * Auther: zihe
 * Descirbe: Printer空实现
 * Email: hezihao@linghit.com
 */

public class NoOperationPrinter implements Printer {
    @Override
    public void setDebug(boolean isDebug) {

    }

    @Override
    public void printRequest(String url, ApiParams params) {

    }

    @Override
    public void printResult(String clazzName, String json) {

    }

    @Override
    public void v(String msg, Object... args) {

    }

    @Override
    public void v(Object object) {

    }

    @Override
    public void d(String msg, Object... args) {

    }

    @Override
    public void d(Object object) {

    }

    @Override
    public void i(String msg, Object... args) {

    }

    @Override
    public void i(Object object) {

    }

    @Override
    public void w(String msg, Object... args) {

    }

    @Override
    public void w(Object object) {

    }

    @Override
    public void e(String msg, Object... args) {

    }

    @Override
    public void e(Object object) {

    }

    @Override
    public void wtf(String msg, Object... args) {

    }

    @Override
    public void wtf(Object object) {

    }

    @Override
    public void json(String json) {

    }
}
