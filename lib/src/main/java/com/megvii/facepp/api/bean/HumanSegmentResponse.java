package com.megvii.facepp.api.bean;

/**
 * @author by licheng on 2018/7/3.
 */

public class HumanSegmentResponse extends BaseResponse {

    private String result; // 灰度图

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "{" +
                "\"result\":\'" + result + "\'" +
                '}';
    }
}
