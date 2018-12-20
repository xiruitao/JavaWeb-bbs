package dao.impl;

import dao.*;
import vo.Category;
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
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return category_informaiton;
    }
}
