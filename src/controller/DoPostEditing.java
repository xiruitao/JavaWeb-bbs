package controller;

import dao.JDBCUtil;
import dao.ResJson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DoPostEditing extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn= JDBCUtil.getConnection();
        String id1 = request.getParameter("post_id");//发出加精请求的帖子的ID
        if (id1 == null || id1.equals("")) {
            response.getWriter().println(ResJson.generateResJson(-1, "null", "none"));
        } else {
            int id = Integer.parseInt(id1);
            try {
                String sql1 = "select is_refinement from post where post_id='" + id + "';";
                Statement sta1 = conn.createStatement();
                ResultSet rs1 = sta1.executeQuery(sql1);
                int is_refinement = 0;
                while (rs1.next()) {
                    is_refinement = rs1.getInt("is_refinement");
                }
                if(is_refinement==1){
                    response.getWriter().println(ResJson.generateResJson(2, "Already Editing", "none"));
                }else {
                    String sql="update post set is_refinement='"+1+"' where post_id='"+id+"';";
                    Statement sta=conn.createStatement();
                    int rs=sta.executeUpdate(sql);
                    if(rs==1)
                        response.getWriter().println(ResJson.generateResJson(1, "Editing Successful", id));
                    else
                        response.getWriter().println(ResJson.generateResJson(0, "Editing Unsuccessful","none" ));
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
