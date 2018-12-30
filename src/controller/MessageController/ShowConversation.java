package controller.MessageController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONObject;
import controller.OutputController.*;
import service.*;
import vo.*;

public class ShowConversation extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account_1=request.getParameter("account_1");
        String account_2=request.getParameter("account_2");
        MessageService messageService=new MessageService();
        ArrayList<Message> conversation=messageService.showConversation(account_1,account_2);
        if(conversation.isEmpty())
        {
            response.getWriter().println(ResJson.generateResJson(-1,"当前两个用户并没有发送私信",""));
            return;
        }
        JSONObject Conversation=new JSONObject();
        Conversation.put("conversation",conversation);
        response.getWriter().println(ResJson.generateResJson(1,"信息请求成功",conversation));
    }
}
