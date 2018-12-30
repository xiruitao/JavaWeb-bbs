package controller.PostController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import vo.Post;
import java.util.*;
import service.PostService;
import controller.OutputController.ResJson;
import org.json.JSONObject;
public class GetPosts extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PostService postService=new PostService();
        ArrayList<Post> posts=postService.showPostByTimeOrder();
        JSONObject postsJson=new JSONObject();
        postsJson.put("posts",posts);
        response.getWriter().println(ResJson.generateResJson(1,"信息请求成功",postsJson));

    }
}
