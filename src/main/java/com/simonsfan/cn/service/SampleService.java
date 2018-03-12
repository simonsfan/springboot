package com.simonsfan.cn.service;

import com.simonsfan.cn.dao.SampleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 项目名称：springboot-rabbitmq
 * 类名称：com.simonsfan.cn.service
 * 类描述：
 * 创建人：simonsfan
 * 创建时间：2018/3/9 14:28
 */
@Service
public class SampleService {

    @Autowired
    private SampleDao sampleDao;

    public List<String> getActivityIds(){
            return sampleDao.getActivityId();
    }


}
