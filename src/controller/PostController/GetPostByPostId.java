package controller.PostController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import controller.OutputController.ResJson;
import service.PostService;
import service.UserService;
import service.CategoryService;
import vo.*;

import org.json.JSONObject;
public class GetPostByPostId extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String spost_id=request.getParameter("post_id");
        if(spost_id.equals(""))
        {
            response.getWriter().println(ResJson.generateResJson(-2,"未给出post_id,操作失败",""));
        }
        int post_id=Integer.parseInt(spost_id);
        PostService postService=new PostService();
        Post post=postService.getPostByPostId(post_id);
        if(post.getPost_title().equals(""))
        {
            response.getWriter().println(ResJson.generateResJson(-3,"无该帖子的信息,操作失败",""));
            return;
        }
        JSONObject postJson=new JSONObject();
        postJson.put("post_id",post.getPost_id());
        postJson.put("category_id",post.getCategory_id());
        postJson.put("post_title",post.getPost_title());
        postJson.put("post_content",post.getPost_content());
        postJson.put("account",post.getAccount());
        postJson.put("image",post.getImage());
        postJson.put("post_value",post.getPos_value());
        postJson.put("is_refinement",post.getIs_refinment());
        postJson.put("post_time",post.getPost_time());
        UserService userService=new UserService();
        User user=userService.getUserInformationByAccount(post.getAccount());
        postJson.put("user_name",user.getUser_name());
        postJson.put("head_imgage",user.getHead_image());
        CategoryService categoryService=new CategoryService();
        String categoryName=categoryService.getCategoryNameById(post.getCategory_id());
        postJson.put("category_name",categoryName);
        response.getWriter().println(ResJson.generateResJson(1,"信息请求成功",postJson));
    }
}
