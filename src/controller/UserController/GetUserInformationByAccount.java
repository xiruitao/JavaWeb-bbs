package controller.UserController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import vo.*;
import service.*;
import controller.OutputController.ResJson;
import org.json.JSONObject;
public class GetUserInformationByAccount extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account=request.getParameter("account");
        UserService userService=new UserService();
        User user=userService.getUserInformationByAccount(account);
        if(user.getAccount()=="")
        {
            response.getWriter().println(ResJson.generateResJson(-1,"无该用户信息请求失败",""));
        }
        else{
        JSONObject userJson=new JSONObject();
        userJson.put("user_name",user.getUser_name());
        userJson.put("birthday",user.getBirthday());
        userJson.put("sex",user.getSex());
        userJson.put("place_of_province",user.getPlace_of_province());
        userJson.put("occupation",user.getOccupation());
        userJson.put("head_image",user.getHead_image());
        userJson.put("tel",user.getTel());
        userJson.put("score",user.getScore());
        response.getWriter().println(ResJson.generateResJson(1,"信息请求成功",userJson));}
    }
}
