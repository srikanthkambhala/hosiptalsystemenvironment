package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Specalist;

public class SpecialistDao {
	private Connection connection;

	public SpecialistDao(Connection connection) {
		super();
		this.connection = connection;
	}
    public boolean addSpecialist(String specialist) {
    	boolean f = false;
    	String query = "insert into hospitalmanagementsystem.specialist(specialistname) values(?)";
    	try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1,specialist );
			
			int i = ps.executeUpdate();
			if (i>0) {
				 f=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
		
	}
    public List<Specalist> getAllSpecialist() {
    	List<Specalist> list = new ArrayList<Specalist>();
    	Specalist s = null;
    	String query = "select * from  hospitalmanagementsystem.specialist";
    	try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				s = new Specalist();
				s.setId(rs.getInt(1));
				s.setSpecialistName(rs.getString(2));
				list.add(s);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	
	

}
