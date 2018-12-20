package service;

import dao.JDBCUtil;
import dao.MyUserDao;
import dao.impl.MyUserDaoImpl;
import vo.MyUser;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class MyUserService {
    private MyUserDao myUserDao = new MyUserDaoImpl();

    public boolean addScore(MyUser myUser) {
        return myUserDao.addScore(myUser);
    }

    public boolean register(MyUser myUser) {
        return myUserDao.register(myUser);
    }
}
