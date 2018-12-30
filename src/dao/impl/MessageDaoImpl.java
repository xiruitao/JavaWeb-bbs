package dao.impl;
import dao.*;
import vo.*;
import java.sql.*;
import java.util.ArrayList;

public class MessageDaoImpl implements MessageDao {
    public boolean sendMessage(Message message)
    {
        Connection conn=JDBCUtil.getConnection();
        try{
            String sql="insert into i_message(account_send,account_receive,message_content,send_time) values(?,?,?,?)";
            PreparedStatement psta=conn.prepareStatement(sql);
            psta.setString(1,message.getAccount_send());
            psta.setString(2,message.getAccount_receive());
            psta.setString(3,message.getMessage_content());
            psta.setTimestamp(4,message.getSend_time());
            psta.executeUpdate();
            psta.close();
            conn.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public ArrayList<Message> showConversation(String account_1, String account_2)
    {
        Connection conn=JDBCUtil.getConnection();
        ArrayList<Message> conversation=new ArrayList<Message>();
        try
        {
            String sql="select * from i_message where (account_send=? and account_receive=?) or (account_send=? and account_receive=?) order by send_time";
            PreparedStatement psta=conn.prepareStatement(sql);
            psta.setString(1,account_1);
            psta.setString(2,account_2);
            psta.setString(3,account_2);
            psta.setString(4,account_1);
            ResultSet rs=psta.executeQuery();
            while(rs.next())
            {
                Message message=new Message();
                message.setMessage_id(rs.getInt("message_id"));
                message.setAccount_send(rs.getString("account_send"));
                message.setAccount_receive(rs.getString("account_receive"));
                message.setMessage_content(rs.getString("message_content"));
                message.setSend_time(rs.getTimestamp("send_time"));
                conversation.add(message);
               // System.out.println(message.getAccount_send()+":"+message.getMessage_content());
            }
            psta.close();
            rs.close();
            conn.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return conversation;
    }
    public ArrayList<User> getUsersOfCommunication(String account)
    {
        ArrayList<User> users=new ArrayList<User>();
        Connection conn=JDBCUtil.getConnection();
        try {
            ArrayList<String> accounts=new ArrayList<String>();
            String sql1="select distinct account_send,account_receive from i_message where account_send=? or account_receive=?";
            PreparedStatement psta1=conn.prepareStatement(sql1);
            psta1.setString(1,account);
            psta1.setString(2,account);
            ResultSet rs1=psta1.executeQuery();
            while (rs1.next())
            {
                String account_send=rs1.getString("account_send");
                String account_receive=rs1.getString("account_receive");
                if(!accounts.contains(account_send)&&!account.equals(account_send))
                {
                    accounts.add(account_send);
                }
                if(!accounts.contains(account_receive)&&!account.equals(account_receive))
                {
                    accounts.add(account_receive);
                }
            }
            for(int i=0;i<accounts.size();i++)
            {
                try{
                    String sql2="select account,user_name,head_image from user_information_p where account=?";
                    PreparedStatement psta2=conn.prepareStatement(sql2);
                    psta2.setString(1,accounts.get(i));
                    ResultSet rs2=psta2.executeQuery();
                    while(rs2.next())
                    {
                        User user=new User();
                        user.setAccount(rs2.getString("account"));
                        user.setUser_name(rs2.getString("user_name"));
                        user.setHead_image(rs2.getString("head_image"));
                        users.add(user);
                    }
                    psta2.close();
                    rs2.close();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            psta1.close();
            rs1.close();
            conn.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return users;
    }
}
