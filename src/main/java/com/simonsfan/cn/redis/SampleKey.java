package com.simonsfan.cn.redis;

/**
 * redis key demo
 */
public class SampleKey extends BasePrefix {

    public SampleKey(String prefix) {
        super(prefix);
    }

    public static SampleKey SAMPLEKEY = new SampleKey("sample");


}
