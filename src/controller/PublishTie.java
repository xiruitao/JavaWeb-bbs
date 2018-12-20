package controller;

import dao.ResJson;
import org.json.JSONObject;
import service.MyPostService;
import vo.MyPost;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/api/publishTie")
public class PublishTie extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MyPost myPost = new MyPost();
        MyPostService myPostService = new MyPostService();
        JSONObject json = new JSONObject(ResJson.getRequestBody(request.getInputStream()));
        myPost.setAccount(json.getString("account"));
        myPost.setCategory_id(json.getInt("category_id"));
        myPost.setImage(json.getString("image"));
        myPost.setPost_content(json.getString("post_content"));
        myPost.setPost_title(json.getString("post_title"));
        myPost.setPost_score(json.getInt("post_score"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        myPost.setPost_time(sdf.format(new Date()));
        if (myPostService.PublicTie(myPost)) {
            response.getWriter().println(ResJson.generateResJson(0, "请求成功", "无"));
        } else {
            response.getWriter().println(ResJson.generateResJson(1,"操作失败", "sqlError"));
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
