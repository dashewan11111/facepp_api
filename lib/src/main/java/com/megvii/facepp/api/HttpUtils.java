package com.megvii.facepp.api;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * @author by licheng on 2018/6/13.
 */

public class HttpUtils {

    private static final MediaType MediaType_APPLICATION = MediaType.parse("application/octet-stream");

    private static final String KEY_IMAGE_FILE = "image_file";
    private static final String KEY_IMAGE_FILE_1 = "image_file1";
    private static final String KEY_IMAGE_FILE_2 = "image_file2";

    private static OkHttpClient okHttpClient;

    /**
     * 不带文件参数的请求
     */
    public static void post(String url, Map<String, String> params, Callback callback) {
        post(url, params, null, callback);
    }

    /**
     * 带文件参数的请求
     */
    public static void post(String url, final Map<String, String> params, byte[] filePath, Callback callback) {
        post(url, params, filePath, null, callback);
    }

    /**
     * 带文件参数的请求
     */
    public static void post(String url, final Map<String, String> params, byte[] filePath1, byte[] filePath2, Callback callback) {
        try {
            // 构建请求体
            RequestBody requestBody = buildRequestBody(params, filePath1, filePath2);

            // 发送请求
            doPost(new Request.Builder().url(url).post(requestBody).build(), callback);
        } catch (Exception e) {
            if (null != callback) {
                callback.onFailure(null, new IOException(e.getMessage()));
            }
        }
    }

    /**
     * 构建请求参数
     */
    private static RequestBody buildRequestBody(final Map<String, String> params, byte[] filePath1, byte[] filePath2) throws Exception {
        // 普通参数
        final MultipartBody.Builder bodyBuilder = addNormalParams(params);

        //  同时存在，只有compare 了, 参数名为 image_file1 和 image_file2
        if (!isEmpty(filePath1) && !isEmpty(filePath2)) {
            addFileParams(bodyBuilder, KEY_IMAGE_FILE_1, filePath1);
            addFileParams(bodyBuilder, KEY_IMAGE_FILE_2, filePath2);

            return bodyBuilder.build();
        }

        // 文件参数
        if (!isEmpty(filePath1)) {
            addFileParams(bodyBuilder, KEY_IMAGE_FILE, filePath1);
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
        while (iterator.hasNext()) {
            String key = iterator.next();
            String value = params.get(key);
            bodyBuilder.addFormDataPart(key, value);
        }
        return bodyBuilder;
    }

    /**
     * 发送请求
     */
    private static void doPost(Request request, final Callback callback) {
        if (null == okHttpClient) {
            okHttpClient = new OkHttpClient();
        }
        okHttpClient.newCall(request).enqueue(callback);
    }

    private static void addFileParams(MultipartBody.Builder bodyBuilder, String key, byte[] file) throws Exception {
        bodyBuilder.addFormDataPart(key, key, RequestBody.create(MediaType_APPLICATION, file));
    }

    private static boolean isEmpty(byte[] data) {
        return data == null || data.length == 0;
    }
}
