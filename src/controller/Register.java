package controller;

import dao.ResJson;
import org.json.JSONObject;
import service.MyUserLOginService;
import service.MyUserService;
import vo.MyUser;
import vo.MyUserLogin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/register")
public class Register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MyUserLOginService myUserLOginService = new MyUserLOginService();
        MyUserService myUserService = new MyUserService();
        JSONObject json = new JSONObject(ResJson.getRequestBody(request.getInputStream()));
        MyUser myUser = new MyUser();
        MyUserLogin myUserLogin = new MyUserLogin();
        myUserLogin.setAccount(json.getString("account"));
        myUserLogin.setPassword(json.getString("password"));
        myUser.setUser_id(json.getString("account"));
        myUser.setBirthday(json.getString("age"));
        myUser.setOccupation(json.getString("occupation"));
        myUser.setPlace_of_province("place");
        myUser.setSex(json.getString("sex"));
        myUser.setTel(json.getString("tel"));
        myUser.setUsername(json.getString("username"));
        if (myUserService.register(myUser) && myUserLOginService.register(myUserLogin)) {
            response.getWriter().println(ResJson.generateResJson(0, "注册成功", "无"));
        } else {
            response.getWriter().println(ResJson.generateResJson(1, "注册失败", "用户id已存在"));
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
