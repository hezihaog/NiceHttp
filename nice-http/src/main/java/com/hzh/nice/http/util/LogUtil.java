package com.hzh.nice.http.util;

import com.apkfuns.logutils.LogUtils;

/**
 * Created by Hezihao on 2017/7/6.
 */

public class LogUtil {
    private static boolean debugEnable = false;

    private LogUtil() {
    }

    private static class Singleton {
        private static final LogUtil instance = new LogUtil();
    }

    public static LogUtil getInstance() {
        return Singleton.instance;
    }

    public static LogUtil init() {
        LogUtil instance = getInstance();
        LogUtils.getLogConfig().configAllowLog(debugEnable).configShowBorders(false);
        return instance;
    }

    public void setDebugEnable(boolean enable) {
        debugEnable = enable;
    }

    public boolean isDebugEnable() {
        return debugEnable;
    }

    public static void tag(String tag) {
        LogUtils.tag(tag);
    }

    public static void v(String msg, Object... args) {
        LogUtils.v(msg, args);
    }

    public static void v(Object object) {
        LogUtils.v(object);
    }

    public static void d(String msg, Object... args) {
        LogUtils.d(msg, args);
    }

    public static void d(Object object) {
        LogUtils.d(object);
    }

    public static void i(String msg, Object... args) {
        LogUtils.i(msg, args);
    }

    public static void i(Object object) {
        LogUtils.i(object);
    }

    public static void w(String msg, Object... args) {
        LogUtils.w(msg, args);
    }

    public static void w(Object object) {
        LogUtils.w(object);
    }

    public static void e(String msg, Object... args) {
        LogUtils.e(msg, args);
    }

    public static void e(Object object) {
        LogUtils.e(object);
    }

    public static void wtf(String msg, Object... args) {
        LogUtils.wtf(msg, args);
    }

    public static void wtf(Object object) {
        LogUtils.wtf(object);
    }

    public static void json(String json) {
        LogUtils.json(json);
    }

    public static void xml(String xml) {
        LogUtils.xml(xml);
    }
}
