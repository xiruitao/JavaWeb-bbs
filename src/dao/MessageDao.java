package dao;
import java.sql.*;
import java.util.ArrayList;
import vo.*;
public interface MessageDao {
    public boolean sendMessage(Message message);
    public ArrayList<Message> showConversation(String account_1, String account_2);
    public ArrayList<User> getUsersOfCommunication(String account);
}
