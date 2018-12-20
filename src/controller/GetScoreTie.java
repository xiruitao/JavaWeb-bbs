package controller;

import dao.ResJson;
import service.MyPostService;
import vo.MyPost;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/api/getScoreTie")
public class GetScoreTie extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MyPostService myPostService = new MyPostService();
        ArrayList<MyPost> list = myPostService.getScoreTieByTime();
        if (list != null) {
            response.getWriter().println(ResJson.generateResJson(0, "获取成功", list));
        } else {
            response.getWriter().println(ResJson.generateResJson(1, "获取失败", "无"));
        }
    }
}
