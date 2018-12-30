package vo;
import java.sql.*;
public class Message {
    private int message_id;
    private String account_send;
    private String account_receive;
    private String message_content;
    private Timestamp send_time;

    public String getAccount_send() {
        return account_send;
    }

    public void setAccount_send(String account_send) {
        this.account_send = account_send;
    }

    public int getMessage_id() {
        return message_id;
    }

    public void setMessage_id(int message_id) {
        this.message_id = message_id;
    }

    public String getAccount_receive() {
        return account_receive;
    }

    public void setAccount_receive(String account_receive) {
        this.account_receive = account_receive;
    }

    public String getMessage_content() {
        return message_content;
    }

    public void setMessage_content(String message_content) {
        this.message_content = message_content;
    }

    public Timestamp getSend_time() {
        return send_time;
    }

    public void setSend_time(Timestamp send_time) {
        this.send_time = send_time;
    }
}
