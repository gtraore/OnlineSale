package onlinesale.model;

import java.io.Serializable;
import java.util.Date;

public class Cart implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int _id;
    private double _totalAmount;
    Date _dateCreated;
    Date _lastUpdate;
    
    public int getId() {
        return _id;
    }
    
    public void setId(int id) {
        _id = id;
    }
    
    public double getTotalAmount() {
        return _totalAmount;
    }
    
    public void setTotalAmount(double totalAmount) {
    	_totalAmount = totalAmount;
    }
    
    public Date getDateCreated() {
        return _dateCreated;
    }
    
    public void setDateCreated(Date dateCreated) {
    	_dateCreated = dateCreated;
    }
    
    public Date getLastUpdate() {
        return _lastUpdate;
    }
    
    public void setLastUpdate(Date lastUpdate) {
    	_lastUpdate = lastUpdate;
    }
}
