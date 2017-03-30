package org.smart4j.chapter2.basicmodule.model;

import java.util.Objects;

/**
 * Created by dingcc on 2017/3/27.
 */
public class Message{

    private  Boolean success=Boolean.TRUE;//是否成功表示
    private  String  info;//返回信息

    private Objects obj;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Objects getObj() {
        return obj;
    }

    public void setObj(Objects obj) {
        this.obj = obj;
    }
    @Override
    public String toString() {
        return "Message{" +
                "success=" + success +
                ", info='" + info + '\'' +
                ", obj=" + obj +
                '}';
    }
}
