package controller.PostController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import org.json.JSONObject;
import controller.OutputController.ResJson;
import vo.*;
import service.*;
public class GetPostStatisticsByReplyNum extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PostService postService=new PostService();
        CategoryService categoryService=new CategoryService();
        ArrayList<PostStatistic> postStatistics=postService.getPostStatisticsByReplyNum();
        for(int i=0;i<postStatistics.size();i++)
        {
            PostStatistic postStatistic=postStatistics.get(i);
            int post_id=postStatistic.getPost_id();
            String post_title=postService.getPostByPostId(post_id).getPost_title();
            postStatistic.setPost_title(post_title);
            Post post=postService.getPostByPostId(post_id);
            int category_id=post.getCategory_id();
            postStatistic.setCategory_id(category_id);
        }
        if(postStatistics.size()<=10)
        {
            response.getWriter().println(ResJson.generateResJson(1,"信息请求成功",postStatistics));
        }
        else
        {
            ArrayList<PostStatistic> topTen=new ArrayList<PostStatistic>();
            for(int i=0;i<10;i++)
            {
                topTen.add(postStatistics.get(i));
            }
            response.getWriter().println(ResJson.generateResJson(1,"信息请求成功",topTen));
        }
    }
}
