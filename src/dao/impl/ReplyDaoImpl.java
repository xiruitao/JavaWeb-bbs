package dao.impl;

import vo.*;
import dao.ReplyDao;
import dao.JDBCUtil;
import java.sql.*;
import java.util.*;
import service.UserService;
public class ReplyDaoImpl implements ReplyDao{
    public boolean replyAndInsert(Reply reply)
    {
        Connection conn=JDBCUtil.getConnection();
        try{
            String sql="insert into reply(post_id,account,reply_time,reply_content,reply_id,image) values(?,?,?,?,?,?)";
            PreparedStatement psta=conn.prepareStatement(sql);
            psta.setInt(1,reply.getPost_id());
            psta.setString(2,reply.getAccount());
            psta.setTimestamp(3,reply.getReply_time());
            psta.setString(4,reply.getReply_content());
            psta.setInt(5,reply.getReply_id());
            psta.setString(6,reply.getImage());
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
    public ArrayList<ArrayList<Reply>> getReplyInformation(int post_id)
    {
        Connection conn=JDBCUtil.getConnection();
        ArrayList<ArrayList<Reply>> replyInformation=new ArrayList<ArrayList<Reply>>();
       /* ArrayList<Reply> unordered=new ArrayList<Reply>();
        try{
            String sql1="select * from reply where post_id=?";
            PreparedStatement psta1=conn.prepareStatement(sql1);
            psta1.setInt(1,post_id);
            ResultSet rs1=psta1.executeQuery();
            while(rs1.next())
            {
                Reply reply=new Reply();
                reply.setPost_id(post_id);
                reply.setOwn_id(rs1.getInt("own_id"));
                reply.setAccount(rs1.getString("account"));
                reply.setReply_content(rs1.getString("reply_content"));
                reply.setReply_id(rs1.getInt("reply_id"));
                reply.setImage(rs1.getString("image"));
                reply.setReply_time(rs1.getTimestamp("reply_time"));
                UserService userService=new UserService();
                User user=userService.getUserInformationByAccount(reply.getAccount());
                reply.setUser_name_1(user.getUser_name());
                reply.setHead_image_1(user.getHead_image());
                unordered.add(reply);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        ArrayList<Reply> directReply=new ArrayList<Reply>();
        for(int i=0;i<unordered.size();i++)
        {
            if(unordered.get(i).getReply_id()==0)
            {
                directReply.add(unordered.get(i));
            }
        }
        directReply=sortTime(directReply);
        for(int i=0;i<directReply.size();i++)
        {
            ArrayList<Reply> replyLine=new ArrayList<Reply>();
            Reply reply=directReply.get(i);
            UserService userService=new UserService();
            Queue<Reply> q=new LinkedList<Reply>();
            User user=userService.getUserInformationByAccount(reply.getAccount());
            reply.setUser_name_1(user.getUser_name());
            reply.setHead_image_1(user.getHead_image());
            q.add(reply);
            while (!q.isEmpty())
            {
                Reply midData=q.poll();
                replyLine.add(midData);
                User user2=userService.getUserInformationByAccount(midData.getAccount());
                ArrayList<Reply> midReplyArr=new ArrayList<Reply>();
                for(int j=0;j<unordered.size();j++)
                {
                    if(unordered.get(j).getReply_id()==midData.getOwn_id())
                    {
                        midReplyArr.add(unordered.get(j));
                    }
                }
                midReplyArr=sortTime(midReplyArr);
                for(int j=0;j<midReplyArr.size();j++)
                {
                    User user1=userService.getUserInformationByAccount(midReplyArr.get(j).getAccount());
                    Reply reply2=midReplyArr.get(j);
                    reply2.setUser_name_1(user1.getUser_name());
                    reply2.setHead_image_1(user1.getHead_image());
                    reply2.setUser_name_2(user2.getUser_name());
                    reply2.setHead_image_2(user2.getHead_image());
                    reply2.setAccount2(user2.getAccount());
                    q.add(midReplyArr.get(j));
                    System.out.println(reply2.getReply_content());
                }
            }
            replyInformation.add(replyLine);
        }
        return  replyInformation; */
        try{
            String sql1="select * from reply where post_id=? and reply_id=0 order by reply_time";
            PreparedStatement psta1=conn.prepareStatement(sql1);
            psta1.setInt(1,post_id);
            ResultSet rs1=psta1.executeQuery();
            while(rs1.next())
            {
                ArrayList<Reply> replyLine=new ArrayList<Reply>();
                Reply reply=new Reply();
                reply.setPost_id(post_id);
                reply.setOwn_id(rs1.getInt("own_id"));
                reply.setAccount(rs1.getString("account"));
                reply.setReply_content(rs1.getString("reply_content"));
                reply.setReply_id(rs1.getInt("reply_id"));
                reply.setImage(rs1.getString("image"));
                reply.setReply_time(rs1.getTimestamp("reply_time"));
                UserService userService=new UserService();
                User user=userService.getUserInformationByAccount(reply.getAccount());
                reply.setUser_name_1(user.getUser_name());
                reply.setHead_image_1(user.getHead_image());
               // System.out.println(reply.getReply_content());
                Queue<Reply> q=new LinkedList<Reply>();
                q.add(reply);
                while(!q.isEmpty())
                {
                    Reply midData=q.poll();
                    replyLine.add(midData);
                    User user2=userService.getUserInformationByAccount(midData.getAccount());
                    try{
                        String sql2="select * from reply where reply_id=? order by reply_time";
                        PreparedStatement psta2=conn.prepareStatement(sql2);
                        psta2.setInt(1,midData.getOwn_id());
                        ResultSet rs2=psta2.executeQuery();
                        while(rs2.next())
                        {
                            Reply reply2=new Reply();
                            reply2.setPost_id(post_id);
                            reply2.setOwn_id(rs2.getInt("own_id"));
                            reply2.setAccount(rs2.getString("account"));
                            reply2.setReply_content(rs2.getString("reply_content"));
                            reply2.setReply_id(rs2.getInt("reply_id"));
                            reply2.setImage(rs2.getString("image"));
                            reply2.setReply_time(rs2.getTimestamp("reply_time"));
                            User user1=userService.getUserInformationByAccount(reply2.getAccount());
                            reply2.setUser_name_1(user1.getUser_name());
                            reply2.setHead_image_1(user1.getHead_image());
                            reply2.setUser_name_2(user2.getUser_name());
                            reply2.setHead_image_2(user2.getHead_image());
                            reply2.setAccount2(user2.getAccount());
                           // System.out.println("  "+reply2.getReply_content());
                            q.add(reply2);
                        }
                        psta2.close();
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
                replyInformation.add(replyLine);
            }
            psta1.close();
            rs1.close();
            conn.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return replyInformation;
    }
    /*public ArrayList<Reply> sortTime(ArrayList<Reply> date)
    {
        for(int i=0;i<date.size();i++)
        {
            for(int j=i;j<date.size();j++)
            {
                if(date.get(i).getReply_time().getTime()>date.get(i).getReply_time().getTime())
                {
                    Reply temp=date.get(i);
                    date.set(i,date.get(j));
                    date.set(j,temp);
                }
            }
        }
        return date;
    }*/
}
