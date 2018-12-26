package dao.impl;

import dao.JDBCUtil;
import dao.PostDao;
import vo.Post;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class PostDaoImpl implements PostDao {
    @Override
    public ArrayList<Post> findAll() {
        Connection conn= JDBCUtil.getConnection();
        ArrayList<Post> Post_information=new ArrayList<Post>();
        try{
            String sql="select * from post where pos_value='0' and category_id<>1005 order by post_time desc";
            Statement sta=conn.createStatement();
            ResultSet rs=sta.executeQuery(sql);
            while(rs.next())
            {
                Post post=new Post();
                int post_id=rs.getInt("post_id");
                int category_id=rs.getInt("category_id");
                String post_title=rs.getString("post_title");
                String post_content=rs.getString("post_content");
                String account=rs.getString("account");
                String image=rs.getString("image");
                int pos_value=rs.getInt("pos_value");
                int is_refinement=rs.getInt("is_refinement");
                String post_time=rs.getString("post_time");
                post.setPost_id(post_id);
                post.setCategory_id(category_id);
                post.setPost_title(post_title);
                post.setPost_content(post_content);
                post.setAccount(account);
                post.setImage(image);
                post.setPos_value(pos_value);
                post.setIs_refinement(is_refinement);
                post.setPost_time(post_time);
                Post_information.add(post);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return Post_information;
    }

    @Override
    public ArrayList<Post> postSticky(){
        Connection conn= JDBCUtil.getConnection();
        ArrayList<Post> Post_sticky=new ArrayList<Post>();
        try{
            String sql="select * from post where pos_value>0 and category_id<>1005 order by pos_value desc";
            Statement sta=conn.createStatement();
            ResultSet rs=sta.executeQuery(sql);
            while(rs.next())
            {
                Post post=new Post();
                int post_id=rs.getInt("post_id");
                int category_id=rs.getInt("category_id");
                String post_title=rs.getString("post_title");
                String post_content=rs.getString("post_content");
                String account=rs.getString("account");
                String image=rs.getString("image");
                int pos_value=rs.getInt("pos_value");
                int is_refinement=rs.getInt("is_refinement");
                String post_time=rs.getString("post_time");
                post.setPost_id(post_id);
                post.setCategory_id(category_id);
                post.setPost_title(post_title);
                post.setPost_content(post_content);
                post.setAccount(account);
                post.setImage(image);
                post.setPos_value(pos_value);
                post.setIs_refinement(is_refinement);
                post.setPost_time(post_time);
                Post_sticky.add(post);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return Post_sticky;
    }

    @Override
    public ArrayList<Post> postEditing(){
        Connection conn= JDBCUtil.getConnection();
        ArrayList<Post> Post_editing=new ArrayList<Post>();
        try{
            String sql="select * from post where is_refinement='1' and pos_value='0' and category_id<>1005";
            Statement sta=conn.createStatement();
            ResultSet rs=sta.executeQuery(sql);
            while(rs.next())
            {
                Post post=new Post();
                int post_id=rs.getInt("post_id");
                int category_id=rs.getInt("category_id");
                String post_title=rs.getString("post_title");
                String post_content=rs.getString("post_content");
                String account=rs.getString("account");
                String image=rs.getString("image");
                int pos_value=rs.getInt("pos_value");
                int is_refinement=rs.getInt("is_refinement");
                String post_time=rs.getString("post_time");
                post.setPost_id(post_id);
                post.setCategory_id(category_id);
                post.setPost_title(post_title);
                post.setPost_content(post_content);
                post.setAccount(account);
                post.setImage(image);
                post.setPos_value(pos_value);
                post.setIs_refinement(is_refinement);
                post.setPost_time(post_time);
                Post_editing.add(post);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return Post_editing;
    }
}
