package com.megvii.facepp.api.bean;

/**
 * @author by licheng on 2018/7/3.
 */

public class DriverLicenseResponse extends BaseResponse {

    private DriverLicenseMain main;

    private DriverLicenseSecond second;

    public DriverLicenseMain getMain() {
        return main;
    }

    public void setMain(DriverLicenseMain main) {
        this.main = main;
    }

    public DriverLicenseSecond getSecond() {
        return second;
    }

    public void setSecond(DriverLicenseSecond second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return "DriverLicenseResponse{" +
                "main=" + main +
                ", second=" + second +
                '}';
    }
}
