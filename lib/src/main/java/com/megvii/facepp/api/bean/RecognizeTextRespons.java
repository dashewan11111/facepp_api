package com.megvii.facepp.api.bean;

/**
 * @author by licheng on 2018/7/3.
 */

public class RecognizeTextRespons extends BaseResponse {

    private TextResult result;

    public TextResult getResult() {
        return result;
    }

    public void setResult(TextResult result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "RecognizeTextRespons{" +
                "result=" + result +
                '}';
    }
}
