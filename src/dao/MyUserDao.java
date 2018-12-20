package dao;

import vo.MyUser;

public interface MyUserDao {

    public boolean addScore(MyUser myUser);

    public boolean register(MyUser myUser);
}
