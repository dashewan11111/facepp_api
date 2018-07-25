package com.megvii.facepp.api.image;

import com.megvii.facepp.api.HttpUtils;
import com.megvii.facepp.api.IFacePPCallBack;
import com.megvii.facepp.api.TransCallBack;
import com.megvii.facepp.api.bean.LicensePlatResponse;
import com.megvii.facepp.api.bean.MergeFaceResponse;
import com.megvii.facepp.api.bean.RecognizeTextRespons;
import com.megvii.facepp.api.bean.SceneDetectResponse;

import java.util.Map;

/**
 * @author by licheng on 2018/7/3.
 */

public class ImageApi implements IImageApi {

    @Override
    public void detectScene(Map<String, String> params, IFacePPCallBack<SceneDetectResponse> callBack) {
        detectScene(params, null, callBack);
    }

    @Override
    public void detectScene(Map<String, String> params, byte[] filePath, IFacePPCallBack<SceneDetectResponse> callBack) {
        HttpUtils.post(API_IMAGE_SCENE_DETECT, params, filePath, new TransCallBack<>(callBack, SceneDetectResponse.class));
    }

    @Override
    public void recognizeText(Map<String, String> params, IFacePPCallBack<RecognizeTextRespons> callBack) {
        recognizeText(params, null, callBack);
    }

    @Override
    public void recognizeText(Map<String, String> params, byte[] filePath, IFacePPCallBack<RecognizeTextRespons> callBack) {
        HttpUtils.post(API_IMAGE_RECOGNIZE_TEXT, params, filePath, new TransCallBack<>(callBack, RecognizeTextRespons.class));
    }

    @Override
    public void mergeFace(Map<String, String> params, IFacePPCallBack<MergeFaceResponse> callBack) {
        mergeFace(params, null, callBack);
    }

    @Override
    public void mergeFace(Map<String, String> params, byte[] filePath, IFacePPCallBack<MergeFaceResponse> callBack) {
        HttpUtils.post(API_IMAGE_MERGE_FACE, params, filePath, new TransCallBack<>(callBack, MergeFaceResponse.class));
    }

    @Override
    public void recognizePlat(Map<String, String> params, IFacePPCallBack<LicensePlatResponse> callBack) {
        recognizePlat(params, null, callBack);
    }

    @Override
    public void recognizePlat(Map<String, String> params, byte[] filePath, IFacePPCallBack<LicensePlatResponse> callBack) {
        HttpUtils.post(API_IMAGE_LICENSE_PLATE, params, filePath, new TransCallBack<>(callBack, LicensePlatResponse.class));
    }
}
