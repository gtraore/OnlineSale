package onlinesale.dbconnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import onlinesale.model.Category;

public class CategoryConnection {
	
	private static CategoryConnection instance;
	
	private PreparedStatement getCategoryStmt;
	private PreparedStatement getAllCategoriesStmt;
	
	private String getCategoryQuery = "SELECT id, name " +
			"FROM onlinesale.category where id=?";
	private String getAllCategoriesQuery = "SELECT id, name " +
			"FROM onlinesale.category";

	public static CategoryConnection getInstance(){
		if(instance == null){
			instance = new CategoryConnection();
		}
		return instance;
	}

	public CategoryConnection(){
		try{
			getCategoryStmt = DBConnection.getInstance().getConnection().prepareStatement(getCategoryQuery);
			getAllCategoriesStmt = DBConnection.getInstance().getConnection().prepareStatement(getAllCategoriesQuery);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	

	public Category getCategory(int id){
		Category category = null;
		try{
			getCategoryStmt.setInt(1, id);

			ResultSet resultSet = getCategoryStmt.executeQuery();
			if(resultSet.next()){
				category = new Category();
				category.setId(resultSet.getInt(1));
				category.setName(resultSet.getString(2));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return category;
    }

    public List<Category> getAllCategories(){
    	List<Category> searchResults = new ArrayList<Category>();
		try{
			ResultSet resultSet = getAllCategoriesStmt.executeQuery();
			while(resultSet.next()){
				Category category = new Category();
				category.setId(resultSet.getInt(1));
				category.setName(resultSet.getString(2));
				searchResults.add(category);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return searchResults;
    }
}
