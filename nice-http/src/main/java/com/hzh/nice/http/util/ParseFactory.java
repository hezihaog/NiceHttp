package com.hzh.nice.http.util;

import com.hzh.nice.http.AppException;
import com.hzh.nice.http.inter.Parser;
import com.hzh.nice.http.inter.Result;

/**
 * Package: com.hzh.nice.http.util
 * FileName: ParseFactory
 * Date: on 2017/11/9  下午6:46
 * Auther: zihe
 * Descirbe: 解析bean工厂类
 * Email: hezihao@linghit.com
 */

public class ParseFactory {
    private ParseFactory() {
    }

    private static class SingleHolder {
        private static final ParseFactory instance = new ParseFactory();
    }

    public static ParseFactory getInstance() {
        return SingleHolder.instance;
    }

    /**
     * 解析json
     *
     * @param json  要解析的json
     * @param clazz 转换出来的bean对象
     * @throws AppException
     */
    public <T extends Result> T parse(Parser parser, String json, Class<T> clazz) throws AppException {
        T res;
        try {
            res = parser.parse(json, clazz);
        } catch (Exception e) {
            e.printStackTrace();
            throw AppException.json(e);
        }
        return res;
    }
}
