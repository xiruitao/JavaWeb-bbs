package controller.PostController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import controller.OutputController.ResJson;
import service.PostService;
import org.json.JSONObject;


public class DeletePost extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String spost_id=request.getParameter("post_id");
        if(spost_id==null)
        {
            response.getWriter().println(ResJson.generateResJson(-1,"操作失败",""));
            return;
        }
        int post_id=Integer.parseInt(spost_id);
        PostService postService=new PostService();
        boolean ok=postService.deletePost(post_id);
        if(ok)
        {
            response.getWriter().println(ResJson.generateResJson(1,"删帖成功",""));
        }
        else
        {
            response.getWriter().println(ResJson.generateResJson(-1,"删帖失败",""));
        }
    }
}
