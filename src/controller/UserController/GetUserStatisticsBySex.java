package controller.UserController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import controller.OutputController.ResJson;
import service.UserService;
import org.json.JSONObject;

public class GetUserStatisticsBySex extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService=new UserService();
        ArrayList<JSONObject> userStatisticsJson=new ArrayList<JSONObject>();
        ArrayList<Integer> userStatistics=userService.getStatisticsBySex();
        int sum=0;
        for(int i=0;i<2;i++)
        {
            sum+=userStatistics.get(i);
        }
        if(sum==0)
        {
            response.getWriter().println(ResJson.generateResJson(-1,"当前无用户,操作失败",""));
            return ;
        }
        JSONObject ManInformation=new JSONObject();
        ManInformation.put("性别","男");
        ManInformation.put("人数",userStatistics.get(0));
        userStatisticsJson.add(ManInformation);
        JSONObject WomanInformation=new JSONObject();
        WomanInformation.put("性别","女");
        WomanInformation.put("人数",userStatistics.get(1));
        userStatisticsJson.add(WomanInformation);
        response.getWriter().println(ResJson.generateResJson(1,"信息请求成功",userStatisticsJson));
    }
}
