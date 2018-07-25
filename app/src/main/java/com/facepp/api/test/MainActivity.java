package com.facepp.api.test;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.megvii.facepp.api.FacePPApi;
import com.megvii.facepp.api.IFacePPApi;
import com.megvii.facepp.api.IFacePPCallBack;
import com.megvii.facepp.api.bean.DetectResponse;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.response)
    TextView txtResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        FacePPApi faceppApi = new FacePPApi("Kx_DXTvQeTR1UJCASVyOweuJSLBN2Yno", "6T431Rj_cFg8u_yrbbw3BKZVP2PwE0gU");

        Map<String, String> params = new HashMap<>();
        params.put("return_attribute", "age,gender");

        // File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/leeee.jpg");
        byte[] data = BitmapUtil.File2byte(Environment.getExternalStorageDirectory().getAbsolutePath() + "/leeee.jpg");
        faceppApi.detect(params, data,
                new IFacePPCallBack<DetectResponse>() {
                    @Override
                    public void onSuccess(DetectResponse response) {
                        refreshView(response.toString());
                    }

                    @Override
                    public void onFailed(String error) {
                        refreshView(error);
                    }
                });
    }

    private void refreshView(final String response) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                txtResponse.setText(response);
            }
        });
    }
}
