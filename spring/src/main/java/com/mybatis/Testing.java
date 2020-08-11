package com.mybatis;

import com.mybatis.dao.UserDao;
import com.mybatis.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author pengwei
 * @date 2020/8/7
 */
public class Testing {


    @Test
    public void test() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/spring-mybatis.xml");
        UserDao userDao = (UserDao) ctx.getBean("userDao");
        User user = new User();
        user.setName("xiaojr");
        user.setPassword("111");
        userDao.save(user);
    }
}
