package controller.ReplyController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import vo.Reply;
import service.ReplyService;
import java.sql.*;
import controller.OutputController.ResJson;

public class ReplyAndSave extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Reply reply=new Reply();
     String  spost_id=request.getParameter("post_id");
     int post_id=Integer.parseInt(spost_id);
     String account=request.getParameter("account");
     Timestamp reply_time=new Timestamp(new java.util.Date().getTime());
     String reply_content=request.getParameter("reply_content");
     String sreply_id=request.getParameter("reply_id");
     int reply_id=Integer.parseInt(sreply_id);
     String image=request.getParameter("image");
     if(reply_content.equals("")&&image.equals(""))
     {
         response.getWriter().println(ResJson.generateResJson(-2,"操作失败,回复图片和内容不能同时为空",""));
         return;
     }
     reply.setPost_id(post_id);
     reply.setAccount(account);
     reply.setReply_time(reply_time);
     reply.setReply_content(reply_content);
     reply.setReply_id(reply_id);
     reply.setImage(image);
     ReplyService replyService=new ReplyService();
     boolean ok=replyService.replyAndInsert(reply);
     if(ok)
     {
         response.getWriter().println(ResJson.generateResJson(1,"回复成功",""));
     }
     else
     {
         response.getWriter().println(ResJson.generateResJson(-1,"回复失败",""));
     }
    }
}
