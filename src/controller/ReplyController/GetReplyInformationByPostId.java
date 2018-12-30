package controller.ReplyController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import vo.Reply;
import service.ReplyService;
import java.util.*;
import org.json.JSONObject;
import controller.OutputController.ResJson;
public class GetReplyInformationByPostId extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String spost_id=request.getParameter("post_id");
        int post_id=Integer.parseInt(spost_id);
        ReplyService replyService=new ReplyService();
        ArrayList<ArrayList<Reply>> replyInformation=replyService.getReplyInformation(post_id);
        if(replyInformation.isEmpty())
        {
            response.getWriter().println(ResJson.generateResJson(-1,"当前贴子的回复为空",""));
        }
        else{
        JSONObject replyInformationJson=new JSONObject();
        replyInformationJson.put("replyInformation",replyInformation);
        response.getWriter().println(ResJson.generateResJson(1,"信息请求成功",replyInformationJson));}
    }
}
