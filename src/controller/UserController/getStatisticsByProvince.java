package controller.UserController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import vo.User;
import service.UserService;
import controller.OutputController.ResJson;
import org.json.JSONObject;
public class getStatisticsByProvince extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService=new UserService();
        ArrayList<Integer> statistics=userService.getStatisticsByProvinces();
        ArrayList<JSONObject> provinces=new ArrayList<JSONObject>();
        for(int i=0;i<35;i++)
        {
            String provinceName=userService.parseProvinceId(i);
            int number=statistics.get(i);
            JSONObject province=new JSONObject();
            province.put("省份",provinceName);
            province.put("人数",number);
            provinces.add(province);
        }
        /*int sum=data.get(6);
        if(sum==0)
        {
            response.getWriter().println(ResJson.generateResJson(-1,"操作失败,无用户省份信息",""));
            return;
        }
        int provinceId1=data.get(0);
        int number1=data.get(1);
        String provinceName1=userService.parseProvinceId(provinceId1);
        int provinceId2=data.get(2);
        int number2=data.get(3);
        String provinceName2=userService.parseProvinceId(provinceId2);
        int provinceId3=data.get(4);
        int number3=data.get(5);
        String provinceName3=userService.parseProvinceId(provinceId3);
        JSONObject province1=new JSONObject();
        province1.put("人数",number1);
        province1.put("省份名",provinceName1);
        provinces.add(province1);
        JSONObject province2=new JSONObject();
        province2.put("人数",number2);
        province2.put("省份名",provinceName2);
        provinces.add(province2);
        JSONObject province3=new JSONObject();
        province3.put("人数",number3);
        province3.put("省份名",provinceName3);
        provinces.add(province3);*/
        response.getWriter().println(ResJson.generateResJson(1,"信息请求成功",provinces));
    }
}
