//package com.welcome.server.service;
//
//import com.welcome.server.TestDatabaseConfig;
//import com.welcome.server.entity.User;
//import com.welcome.server.util.Util;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//
//import javax.annotation.Resource;
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//
///**
// * Created by ivanf on 13.10.2016.
// */
//@DirtiesContext
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = TestDatabaseConfig.class)
//@WebAppConfiguration
//public class UserServiceTest {
//
//    @Resource
//    private EntityManagerFactory emf;
//    protected EntityManager em;
//
//    @Resource
//    @Autowired
//    private UserService userService;
//
//    @Before
//    public void setUp(){
//        em=emf.createEntityManager();
//    }
//
//    @Test
//    public void testRegNewUser() throws Exception{
//        User user= Util.createUser();
//        userService.regNewUser(user);
//    }
//
//}
