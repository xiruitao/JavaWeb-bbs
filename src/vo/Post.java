package vo;
import java.sql.*;
public class Post {
    private int post_id;
    private int category_id;
    private String post_title;
    private String post_content;
    private String account;
    private String image;
    private int pos_value;
    private int is_refinment;
    private Timestamp post_time;
    public Post(){
        post_title="";
        pos_value=0;
        is_refinment=0;
        image="";
    }

    public Timestamp getPost_time() {
        return post_time;
    }

    public void setPost_time(Timestamp post_time) {
        this.post_time = post_time;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getPost_title() {
        return post_title;
    }

    public void setPost_title(String post_title) {
        this.post_title = post_title;
    }

    public String getPost_content() {
        return post_content;
    }

    public void setPost_content(String post_content) {
        this.post_content = post_content;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getPos_value() {
        return pos_value;
    }

    public void setPos_value(int pos_value) {
        this.pos_value = pos_value;
    }

    public int getIs_refinment() {
        return is_refinment;
    }

    public void setIs_refinment(int is_refinment) {
        this.is_refinment = is_refinment;
    }
}

