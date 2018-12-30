package dao.impl;

import dao.*;
import vo.Category;
import vo.CategoryStatistics;
import java.sql.*;
import java.util.ArrayList;

public class CategoryDaoImpl implements  CategoryDao{
    @Override
    public ArrayList<Category> findAll() {
        Connection conn=JDBCUtil.getConnection();
        ArrayList<Category> category_informaiton=new ArrayList<Category>();
        try{
            String sql="select * from category_p";
            Statement sta=conn.createStatement();
            ResultSet rs=sta.executeQuery(sql);
            while(rs.next())
            {
                Category category=new Category();
                int category_id=rs.getInt("category_id");
                String category_name=rs.getString("category_name");
                category.setCategory_id(category_id);
                category.setCategory_name(category_name);
                category_informaiton.add(category);
            }
            sta.close();
            rs.close();
            conn.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return category_informaiton;
    }
    public ArrayList<CategoryStatistics> getStatisticsByPostNum()
    {
        ArrayList<CategoryStatistics> statistics=new ArrayList<CategoryStatistics>();
        Connection conn=JDBCUtil.getConnection();
        try{
            String sql1="select category_id,count(*) as number from post group by category_id ";
            Statement sta1=conn.createStatement();
            ResultSet rs1=sta1.executeQuery(sql1);
            while (rs1.next())
            {
                CategoryStatistics categoryStatistics=new CategoryStatistics();
                int category_id=rs1.getInt("category_id");
                int number=rs1.getInt("number");
                categoryStatistics.setCategory_id(category_id);
                categoryStatistics.setNum(number);
                statistics.add(categoryStatistics);
            }
            sta1.close();
            rs1.close();
            conn.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return statistics;
    }
    public String getCategoryNameById(int category_id)
    {
        Connection conn=JDBCUtil.getConnection();
        String category_name="";
        try{
            String sql=" select category_name from category_p where category_id=?";
            PreparedStatement psta=conn.prepareStatement(sql);
            psta.setInt(1,category_id);
            ResultSet rs=psta.executeQuery();
            while (rs.next())
            {
                category_name=rs.getString("category_name");
            }
            psta.close();
            rs.close();
            conn.close();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return category_name;
    }
}
