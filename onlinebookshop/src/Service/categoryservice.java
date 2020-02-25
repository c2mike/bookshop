package Service;

import Dao.Category;
import Dao.CategoryDao;
import Dao.Page;

import java.util.List;

public class categoryservice {
    CategoryDao categoryDao = new CategoryDao();
    public List<Category> selectall()
    {
        return categoryDao.getallcategory();
    }

    public void insert(String name, String description)
    {
        Category category = new Category();
        category.setName(name);
        category.setDescription(description);
        categoryDao.addcategory(category);
    }

    public Category select(int id)
    {
        return null;
    }

    public void update(int id,String name,String description)
    {
        Category category = new Category();
        category.setId(id);
        category.setDescription(description);
        category.setName(name);
        categoryDao.updatecategory(category);
    }

    public void delete(int id)
    {
        categoryDao.deletecategory(id);
    }

    public Page getPage(int currentpagenum)
    {
        int pagecount = categoryDao.getcount();
        int start = (currentpagenum -1) * 2;
        int end = 2;
        List<Category> pagedata = categoryDao.getpagedata(start,end);
        Page<Category> page = new Page<Category>(currentpagenum,pagecount,pagedata);
        return page;
    }


}
