package com.simonsfan.cn.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;

/**
 * 获取bean实例对象
 *
 * Created by fanrx on 2018/3/18.
 */
@Component
public class BeanObtainUtils implements BeanFactoryAware {

    private static BeanFactory beanFactory;

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        BeanObtainUtils.beanFactory=beanFactory;
    }

    public static BeanFactory getBeanFactory(){
        return beanFactory;
    }

}
