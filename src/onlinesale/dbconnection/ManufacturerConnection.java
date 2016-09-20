package onlinesale.dbconnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import onlinesale.model.Manufacturer;

public class ManufacturerConnection {
	
	private static ManufacturerConnection instance;
	
	private PreparedStatement getManufacturerStmt;
	private PreparedStatement getAllManufacturersStmt;
	
	private String getManufacturerQuery = "SELECT id, name " +
			"FROM onlinesale.manufacturer where id=?";
	private String getAllManufacturersQuery = "SELECT id, name " +
			"FROM onlinesale.manufacturer";

	public static ManufacturerConnection getInstance(){
		if(instance == null){
			instance = new ManufacturerConnection();
		}
		return instance;
	}

	public ManufacturerConnection(){
		try{
			getManufacturerStmt = DBConnection.getInstance().getConnection().prepareStatement(getManufacturerQuery);
			getAllManufacturersStmt = DBConnection.getInstance().getConnection().prepareStatement(getAllManufacturersQuery);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	

	public Manufacturer getManufacturer(int id){
		Manufacturer manufacturer = null;
		try{
			getManufacturerStmt.setInt(1, id);

			ResultSet resultSet = getManufacturerStmt.executeQuery();
			if(resultSet.next()){
				manufacturer = new Manufacturer();
				manufacturer.setId(resultSet.getInt(1));
				manufacturer.setName(resultSet.getString(2));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return manufacturer;
    }

    public List<Manufacturer> getAllManufacturers(){
    	List<Manufacturer> searchResults = new ArrayList<Manufacturer>();
		try{
			ResultSet resultSet = getAllManufacturersStmt.executeQuery();
			while(resultSet.next()){
				Manufacturer manufacturer = new Manufacturer();
				manufacturer.setId(resultSet.getInt(1));
				manufacturer.setName(resultSet.getString(2));
				searchResults.add(manufacturer);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return searchResults;
    }
}
