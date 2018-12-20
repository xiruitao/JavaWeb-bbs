package service;

import dao.MyUserLoginDao;
import dao.impl.MyUserLoginDaoImpl;
import vo.MyUserLogin;

public class MyUserLOginService {
    private MyUserLoginDao myUserLoginDao = new MyUserLoginDaoImpl();

    public boolean login(MyUserLogin myUserLogin) {
        return myUserLoginDao.login(myUserLogin);
    }
}
