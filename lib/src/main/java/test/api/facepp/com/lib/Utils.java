package test.api.facepp.com.lib;

import com.alibaba.fastjson.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Consumer;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * @author by licheng on 2018/6/13.
 */

public class Utils {

    private static final MediaType MediaType_APPLICATION = MediaType.parse("application/octet-stream");

    private static final String BASE_URL = "https://api-cn.faceplusplus.com/facepp/v3";

    private static OkHttpClient okHttpClient;

    /**
     * 不带文件参数的请求
     */
    public static void post(String url, Map<String, String> params) {
        post(url, params, null);
    }

    /**
     * 带文件参数的请求
     */
    public static void post(String url, final Map<String, String> params, String filePath) {
        try {
            // 构建请求体
            RequestBody requestBody = buildRequestBody(params, filePath);

            // 发送请求
            doPost(new Request.Builder().url(BASE_URL + url).post(requestBody).build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 构建请求参数
     */
    private static RequestBody buildRequestBody(final Map<String, String> params, String filePath) throws Exception {

        // 普通参数
        final MultipartBody.Builder bodyBuilder = addNormalParams(params);

        // 文件参数
        if (null != filePath) {
            if (params.containsKey("image_url") || params.containsKey("image_base64")) {
                throw new Exception("image_url , image_base64 , image_file 三个参数只能存在一个");
            }

            File file = new File(filePath);
            if (file.exists()) {
                bodyBuilder.addFormDataPart("image_file", file.getName(), RequestBody.create(MediaType_APPLICATION, file));
            }
        }

        return bodyBuilder.build();
    }

    /**
     * 普通参数
     */
    private static MultipartBody.Builder addNormalParams(final Map<String, String> params) {

        final MultipartBody.Builder bodyBuilder = new MultipartBody.Builder().setType(MultipartBody.FORM);

        // 普通参数
        Iterator<String> iterator = params.keySet().iterator();
        iterator.forEachRemaining(new Consumer<String>() {
            @Override
            public void accept(String key) {
                String value = params.get(key);
                bodyBuilder.addFormDataPart(key, value);
            }
        });
        return bodyBuilder;
    }

    /**
     * 发送请求
     */
    private static void doPost(Request request) {
        if (null == okHttpClient) {
            okHttpClient = new OkHttpClient();
        }
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                System.out.println("onFailure ： " + e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                ResponseBody responseBody = response.body();
                JSONObject jsonObject = JSONObject.parseObject(responseBody.string());
                System.out.println("onResponse : " + jsonObject.toJSONString());
            }
        });
    }
}
