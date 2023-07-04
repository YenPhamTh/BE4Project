package utility.connection;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import be04.entity.Category;

import be04.service.CategoryService;


public class ConnectionMainCate {
	public static void main(String[] args)throws SQLException {
		CategoryService cs = new CategoryService();
		List<Category> list = new ArrayList<Category>();
		list = cs.getAllCategories();
		System.out.println(list.size());
		for (Category category : list) {
		System.out.println(category.getId() + " - " + category.getName());
	}
}
}
