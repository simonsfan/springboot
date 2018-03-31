package com.simonsfan.cn.bean;

/**
 * Created by fanrx on 2018/3/18.
 */
public class ActivityInfo{
    private String actId;
    private String md5Key;

    public String getActId() {
        return actId;
    }

    public void setActId(String actId) {
        this.actId = actId;
    }

    public String getMd5Key() {
        return md5Key;
    }

    public void setMd5Key(String md5Key) {
        this.md5Key = md5Key;
    }
    @Override
    public String toString() {
        return "ActivityInfo{" +
                "actId='" + actId + '\'' +
                ", md5Key='" + md5Key + '\'' +
                '}';
    }
}
