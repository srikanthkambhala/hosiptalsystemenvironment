package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Doctor;

public class DoctorDao {
	private Connection connection;

	public DoctorDao(Connection connection) {
		super();
		this.connection = connection;
	}
    public boolean insertDoctor(Doctor d) {
    	 boolean f = false;
    	
    	String query = "insert into hospitalmanagementsystem.doctor(fullname,dob,qualification,specialist,email,mobileNo,password) value(?,?,?,?,?,?,?)";
    	try {
			PreparedStatement ps = connection.prepareStatement(query);
		    ps.setString(1,d.getFullName() );
		    ps.setString(2, d.getDob());
		    ps.setString(3, d.getQualification());
		    ps.setString(4,d.getSpecialist());
		    ps.setString(5, d.getEmail());
		    ps.setString(6, d.getMobNo());
		    ps.setString(7, d.getPassword());
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
    public List<Doctor> getAllDoctor() {
    	
    	List<Doctor> list = new ArrayList<Doctor>();
    	Doctor d = null;
    	
    	String query = "select * from hospitalmanagementsystem.doctor order by id desc";
    	
    	try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				d= new Doctor();
				d.setId(rs.getInt(1));
				d.setFullName(rs.getString(2));
				d.setDob(rs.getString(3));
				d.setQualification(rs.getString(4));
				d.setSpecialist(rs.getString(5));
				d.setEmail(rs.getString(6));
				d.setMobNo(rs.getString(7));
				d.setPassword(rs.getString(8));
				list.add(d);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
    	
		
	}
    public Doctor getDoctorById(int id) {
    	Doctor d = null;
    	String query = "select * from hospitalmanagementsystem.doctor where id=?";
    	try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				d= new Doctor();
				d.setId(rs.getInt(1));
				d.setFullName(rs.getString(2));
				d.setDob(rs.getString(3));
				d.setQualification(rs.getString(4));
				d.setSpecialist(rs.getString(5));
				d.setEmail(rs.getString(6));
				d.setMobNo(rs.getString(7));
				d.setPassword(rs.getString(8));
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
		
	}
    public boolean updateDoctor(Doctor d) {
    	boolean f= false;
    	String query = "update hospitalmanagementsystem.doctor  set fullname=?,dob=?,qualification=?,specialist=?,email=?,mobileNo=?,password=? where id=?";
		try {
			PreparedStatement ps =connection.prepareStatement(query);
			ps.setString(1,d.getFullName() );
		    ps.setString(2, d.getDob());
		    ps.setString(3, d.getQualification());
		    ps.setString(4,d.getSpecialist());
		    ps.setString(5, d.getEmail());
		    ps.setString(6, d.getMobNo());
		    ps.setString(7, d.getPassword());
		    ps.setInt(8, d.getId());
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
    public boolean deleteDoctor(int id) {
    	boolean f = false;
    	String sql = "delete from hospitalmanagementsystem.doctor where id=?";
    	try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
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
    public Doctor login(String email,String password) {
    	Doctor d = null;
    	String query = "select * from hospitalmanagementsystem.doctor where email=? and password=?";
    	try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				d = new Doctor();
				d.setId(rs.getInt(1));
				d.setFullName(rs.getString(2));
				d.setDob(rs.getString(3));
				d.setQualification(rs.getString(4));
				d.setSpecialist(rs.getString(5));
				d.setEmail(rs.getString(6));
				d.setMobNo(rs.getString(7));
				d.setPassword(rs.getString(8));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		return d;
		
	}
    public int countDoctor() {
    	int i = 0;
    	String query = "select * from hospitalmanagementsystem.doctor";
    	try {
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				i++;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return i;
		
	}
    
    public int countUser() {
    	int i = 0;
    	String query = "select * from hospitalmanagementsystem.userdetails";
    	try {
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				i++;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return i;
		
	}
    
    public int countSpecialist() {
    	int i = 0;
    	String query = "select * from hospitalmanagementsystem.specialist";
    	try {
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				i++;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return i;
		
	}
    
    public int totalAppointments() {
    	int i = 0;
    	String query = "select * from hospitalmanagementsystem.appointment";
    	try {
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				i++;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return i;
		
	}
    public int countAppointByDoctorId(int did) {
    	int i = 0;
    	String query = "select * from hospitalmanagementsystem.appointment where doctorId =?";
    	 
    	try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, did);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				i++;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return i;
		
	}
    
    public boolean checkOldPassword(int docId,String oldPassword) {
		boolean f = false;
		String query = "select * from hospitalmanagementsystem.doctor where id=? and password=?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, docId);
			ps.setString(2, oldPassword);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				f=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
		
	}
	public boolean changePassword(int docId,String newPassword) {
		boolean f = false;
		
		String sql = "update hospitalmanagementsystem.doctor set password =? where id=? ";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, newPassword);
			ps.setInt(2, docId);
			
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
	
	public boolean editDoctorProfile(Doctor d) {
    	boolean f= false;
    	String query = "update hospitalmanagementsystem.doctor  set fullname=?,dob=?,qualification=?,specialist=?,email=?,mobileNo=? where id=?";
		try {
			PreparedStatement ps =connection.prepareStatement(query);
			ps.setString(1,d.getFullName() );
		    ps.setString(2, d.getDob());
		    ps.setString(3, d.getQualification());
		    ps.setString(4,d.getSpecialist());
		    ps.setString(5, d.getEmail());
		    ps.setString(6, d.getMobNo());
		    
		    ps.setInt(7, d.getId());
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
    	
		
    
    
    

}
