package dao;

import vo.Category;
import vo.CategoryStatistics;

import java.util.*;
public interface CategoryDao {
    public ArrayList<Category> findAll();
    public ArrayList<CategoryStatistics> getStatisticsByPostNum();
    public String getCategoryNameById(int category_id);
}
