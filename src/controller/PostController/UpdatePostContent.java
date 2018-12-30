package controller.PostController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import service.PostService;
import controller.OutputController.ResJson;
import vo.Post;
public class UpdatePostContent extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String post_content=request.getParameter("post_content");
        if(post_content.equals(""))
        {
            response.getWriter().println(ResJson.generateResJson(-2,"操作失败,修改内容不能为空",""));
            return;
        }
        String spost_id=request.getParameter("post_id");
        int post_id=Integer.parseInt(spost_id);
        PostService postService=new PostService();
        boolean ok=postService.updatePostContent(post_content,post_id);
        if(ok)
        {
            response.getWriter().println(ResJson.generateResJson(1,"更新成功",""));
        }
        else
            response.getWriter().println(ResJson.generateResJson(-1,"更新失败",""));
    }
}
