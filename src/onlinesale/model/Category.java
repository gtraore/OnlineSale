package onlinesale.model;

import java.io.Serializable;

public class Category implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int _id;
    private String _name;

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
}
