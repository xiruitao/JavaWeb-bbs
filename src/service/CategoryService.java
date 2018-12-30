package service;

import vo.*;
import dao.*;
import dao.impl.*;
import java.util.*;
public class CategoryService {
    private CategoryDao categoryDao = new CategoryDaoImpl();
    public ArrayList<Category> findAll(){
        return categoryDao.findAll();
    }
    public String getCategoryNameById(int category_id){return  categoryDao.getCategoryNameById(category_id);}
    public ArrayList<CategoryStatistics> getStatisticsByPostNum(){
        return categoryDao.getStatisticsByPostNum();
    }
}
