package dao.impl;

import dao.JDBCUtil;
import dao.MyUserDao;
import vo.MyUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MyUserDaoImpl implements MyUserDao {

    @Override
    public boolean addScore(MyUser myUser) {
        Connection con = JDBCUtil.getConnection();
        PreparedStatement pstmt = null;
        String sql = "update user_information_p set score = score + ? where account = ?";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, myUser.getScore());
            pstmt.setString(2, myUser.getUser_id());
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
