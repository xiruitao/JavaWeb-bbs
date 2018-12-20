package service;

import vo.*;
import dao.*;
import dao.impl.*;
import java.util.*;
public class CategoryService {
    private CategoryDao category = new CategoryDaoImpl();
    public ArrayList<Category> findAll(){
        return category.findAll();
    }
}
