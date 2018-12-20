package dao.impl;

import dao.JDBCUtil;
import dao.MyUserLoginDao;
import dao.ResJson;
import vo.MyUserLogin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyUserLoginDaoImpl implements MyUserLoginDao {

    @Override
    public boolean login(MyUserLogin myUserLogin) {
        Connection con = JDBCUtil.getConnection();
        PreparedStatement pstmt = null;
        String sql = "select * from user_log_p where account = ?";
        String pwd = null;
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, myUserLogin.getAccount());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                pwd = rs.getString("password");
            }
            if (pwd.equals(myUserLogin.getPassword())) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean register(MyUserLogin myUserLogin) {
        Connection con = JDBCUtil.getConnection();
        PreparedStatement pstmt = null;
        String sql = "insert into user_log_p(account, password) values(?,?)";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, myUserLogin.getAccount());
            pstmt.setString(2, myUserLogin.getPassword());
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
