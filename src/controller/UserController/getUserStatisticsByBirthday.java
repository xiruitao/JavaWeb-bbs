package controller.UserController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONObject;
import controller.OutputController.ResJson;
import service.UserService;
import vo.User;

public class getUserStatisticsByBirthday extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService=new UserService();
        ArrayList<Integer> statistics=userService.geStatisticsByBirthday();
        ArrayList<JSONObject> statisticsJson=new ArrayList<JSONObject>();
        int sum=statistics.get(6);
        if(sum==0)
        {
            response.getWriter().println(ResJson.generateResJson(-1,"无用户,操作失败",""));
            return;
        }
        JSONObject information00=new JSONObject();
        information00.put("年代","00后");
        information00.put("人数",statistics.get(0));
        statisticsJson.add(information00);
        JSONObject information90=new JSONObject();
        information90.put("年代","90后");
        information90.put("人数",statistics.get(1));
        statisticsJson.add(information90);
        JSONObject information80=new JSONObject();
        information80.put("年代","80后");
        information80.put("人数",statistics.get(2));
        statisticsJson.add(information80);
        JSONObject information70=new JSONObject();
        information70.put("年代","70后");
        information70.put("人数",statistics.get(3));
        statisticsJson.add(information70);
        JSONObject information60=new JSONObject();
        information60.put("年代","60后");
        information60.put("人数",statistics.get(4));
        statisticsJson.add(information60);
        JSONObject informationOther=new JSONObject();
        informationOther.put("年代","其他");
        informationOther.put("人数",statistics.get(5));
        statisticsJson.add(informationOther);
        response.getWriter().println(ResJson.generateResJson(1,"信息请求成功",statisticsJson));
    }
}
