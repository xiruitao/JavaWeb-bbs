package controller;

import dao.JDBCUtil;
import dao.ResJson;
import service.PostService;
import vo.Post;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DoPostSticky extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn= JDBCUtil.getConnection();
        PostService postService=new PostService();
        ArrayList<Post> posts=postService.postSticky();
        int no = posts.size()+1;
        String id1 = request.getParameter("post_id");//发出置顶请求的帖子的ID
        if (id1 == null || id1.equals("")) {
            response.getWriter().println(ResJson.generateResJson(-1, "null", "none"));
        } else {
            int id = Integer.parseInt(id1);
            try{
                String sql1="select pos_value from post where post_id='"+id+"';";
                Statement sta1=conn.createStatement();
                ResultSet rs1=sta1.executeQuery(sql1);
                int post_value=0;
                while (rs1.next()){
                    post_value=rs1.getInt("pos_value");
                }
                if (post_value>0){//如果帖子已经置顶
                    response.getWriter().println(ResJson.generateResJson(2, "Already Sticky","none" ));
                }
                else if (post_value==0){
                    String sql="update post set pos_value='"+no+"' where post_id='"+id+"';";
                    Statement sta=conn.createStatement();
                    int rs=sta.executeUpdate(sql);
                    if(rs==1)
                        response.getWriter().println(ResJson.generateResJson(1, "Sticky Successful", id));
                    else
                        response.getWriter().println(ResJson.generateResJson(0, "Sticky Unsuccessful","none" ));
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
