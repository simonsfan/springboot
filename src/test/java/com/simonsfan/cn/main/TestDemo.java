package com.simonsfan.cn.main;

import com.simonsfan.cn.dao.SampleDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.apache.commons.codec.digest.DigestUtils;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class TestDemo {
        @Autowired
        private SampleDao sampleDao;
        @Test
        public void testGetActivityId(){
                sampleDao.getActivityId();
        }

        @Test
        public void testMd5(){
                String content = "MVB_467961616";
                String salt = "q7er0et9u7oh1a6sdf5jlzv2zn4c.!@#$%^,./[]*&";
                String md5Hex = DigestUtils.md5Hex(content+salt);
        }


       

}
