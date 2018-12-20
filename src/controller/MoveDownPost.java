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

public class MoveDownPost extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn= JDBCUtil.getConnection();

        String id1 = request.getParameter("post_id");//发出下移请求的帖子(属于置顶的帖子)的ID
        int id = 0;
        if (id1 == null || id1.equals("")) {
            response.getWriter().println(ResJson.generateResJson(-1, "null", "none"));
        } else {
            id = Integer.parseInt(id1);
            try{
                String sql1="select pos_value from post where post_id='"+id+"';";
                Statement sta1=conn.createStatement();
                ResultSet rs1 = sta1.executeQuery(sql1);
                int postValue = 0;
                while (rs1.next()){
                    postValue = rs1.getInt("pos_value");
                }

                if(postValue == 1){
                    response.getWriter().println(ResJson.generateResJson(0, "Already the down",id));
                }else{
                    String sql2 = "select post_id from post where pos_value='"+(postValue-1)+"';";
                    Statement sta2 = conn.createStatement();
                    ResultSet rs2 = sta2.executeQuery(sql2);
                    int postId = 0;
                    while (rs2.next()){
                        postId = rs2.getInt("post_id");
                    }

                    String sql="update post set pos_value='"+(postValue-1)+"' where post_id='"+id+"';";

                    String sql3="update post set pos_value='"+postValue+"' where post_id='"+postId+"';";
                    Statement sta=conn.createStatement();
                    Statement sta3=conn.createStatement();
                    int rs=sta.executeUpdate(sql);
                    int rs3=sta3.executeUpdate(sql3);
                    if(rs==1&&rs3==1)
                        response.getWriter().println(ResJson.generateResJson(1, "Move down Successful", id));
                    else
                        response.getWriter().println(ResJson.generateResJson(0, "Move down Unsuccessful","none" ));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
