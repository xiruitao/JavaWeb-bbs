package controller.PostController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import service.PostService;
import vo.Post;
import controller.OutputController.*;
import org.json.JSONObject;
public class GetPostByAccount extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account=request.getParameter("account");
        PostService postService=new PostService();
        ArrayList<Post> posts=postService.getPostByAccount(account);
        if(posts.isEmpty())
        {
            response.getWriter().println(ResJson.generateResJson(-1,"当前账户尚未发送任何贴子",""));
            return;
        }
        else
        {
        JSONObject postsJson=new JSONObject();
        postsJson.put("posts",posts);
        response.getWriter().println(ResJson.generateResJson(1,"信息请求成功",postsJson));}
    }
}
