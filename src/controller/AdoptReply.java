package controller;

import dao.ResJson;
import org.json.JSONObject;
import service.MyPostService;
import service.MyUserService;
import vo.MyPost;
import vo.MyUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/adoptReply")
public class AdoptReply extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MyPostService myPostService = new MyPostService();
        MyUserService myUserService = new MyUserService();
        MyUser myUser = new MyUser();
        MyPost myPost = new MyPost();
        JSONObject json = new JSONObject(ResJson.getRequestBody(request.getInputStream()));
        myUser.setUser_id(json.getString("account"));
        myPost.setPost_id(json.getInt("post_id"));
        myUser.setScore(json.getInt("post_score"));
        if (myPostService.updateFinishStatus(myPost) && myUserService.addScore(myUser)) {
            response.getWriter().println(ResJson.generateResJson(0, "操作成功", "无"));
        } else {
            response.getWriter().println(ResJson.generateResJson(1, "操作失败", "无"));
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
