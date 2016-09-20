package onlinesale.dbconnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import onlinesale.model.Product;

public class ProductConnection {
	
	private static ProductConnection instance;
	
	private PreparedStatement getProductStmt;
	private PreparedStatement getProductByCategoryStmt;
	private PreparedStatement getAllProductsStmt;
	
	private String getProductQuery = "SELECT id, name, category_id, manufacturer_id, price, imgurl, description " +
			"FROM onlinesale.product where id=?";
	private String getProductByCategoryQuery = "SELECT id, name, category_id, manufacturer_id, price, imgurl, description " +
			"FROM onlinesale.product where category_id=?";
	private String getAllProductsQuery = "SELECT id, name, category_id, manufacturer_id, price, imgurl, description " +
			"FROM onlinesale.product";
	
	/*String getProductQuery = "SELECT product.id, product.name, category.name as 'category', manufacturer.name as 'manufacturer', price, imgurl, description " +
			"FROM onlinesale.product LEFT JOIN (onlinesale.category, onlinesale.manufacturer) " +
            "ON (category.id=product.category_id AND manufacturer.id=product.manufacturer_id) where product.id=?";
	
	String getProductByCategoryQuery = "SELECT product.id, product.name, category.name as 'category', manufacturer.name as 'manufacturer', price, imgurl, description " +
			"FROM onlinesale.product LEFT JOIN (onlinesale.category, onlinesale.manufacturer) " +
            "ON (category.id=product.category_id AND manufacturer.id=product.manufacturer_id) where category.id=?";
	
	String getAllProductsQuery = "SELECT product.id, product.name, category.name as 'category', manufacturer.name as 'manufacturer', price, imgurl, description " +
			"FROM onlinesale.product LEFT JOIN (onlinesale.category, onlinesale.manufacturer) " +
            "ON (category.id=product.category_id AND manufacturer.id=product.manufacturer_id)";*/

	
	public static ProductConnection getInstance(){
		if(instance == null){
			instance = new ProductConnection();
		}
		return instance;
	}

	public ProductConnection(){
		try{
			getProductStmt = DBConnection.getInstance().getConnection().prepareStatement(getProductQuery);
			getProductByCategoryStmt = DBConnection.getInstance().getConnection().prepareStatement(getProductByCategoryQuery);
			getAllProductsStmt = DBConnection.getInstance().getConnection().prepareStatement(getAllProductsQuery);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	

	public Product getProduct(int id){
		Product product = null;
		try{
			getProductStmt.setInt(1, id);

			ResultSet resultSet = getProductStmt.executeQuery();
			if(resultSet.next()){
				product = new Product();
				product.setId(resultSet.getInt(1));
				product.setName(resultSet.getString(2));
				product.setCategoryId(resultSet.getInt(3));
				product.setManufacturerId(resultSet.getInt(4));
				product.setPrice(resultSet.getDouble(5));
				product.setImgurl(resultSet.getString(6));
				product.setDescription(resultSet.getString(7));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return product;
    }

    public List<Product> getProductsByCategory(int categoryId){
    	List<Product> searchResults = new ArrayList<Product>();
		try{
			getProductByCategoryStmt.setInt(1, categoryId);
			ResultSet resultSet = getProductByCategoryStmt.executeQuery();
			while(resultSet.next()){
				Product product = new Product();
				product.setId(resultSet.getInt(1));
				product.setName(resultSet.getString(2));
				product.setCategoryId(resultSet.getInt(3));
				product.setManufacturerId(resultSet.getInt(4));
				product.setPrice(resultSet.getDouble(5));
				product.setImgurl(resultSet.getString(6));
				product.setDescription(resultSet.getString(7));
				searchResults.add(product);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return searchResults;
    }

    public List<Product> getAllProducts(){
    	List<Product> searchResults = new ArrayList<Product>();
		try{
			ResultSet resultSet = getAllProductsStmt.executeQuery();
			while(resultSet.next()){
				Product product = new Product();
				product.setId(resultSet.getInt(1));
				product.setName(resultSet.getString(2));
				product.setCategoryId(resultSet.getInt(3));
				product.setManufacturerId(resultSet.getInt(4));
				product.setPrice(resultSet.getDouble(5));
				product.setImgurl(resultSet.getString(6));
				product.setDescription(resultSet.getString(7));
				searchResults.add(product);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return searchResults;
    }
}
