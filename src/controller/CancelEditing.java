package controller;

import dao.JDBCUtil;
import dao.ResJson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

public class CancelEditing extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn= JDBCUtil.getConnection();
        String id1 = request.getParameter("post_id");//发出取消加精请求的帖子的ID
        int id;
        if (id1 == null || id1.equals("")) {
            response.getWriter().println(ResJson.generateResJson(-1, "null", "none"));
        } else {
            id = Integer.parseInt(id1);
            try{
                String sql="update post set is_refinement='"+0+"' where post_id='"+id+"';";
                Statement sta=conn.createStatement();
                int rs=sta.executeUpdate(sql);
                if(rs==1)
                    response.getWriter().println(ResJson.generateResJson(1, "Cancel Editing Successful", id));
                else
                    response.getWriter().println(ResJson.generateResJson(0, "Cancel Editing Unsuccessful","none" ));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
