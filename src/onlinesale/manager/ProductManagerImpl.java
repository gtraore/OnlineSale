package onlinesale.manager;

import java.util.List;

import onlinesale.dbconnection.CartConnection;
import onlinesale.dbconnection.CategoryConnection;
import onlinesale.dbconnection.ManufacturerConnection;
import onlinesale.dbconnection.ProductConnection;
import onlinesale.manager.ProductManager;
import onlinesale.model.Cart;
import onlinesale.model.Category;
import onlinesale.model.Manufacturer;
import onlinesale.model.Product;

public class ProductManagerImpl implements ProductManager {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Product getProduct(int id){
		return ProductConnection.getInstance().getProduct(id);
    }

    public List<Product> getProductsByCategory(int categoryId){
		return ProductConnection.getInstance().getProductsByCategory(categoryId);
    }

    public List<Product> getAllProducts(){
		return ProductConnection.getInstance().getAllProducts();
    }
    
    public Category getCategory(int id){
		return CategoryConnection.getInstance().getCategory(id);
    }

    public List<Category> getAllCategories(){
		return CategoryConnection.getInstance().getAllCategories();
    }

    public Manufacturer getManufacturer(int id){
		return ManufacturerConnection.getInstance().getManufacturer(id);
    }

    public List<Manufacturer> getAllManufacturers(){
		return ManufacturerConnection.getInstance().getAllManufacturers();
    }

    public Cart getCart(int id){
		return CartConnection.getInstance().getCart(id);
    }

    public List<Cart> getAllCarts(){
		return CartConnection.getInstance().getAllCarts();
    }
}
