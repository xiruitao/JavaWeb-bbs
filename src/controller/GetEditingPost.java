package controller;

import dao.ResJson;
import org.json.JSONObject;
import service.PostService;
import vo.Post;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class GetEditingPost extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        PostService postService=new PostService();
        ArrayList<Post> posts=postService.postEditing();
        JSONObject data=new JSONObject();
        data.put("posts",posts);
        out.println(ResJson.generateResJson(1,"贴吧加精帖子信息",data));
    }
}
