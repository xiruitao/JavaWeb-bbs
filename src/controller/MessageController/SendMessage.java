package controller.MessageController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import vo.*;
import controller.OutputController.ResJson;
import service.MessageService;
public class SendMessage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account_send=request.getParameter("account_send");
        String account_receive=request.getParameter("account_receive");
        String message_content=request.getParameter("message_content");
        if(message_content.equals(""))
        {
            response.getWriter().println(ResJson.generateResJson(-2,"信息内容不能为空,操作失败",""));
            return;
        }
        Timestamp send_time=new Timestamp(new java.util.Date().getTime());
        Message message=new Message();
        message.setAccount_send(account_send);
        message.setAccount_receive(account_receive);
        message.setMessage_content(message_content);
        message.setSend_time(send_time);
        MessageService messageService=new MessageService();
        boolean ok=messageService.sendMessage(message);
        if(ok)
        {
            response.getWriter().println(ResJson.generateResJson(1,"发送成功",""));
        }
        else
        {
            response.getWriter().println(ResJson.generateResJson(-1,"发送失败"," "));
        }
    }
}
