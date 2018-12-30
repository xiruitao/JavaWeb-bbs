package vo;
import java.sql.*;
public class User {
    private String user_name;
    private String account;
    private Date birthday;
    private String sex;
    private String place_of_province;
    private String occupation;
    private String head_image;
    private int score;
    private String tel;
    public User()
    {
        account="";
        user_name="";
        birthday=null;
        sex="";
        place_of_province="";
        occupation="";
        head_image="";
        score=0;
        tel="";
    }
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPlace_of_province() {
        return place_of_province;
    }

    public void setPlace_of_province(String place_of_province) {
        this.place_of_province = place_of_province;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getHead_image() {
        return head_image;
    }

    public void setHead_image(String head_image) {
        this.head_image = head_image;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

}
