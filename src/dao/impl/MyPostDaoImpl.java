package dao.impl;

import dao.JDBCUtil;
import dao.MyPostDao;
import vo.MyPost;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MyPostDaoImpl implements MyPostDao {
    @Override
    public boolean PublishTie(MyPost myPost) {
        Connection con = JDBCUtil.getConnection();
        PreparedStatement pstmt = null;
        String sql = "insert into post(category_id,post_title,post_content,account,image,post_time,post_score) values(?,?,?,?,?,?,?)";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,myPost.getCategory_id());
            pstmt.setString(2,myPost.getPost_title());
            pstmt.setString(3,myPost.getPost_content());
            pstmt.setString(4,myPost.getAccount());
            pstmt.setString(5,myPost.getImage());
            pstmt.setString(6,myPost.getPost_time());
            pstmt.setInt(7,myPost.getPost_score());
            int rs = pstmt.executeUpdate();
            if (rs > 0) {
                JDBCUtil.closeAll(con, pstmt, null);
                return true;
            } else {
                JDBCUtil.closeAll(con, pstmt, null);
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JDBCUtil.closeAll(con, pstmt, null);
            return false;
        }
    }

    @Override
    public ArrayList<MyPost> getScoreTieByTime() {
        ArrayList<MyPost> list = new ArrayList<>();
        Connection con = JDBCUtil.getConnection();
        PreparedStatement pstmt = null;
        // 已完成 is_finish > 0
        String sql = "select * from post where category_id = 0 and is_finish = 0 order by post_time";
        try {
            pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                MyPost myPost = new MyPost();
                String time = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(rs.getTimestamp("post_time"));
                myPost.setPost_score(rs.getInt("post_score"));
                myPost.setPost_time(time);
                myPost.setPost_title(rs.getString("post_title"));
                myPost.setPost_content(rs.getString("post_content"));
                myPost.setImage(rs.getString("image"));
                myPost.setAccount(rs.getString("account"));
                myPost.setIs_finish(rs.getInt("is_finish"));
                myPost.setPost_id(rs.getInt("post_id"));
                list.add(myPost);
            }
            JDBCUtil.closeAll(con, pstmt, null);
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateFinishStatus(MyPost myPost) {
        Connection con = JDBCUtil.getConnection();
        PreparedStatement pstmt = null;
        String sql = "update post set is_finish = 1 where post_id = ?";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, myPost.getPost_id());
            int rs = pstmt.executeUpdate();
            if (rs > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
