package controller.CategoryController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import vo.*;
import service.*;
import controller.OutputController.ResJson;
import org.json.JSONObject;
public class GetStatisticsByPostNum extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<CategoryStatistics> categoryStatistics=new ArrayList<CategoryStatistics>();
        CategoryService categoryService=new CategoryService();
        categoryStatistics=categoryService.getStatisticsByPostNum();
        ArrayList<JSONObject> statisticsJson=new ArrayList<JSONObject>();
        for(int i=0;i<categoryStatistics.size();i++)
        {
            CategoryStatistics categoryStatistics1=categoryStatistics.get(i);
            String category_name=categoryService.getCategoryNameById(categoryStatistics1.getCategory_id());
            categoryStatistics1.setCategory_name(category_name);
            JSONObject statistics=new JSONObject();
            statistics.put("类别",category_name);
            statistics.put("数量",categoryStatistics1.getNum());
            statisticsJson.add(statistics);
        }
        response.getWriter().println(ResJson.generateResJson(1,"信息请求成功",statisticsJson));
    }
}
