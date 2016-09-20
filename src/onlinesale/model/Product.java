package onlinesale.model;

import java.io.Serializable;

public class Product implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int _id;
    private String _name;
    private int _categoryId;
    private int _manufacturerId;
    private double _price;
	private String _imgurl;
	private String _description;
    
    public int getId() {
        return _id;
    }
    
    public void setId(int id) {
        _id = id;
    }
    
    public String getName() {
        return _name;
    }
    
    public void setName(String name) {
        _name = name;
    }
    
    public int getCategoryId() {
        return _categoryId;
    }
    
    public void setCategoryId(int categoryId) {
    	_categoryId = categoryId;
    }
    
    public int getManufacturerId() {
        return _manufacturerId;
    }
    
    public void setManufacturerId(int manufacturerId) {
    	_manufacturerId = manufacturerId;
    }
    
    public double getPrice() {
        return _price;
    }
    
    public void setPrice(double price) {
        _price = price;
    }
    
    public String getImgurl() {
        return _imgurl;
    }
    
    public void setImgurl(String imgurl) {
    	_imgurl = imgurl;
    }
    
    public String getDescription() {
        return _description;
    }
    
    public void setDescription(String description) {
        _description = description;
    }
}
