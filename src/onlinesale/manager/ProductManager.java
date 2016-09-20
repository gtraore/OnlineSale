package onlinesale.manager;

import java.io.Serializable;
import java.util.List;

import onlinesale.model.Cart;
import onlinesale.model.Category;
import onlinesale.model.Manufacturer;
import onlinesale.model.Product;

public interface ProductManager extends Serializable{

    public Product getProduct(int id);

    public List<Product> getProductsByCategory(int categoryId);

    public List<Product> getAllProducts();
    
    public Category getCategory(int id);

    public List<Category> getAllCategories();

    public Manufacturer getManufacturer(int id);

    public List<Manufacturer> getAllManufacturers();

    public Cart getCart(int id);

    public List<Cart> getAllCarts();
}
