package dao;

import vo.MyUserLogin;

public interface MyUserLoginDao {
    public boolean login(MyUserLogin myUserLogin);

    public boolean register(MyUserLogin myUserLogin);
}
