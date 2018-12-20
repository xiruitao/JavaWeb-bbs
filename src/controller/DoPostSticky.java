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
        int id = 0;
        if (id1 == null || id1.equals("")) {
            response.getWriter().println(ResJson.generateResJson(-1, "null", "none"));
        } else {
            id = Integer.parseInt(id1);
            try{
                String sql="update post set pos_value='"+no+"' where post_id='"+id+"';";
                Statement sta=conn.createStatement();
                int rs=sta.executeUpdate(sql);
                if(rs==1)
                    response.getWriter().println(ResJson.generateResJson(1, "Sticky Successful", id));
                else
                    response.getWriter().println(ResJson.generateResJson(0, "Sticky Unsuccessful","none" ));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
