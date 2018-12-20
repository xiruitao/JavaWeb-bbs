package vo;

public class MyPost {
    private int post_id;
    private int category_id;
    private String post_title;
    private String post_content;
    private String account;
    private String image;
    private String post_time;
    private int post_score;
    private int is_finish;

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public String getPost_title() {
        return post_title;
    }

    public String getPost_content() {
        return post_content;
    }

    public String getAccount() {
        return account;
    }

    public String getImage() {
        return image;
    }

    public String getPost_time() {
        return post_time;
    }

    public int getPost_score() {
        return post_score;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public void setPost_title(String post_title) {
        this.post_title = post_title;
    }

    public void setPost_content(String post_content) {
        this.post_content = post_content;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setPost_time(String post_time) {
        this.post_time = post_time;
    }

    public void setPost_score(int post_score) {
        this.post_score = post_score;
    }

    public int getIs_finish() {
        return is_finish;
    }

    public void setIs_finish(int is_finish) {
        this.is_finish = is_finish;
    }
}
