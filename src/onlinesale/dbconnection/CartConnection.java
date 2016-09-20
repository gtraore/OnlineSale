package onlinesale.dbconnection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import onlinesale.model.Cart;

public class CartConnection {
	
	private static CartConnection instance;

	private PreparedStatement insertCartStmt;
	private PreparedStatement getCartContentStmt;
	private PreparedStatement addCartContentStmt;
	private PreparedStatement setQuantityInCartStmt;
	private PreparedStatement getQuantityInCartStmt;
	
	private PreparedStatement getCartStmt;
	private PreparedStatement getAllCartsStmt;

	private String insertCartQuery = "INSERT onlinesale.cart(totalAmount, dateCreated, lastUpdate)  VALUES (?,?,?)";
	private String getCartContentQuery = "SELECT * FROM onlinesale.orderMapping where cart_id=?";
	private String addCartContentQuery = "INSERT onlinesale.orderMapping(cart_id, product_id, quantity) VALUES (?,?,1)";
	private String setQuantityInCartQuery = "UPDATE onlinesale.orderMapping set quantity=? where cart_id=? and product_id=?";
	private String getQuantityInCartQuery = "SELECT quantity FROM onlinesale.orderMapping where cart_id=? and product_id=?";
	
	private String getCartQuery = "SELECT id, totalAmount, dateCreated, lastUpdate " +
			"FROM onlinesale.cart where id=?";
	private String getAllCartsQuery = "SELECT id, totalAmount, dateCreated, lastUpdate " +
			"FROM onlinesale.cart";

	public static CartConnection getInstance(){
		if(instance == null){
			instance = new CartConnection();
		}
		return instance;
	}

	public CartConnection(){
		try{
			insertCartStmt = DBConnection.getInstance().getConnection().prepareStatement(insertCartQuery, Statement.RETURN_GENERATED_KEYS);
			getCartContentStmt = DBConnection.getInstance().getConnection().prepareStatement(getCartContentQuery);
			addCartContentStmt = DBConnection.getInstance().getConnection().prepareStatement(addCartContentQuery);
			getQuantityInCartStmt = DBConnection.getInstance().getConnection().prepareStatement(getQuantityInCartQuery);
			setQuantityInCartStmt = DBConnection.getInstance().getConnection().prepareStatement(setQuantityInCartQuery);
			
			getCartStmt = DBConnection.getInstance().getConnection().prepareStatement(getCartQuery);
			getAllCartsStmt = DBConnection.getInstance().getConnection().prepareStatement(getAllCartsQuery);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public Cart insertCart(){
		Cart cart = new Cart();
		java.util.Date now = new java.util.Date();
		Date date = new Date(now.getTime());
		try{
			insertCartStmt.setDouble(1, 0.0);
			insertCartStmt.setDate(2, date);
			insertCartStmt.setDate(3, date);

			insertCartStmt.executeUpdate();
			
			ResultSet tableKeys = insertCartStmt.getGeneratedKeys();
			tableKeys.next();
			cart.setId(tableKeys.getInt(1));
			cart.setTotalAmount(0.0);
			cart.setDateCreated(now);
			cart.setLastUpdate(now);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return cart;
    }
	
	public Map<Integer, Integer> getCartContentStmt(int cartId){
		Map<Integer, Integer> content = new HashMap<Integer, Integer>();
		
		try{
			getCartContentStmt.setInt(1, cartId);
			
			ResultSet resultSet = getCartContentStmt.executeQuery();
			while(resultSet.next()){
				content.put(resultSet.getInt(2), resultSet.getInt(3));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return content;
    }
	
	public Cart addCartContent(int cartId, int productId){
		Cart cart = null;
		try{
			addCartContentStmt.setInt(1, cartId);
			addCartContentStmt.setInt(2, productId);

			addCartContentStmt.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return cart;
    }
	
	public int getQuantityInCart(int cartId, int productId){
		int quantity = 0;
		try{
			getQuantityInCartStmt.setInt(1, cartId);
			getQuantityInCartStmt.setInt(2, productId);
			
			ResultSet resultSet = getQuantityInCartStmt.executeQuery();
			if(resultSet.next()){
				quantity = resultSet.getInt(1);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return quantity;
    }
	
	public void setQuantityInCart(int quantity, int cartId, int productId){
		try{
			setQuantityInCartStmt.setInt(1, quantity);
			setQuantityInCartStmt.setInt(2, cartId);
			setQuantityInCartStmt.setInt(3, productId);

			setQuantityInCartStmt.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();
		}
    }
	
	public Cart getCart(int id){
		Cart cart = null;
		try{
			getCartStmt.setInt(1, id);

			ResultSet resultSet = getCartStmt.executeQuery();
			if(resultSet.next()){
				cart = new Cart();
				cart.setId(resultSet.getInt(1));
				cart.setTotalAmount(resultSet.getDouble(2));
				cart.setDateCreated(resultSet.getDate(3));
				cart.setLastUpdate(resultSet.getDate(4));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return cart;
    }

    public List<Cart> getAllCarts(){
    	List<Cart> searchResults = new ArrayList<Cart>();
		try{
			ResultSet resultSet = getAllCartsStmt.executeQuery();
			while(resultSet.next()){
				Cart cart = new Cart();
				cart.setId(resultSet.getInt(1));
				cart.setTotalAmount(resultSet.getDouble(2));
				cart.setDateCreated(resultSet.getDate(3));
				cart.setLastUpdate(resultSet.getDate(4));
				searchResults.add(cart);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return searchResults;
    }
}
