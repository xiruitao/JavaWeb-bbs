package service;
import dao.*;
import dao.impl.*;
import vo.*;

import java.util.ArrayList;

public class UserService {
    private UserDao userDao=new UserDaoImpl();
    public User getUserInformationByAccount(String account)
    {
        return userDao.getUserInformationByAccount(account);
    }
    public ArrayList<Integer> getStatisticsBySex()
    {
        return userDao.getUserNumbersGroupBySex();
    }
    public ArrayList<Integer> getStatisticsByProvinces(){return userDao.getUserStatisticsByProvince();}
    public String parseProvinceId(int id){return userDao.parseProvinceId(id);}
    public ArrayList<Integer> geStatisticsByBirthday(){
        return userDao.getUserStatisticsByBirthday();
    }
}
