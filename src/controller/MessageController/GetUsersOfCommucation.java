package controller.MessageController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.json.*;
import controller.OutputController.*;
import service.MessageService;
import vo.*;
import java.util.*;
public class GetUsersOfCommucation extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account=request.getParameter("account");
        MessageService messageService=new MessageService();
        ArrayList<User> users=messageService.getUsersOfCommunication(account);
        if(users.isEmpty())
        {
            response.getWriter().println(ResJson.generateResJson(-1,"该用户暂未和任何用户聊天",""));
            return;
        }
        JSONObject usersJson=new JSONObject();
        usersJson.put("users",users);
        response.getWriter().println(ResJson.generateResJson(1,"信息请求成功",usersJson));

    }
}
