package com.megvii.facepp.api;

import com.megvii.facepp.api.bean.BaseResponse;

/**
 * @author by licheng on 2018/9/26.
 */

public class TaskQueryResponse extends BaseResponse {

    private String task_id;

    public String getTask_id() {
        return task_id;
    }

    public void setTask_id(String task_id) {
        this.task_id = task_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaskQueryResponse that = (TaskQueryResponse) o;

        return task_id != null ? task_id.equals(that.task_id) : that.task_id == null;
    }

    @Override
    public int hashCode() {
        return task_id != null ? task_id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "{" +
                "\"task_id\":\'" + task_id + "\'" +
                '}';
    }
}
