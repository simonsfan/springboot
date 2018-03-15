package com.simonsfan.cn.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 项目名称：springboot-rabbitmq
 * 类名称：com.simonsfan.cn.dao
 * 类描述：
 * 创建人：simonsfan
 * 创建时间：2018/3/9 14:26
 */
@Mapper
public interface SampleDao {

    @Select("select  product_id  from  mmall_cart")
    List<String> getActivityId();


}
