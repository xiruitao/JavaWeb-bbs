package vo;

public class MyUser {
    private String user_id;

    private int score;

    private String username;

    private String sex;

    private String tel;

    private String birthday;

    private String place_of_province;

    private String occupation;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setPlace_of_province(String place_of_province) {
        this.place_of_province = place_of_province;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getUsername() {
        return username;
    }

    public String getSex() {
        return sex;
    }

    public String getTel() {
        return tel;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getPlace_of_province() {
        return place_of_province;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
