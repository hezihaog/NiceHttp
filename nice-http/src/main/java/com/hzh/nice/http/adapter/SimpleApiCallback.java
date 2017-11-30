package com.hzh.nice.http.adapter;


//import com.hzh.logger.L;
import com.hzh.nice.http.NiceApiClient;
import com.hzh.nice.http.callback.ApiCallback;
import com.hzh.nice.http.inter.Printer;
import com.hzh.nice.http.inter.Result;

/**
 * 网络请求回调接口适配器
 */
public class SimpleApiCallback implements ApiCallback {

    @Override
    public void onApiStart(String tag) {
    }

    @Override
    public void onApiLoading(long count, long current, String tag) {
    }

    @Override
    public void onApiSuccess(Result res, String tag) {
    }

    @Override
    public void onApiFailure(Throwable t, int errorNo, String strMsg, String tag) {
        Printer printer = NiceApiClient.getInstance().getPrinter();
        if (printer != null) {
            printer.e("网络请求错误");
            onApiError(tag);
        }
    }

    @Override
    public void onParseError(String tag) {
        Printer printer = NiceApiClient.getInstance().getPrinter();
        if (printer != null) {
            printer.e("数据解析错误");
            onApiError(tag);
        }
    }

    protected void onApiError(String tag) {
    }

}
