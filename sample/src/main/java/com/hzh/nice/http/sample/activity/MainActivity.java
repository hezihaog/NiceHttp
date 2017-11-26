package com.hzh.nice.http.sample.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.hzh.logger.L;
import com.hzh.nice.http.adapter.ApiCallbackAdapter;
import com.hzh.nice.http.inter.Result;
import com.hzh.nice.http.sample.R;
import com.hzh.nice.http.sample.RequestManager;
import com.hzh.nice.http.sample.util.Const;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnGet = (Button) findViewById(R.id.get);

//        SearchEntity result = (SearchEntity) NiceApiClient.getInstance().getApi()
//                .getSync(Const.Api.domain
//                        + Const.Api.search
//                        + "/" + Const.SearchType.ANDROID
//                        + "/count/" + Const.Config.pageCount + "/page/" + Const.Config.page, new ApiParams(), SearchEntity.class);

        btnGet.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                RequestManager.search(new ApiCallbackAdapter() {
                    @Override
                    public void onApiSuccess(Result res, String tag) {
                        super.onApiSuccess(res, tag);
                        SearchEntity result = (SearchEntity) res;
                        L.d("result ::: " + result.getCount());
                    }
                }, Const.SearchType.ANDROID, Const.Config.pageCount + "", Const.Config.page + "");
            }
        });
    }
}