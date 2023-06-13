package com.example.spring.toby.users.dao;

import com.example.spring.toby.users.ConnectionMaker;
import com.example.spring.toby.users.DConnectionMaker;
import com.example.spring.toby.users.NConnectionMaker;
import com.example.spring.toby.users.User;

import java.sql.SQLException;

public class UserDaoTest {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        ConnectionMaker NconnectionMaker = new NConnectionMaker();
//
//        UserDao Ndao = new UserDao(NconnectionMaker);
//
//        User user = new User();
//        user.setId("1L");
//        user.setName("토비");
//        user.setPassword("1234");
//
//        System.out.println(user.getId() + " 등록 성공");
//
//        Ndao.add(user);
//
//        User userId = Ndao.get(user.getId());
//        System.out.println(userId.getName());
//        System.out.println(userId.getPassword());
//
//        System.out.println(userId.getId() + " 조회 성공");
//
//        ConnectionMaker DconnectionMaker = new DConnectionMaker();
//
//        UserDao Ddao = new UserDao(DconnectionMaker);
//
//        User user1 = new User();
//        user1.setId("2L");
//        user1.setName("토비2");
//        user1.setPassword("1234");
//
//        System.out.println(user1.getId() + " 등록 성공");
//
//        Ddao.add(user1);
//
//        User userId2 = Ddao.get(user.getId());
//        System.out.println(userId2.getName());
//        System.out.println(userId2.getPassword());
//
//        System.out.println(userId2.getId() + " 조회 성공");

        UserDao userDao = new DaoFactory().userDao();

        User user = new User();
        user.setId("1L");
        user.setName("토비");
        user.setPassword("1234");

        userDao.add(user);

        System.out.println(user.getId() + " 등록 성공");

    }
}
