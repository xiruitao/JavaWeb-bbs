package controller.PostController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import service.PostService;
import vo.Post;
import controller.OutputController.ResJson;
import java.sql.*;

public class SendPost extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String scategory_id=request.getParameter("category_id");
        if(scategory_id.equals(""))
        {
            response.getWriter().println(ResJson.generateResJson(-4,",操作失败,类别不能为空",""));
            return;
        }
        String image=request.getParameter("image");
        int category_id=Integer.parseInt(scategory_id);
        String post_title=request.getParameter("post_title");
        if(post_title.equals(""))
        {
            response.getWriter().println(ResJson.generateResJson(-3,"操作失败，贴子标题不能为空",""));
            return ;
        }
        String post_content=request.getParameter("post_content");
        if(post_content.equals("")&&image.equals(""))
        {
            response.getWriter().println(ResJson.generateResJson(-2,"操作失败，贴子内容和贴子图片不能同时为空",""));
            return;

        }
        String account=request.getParameter("account");
        if(account.equals(""))
        {
            response.getWriter().println(ResJson.generateResJson(-5,"操作失败,用户名不能为空",""));
            return;
        }
        Timestamp post_time=new Timestamp(new java.util.Date().getTime());
        Post post=new Post();
        post.setCategory_id(category_id);
        post.setPost_title(post_title);
        post.setPost_content(post_content);
        post.setAccount(account);
        post.setPost_time(post_time);
        post.setImage(image);
        PostService postService=new PostService();
        boolean ok=postService.sendPost(post);
        if(ok)
        {
            response.getWriter().println(ResJson.generateResJson(1,"发帖成功",""));
        }
        else
            response.getWriter().println(ResJson.generateResJson(-1,"发帖失败",""));

    }
}
