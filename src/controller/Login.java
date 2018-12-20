package controller;

import dao.ResJson;
import org.json.JSONObject;
import service.MyUserLOginService;
import vo.MyUserLogin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MyUserLOginService myUserLOginService = new MyUserLOginService();
        JSONObject json = new JSONObject(ResJson.getRequestBody(request.getInputStream()));
        MyUserLogin myUserLogin = new MyUserLogin();
        myUserLogin.setAccount(json.getString("account"));
        myUserLogin.setPassword(json.getString("password"));
        if (myUserLOginService.login(myUserLogin)) {
            response.getWriter().println(ResJson.generateResJson(0, "登录成功", "无"));
        } else {
            response.getWriter().println(ResJson.generateResJson(1, "登录失败", "无"));
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
