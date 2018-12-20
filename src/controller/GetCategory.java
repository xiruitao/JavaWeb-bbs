package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import service.CategoryService;
import dao.*;
import java.util.*;
import java.io.*;
import vo.Category;
import org.json.JSONObject;
public class GetCategory extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        CategoryService categoryService=new CategoryService();
        ArrayList<Category> categories=categoryService.findAll();
        JSONObject data=new JSONObject();
        data.put("categories",categories);
        out.println(ResJson.generateResJson(1,"贴吧类别信息请求成功",data));
    }
}
