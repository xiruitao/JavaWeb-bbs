package dao;
import vo.User;
import java.util.*;
public interface UserDao {
    public User getUserInformationByAccount(String account);
    public ArrayList<Integer> getUserNumbersGroupBySex();
    public ArrayList<Integer> getUserStatisticsByProvince();
    public ArrayList<Integer> getUserStatisticsByBirthday();
    public String parseProvinceId(int id);
}
