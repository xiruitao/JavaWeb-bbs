package service;

import dao.MyUserDao;
import dao.impl.MyUserDaoImpl;
import vo.MyUser;

public class MyUserService {
    private MyUserDao myUserDao = new MyUserDaoImpl();

    public boolean addScore(MyUser myUser) {
        return myUserDao.addScore(myUser);
    }
}
