package vo;
import java.sql.Timestamp;
public class Reply {
    private String user_name_2;
    private String head_image_2;
    private String user_name_1;
    private String head_image_1;
    private String account2;
    private int own_id;
    private int post_id;
    private String account;
    private Timestamp reply_time;
    private String reply_content;
    private int reply_id;
    private String image;
    public Reply(){
        user_name_1="";
        head_image_1="";
        user_name_2="";
        head_image_2="";
        account2="";
        image="";
    };

    public String getAccount2() {
        return account2;
    }

    public void setAccount2(String account2) {
        this.account2 = account2;
    }

    public String getHead_image_1() {
        return head_image_1;
    }

    public void setHead_image_1(String head_image_1) {
        this.head_image_1 = head_image_1;
    }

    public String getUser_name_1() {
        return user_name_1;
    }

    public void setUser_name_1(String user_name_1) {
        this.user_name_1 = user_name_1;
    }

    public String getHead_image_2() {
        return head_image_2;
    }

    public void setHead_image_2(String head_image_2) {
        this.head_image_2 = head_image_2;
    }

    public String getUser_name_2() {
        return user_name_2;
    }

    public void setUser_name_2(String user_name_2) {
        this.user_name_2 = user_name_2;
    }

    public int getOwn_id() {
        return own_id;
    }

    public void setOwn_id(int own_id) {
        this.own_id = own_id;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Timestamp getReply_time() {
        return reply_time;
    }

    public void setReply_time(Timestamp reply_time) {
        this.reply_time = reply_time;
    }

    public String getReply_content() {
        return reply_content;
    }

    public void setReply_content(String reply_content) {
        this.reply_content = reply_content;
    }

    public int getReply_id() {
        return reply_id;
    }

    public void setReply_id(int reply_id) {
        this.reply_id = reply_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
