package com.megvii.facepp.api.bean;

/**
 * @author by licheng on 2018/7/3.
 */

public class FaceSetDetailResponse extends FaceSetCreatResponse {

    private String display_name;

    private String user_data;

    private String tags;

    private String next;

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public String getUser_data() {
        return user_data;
    }

    public void setUser_data(String user_data) {
        this.user_data = user_data;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "FaceSetDetailResponse{" +
                "display_name='" + display_name + '\'' +
                ", user_data='" + user_data + '\'' +
                ", tags='" + tags + '\'' +
                ", next='" + next + '\'' +
                '}';
    }
}
