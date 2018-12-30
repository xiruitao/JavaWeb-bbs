package dao.impl;
import dao.PostDao;
import vo.Post;
import vo.PostStatistic;
import dao.JDBCUtil;
import java.sql.*;
import java.util.ArrayList;

public class PostDaoImpl implements PostDao {
    public boolean sendPost(Post post)
    {
        Connection conn=JDBCUtil.getConnection();
        try{
            String sql="insert into post (category_id,post_title,post_content,account,image,post_time) values (?,?,?,?,?,?)";
            PreparedStatement psta=conn.prepareStatement(sql);
            psta.setInt(1,post.getCategory_id());
            psta.setString(2,post.getPost_title());
            psta.setString(3,post.getPost_content());
            psta.setString(4,post.getAccount());
            psta.setString(5,post.getImage());
            psta.setTimestamp(6,post.getPost_time());
            psta.executeUpdate();
            conn.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public ArrayList<Post> getPostsByTimeOrder() {
    Connection conn=JDBCUtil.getConnection();
    ArrayList<Post> posts=new ArrayList<Post>();
    try{
        String sql="select * from post order by post_time";
        Statement sta=conn.createStatement();
        ResultSet rs=sta.executeQuery(sql);
        while(rs.next())
        {
            Post post=new Post();
            post.setPost_id(rs.getInt("post_id"));
            post.setCategory_id(rs.getInt("category_id"));
            post.setPost_title(rs.getString("post_title"));
            post.setPost_content(rs.getString("post_content"));
            post.setAccount(rs.getString("account"));
            post.setImage(rs.getString("image"));
            post.setPos_value(rs.getInt("pos_value"));
            post.setIs_refinment(rs.getInt("is_refinement"));
            post.setPost_time(rs.getTimestamp("post_time"));
            posts.add(post);
            //System.out.println(post.getPost_title());
        }
        conn.close();
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }
    return posts;
    }
    public Post getPostByPostId(int postId)
    {
        Post post=new Post();
        Connection conn=JDBCUtil.getConnection();
        try{
            String sql="select * from post where post_id=?";
            PreparedStatement psta=conn.prepareStatement(sql);
            psta.setInt(1,postId);
            ResultSet rs=psta.executeQuery();
            while(rs.next())
            {
                post.setPost_id(rs.getInt("post_id"));
                post.setCategory_id(rs.getInt("category_id"));
                post.setPost_title(rs.getString("post_title"));
                post.setPost_content(rs.getString("post_content"));
                post.setAccount(rs.getString("account"));
                post.setImage(rs.getString("image"));
                post.setPos_value(rs.getInt("pos_value"));
                post.setIs_refinment(rs.getInt("is_refinement"));
                post.setPost_time(rs.getTimestamp("post_time"));
            }
            rs.close();
            psta.close();
            conn.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return post;
    }
    public boolean updatePostContent(String PostContent,int PostId)
    {
        Connection conn=JDBCUtil.getConnection();
        try{
            String sql="update post set post_content=? where post_id=?";
            PreparedStatement psta=conn.prepareStatement(sql);
            psta.setString(1,PostContent);
            psta.setInt(2,PostId);
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
    public ArrayList<Post> getPostByAccount(String account)
    {
        ArrayList<Post> posts=new ArrayList<Post>();
        Connection conn=JDBCUtil.getConnection();
        try {
            String sql="select * from post where account=? order by post_time";
            PreparedStatement psta=conn.prepareStatement(sql);
            psta.setString(1,account);
            ResultSet rs=psta.executeQuery();
            while (rs.next())
            {
                Post post=new Post();
                post.setPost_id(rs.getInt("post_id"));
                post.setCategory_id(rs.getInt("category_id"));
                post.setPost_title(rs.getString("post_title"));
                post.setPost_content(rs.getString("post_content"));
                post.setAccount(rs.getString("account"));
                post.setImage(rs.getString("image"));
                post.setPos_value(rs.getInt("pos_value"));
                post.setIs_refinment(rs.getInt("is_refinement"));
                post.setPost_time(rs.getTimestamp("post_time"));
                posts.add(post);
            }
            psta.close();
            conn.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return posts;
    }
    public ArrayList<PostStatistic> getPostStatisticsByReplyNum()
    {
        ArrayList<PostStatistic> statistics=new ArrayList<PostStatistic>();
        Connection conn=JDBCUtil.getConnection();
        try{
            String sql="select post_id,count(*) as number from reply group by post_id order by number desc";
            Statement sta=conn.createStatement();
            ResultSet rs=sta.executeQuery(sql);
            while (rs.next())
            {
                PostStatistic postStatistic=new PostStatistic();
                int post_id=rs.getInt("post_id");
                int post_num=rs.getInt("number");
                postStatistic.setPost_id(post_id);
                postStatistic.setNumber(post_num);
                statistics.add(postStatistic);
            }
            sta.close();
            conn.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return statistics;
    }
    public boolean deletePost(int post_id)
    {
        Connection conn=JDBCUtil.getConnection();
        try{
            String sql1="delete from reply where post_id=?";
            String sql2="delete from post where post_id=?";
            PreparedStatement psta1=conn.prepareStatement(sql1);
            PreparedStatement psta2=conn.prepareStatement(sql2);
            psta1.setInt(1,post_id);
            psta2.setInt(1,post_id);
            psta1.executeUpdate();
            psta2.executeUpdate();
            psta1.close();
            psta2.close();
            conn.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
