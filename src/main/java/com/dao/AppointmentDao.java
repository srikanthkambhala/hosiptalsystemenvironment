package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Appointment;

public class AppointmentDao {
	private Connection connection;

	public AppointmentDao(Connection connection) {
		super();
		this.connection = connection;
	}
	public boolean addAppointment(Appointment appoint) {
		boolean f = false;
		 String query = "insert into hospitalmanagementsystem.appointment ( userid, fullname, gender, age, appointment_date, email, phoneno, diaeases, doctorId, address, status) values(?,?,?,?,?,?,?,?,?,?,?)";
		 try {
			PreparedStatement ps = connection.prepareStatement(query);
		    ps.setInt(1, appoint.getUserId());
		    ps.setString(2, appoint.getFullName());
		    ps.setString(3, appoint.getGender());
		    ps.setString(4, appoint.getAge());
		    ps.setString(5, appoint.getAppointmentDate());
		    ps.setString(6, appoint.getEmail());
		    ps.setString(7, appoint.getPhoneNo());
		    ps.setString(8, appoint.getDiaeases());
		    ps.setInt(9, appoint.getDoctorId());
		    ps.setString(10, appoint.getAddress());
		    ps.setString(11, appoint.getStatus());
		    int i =   ps.executeUpdate();
		    if (i>0) {
		    	f=true;
				
			}
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
		
	}
	
    public List<Appointment> getAllAppointmentByLoginUser(int userId) {
		    List<Appointment> list = new ArrayList<Appointment>();
		    Appointment ap = null;
		    
		    String query = "select * from hospitalmanagementsystem.appointment where userid=?";
		    try {
				PreparedStatement ps = connection.prepareStatement(query);
				ps.setInt(1, userId);
				
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					ap = new Appointment();
					ap.setId(rs.getInt(1));
					ap.setUserId(rs.getInt(2));
					ap.setFullName(rs.getString(3));
					ap.setGender(rs.getString(4));
					ap.setAge(rs.getString(5));
					ap.setAppointmentDate(rs.getString(6));
					ap.setEmail(rs.getString(7));
					ap.setPhoneNo(rs.getString(8));
					ap.setDiaeases(rs.getString(9));
					ap.setDoctorId(rs.getInt(10));
					ap.setAddress(rs.getString(11));
					ap.setStatus(rs.getString(12));
					list.add(ap);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	return list;
		
	}
    public List<Appointment> getAllAppointByDoctorLogin(int doctId) {
    	List<Appointment> list = new ArrayList<Appointment>();
    	Appointment ap = null;
    	
    	 String query = "select * from hospitalmanagementsystem.appointment where doctorId=?";
		    try {
				PreparedStatement ps = connection.prepareStatement(query);
				ps.setInt(1, doctId);
				
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					ap = new Appointment();
					ap.setId(rs.getInt(1));
					ap.setUserId(rs.getInt(2));
					ap.setFullName(rs.getString(3));
					ap.setGender(rs.getString(4));
					ap.setAge(rs.getString(5));
					ap.setAppointmentDate(rs.getString(6));
					ap.setEmail(rs.getString(7));
					ap.setPhoneNo(rs.getString(8));
					ap.setDiaeases(rs.getString(9));
					ap.setDoctorId(rs.getInt(10));
					ap.setAddress(rs.getString(11));
					ap.setStatus(rs.getString(12));
					list.add(ap);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	
		return list;
		
	}
    
    public Appointment getAppointById(int id) {
    	
    	Appointment ap = null;
    	
    	 String query = "select * from hospitalmanagementsystem.appointment where  id=?";
		    try {
				PreparedStatement ps = connection.prepareStatement(query);
				ps.setInt(1, id);
				
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					ap = new Appointment();
					ap.setId(rs.getInt(1));
					ap.setUserId(rs.getInt(2));
					ap.setFullName(rs.getString(3));
					ap.setGender(rs.getString(4));
					ap.setAge(rs.getString(5));
					ap.setAppointmentDate(rs.getString(6));
					ap.setEmail(rs.getString(7));
					ap.setPhoneNo(rs.getString(8));
					ap.setDiaeases(rs.getString(9));
					ap.setDoctorId(rs.getInt(10));
					ap.setAddress(rs.getString(11));
					ap.setStatus(rs.getString(12));
					
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	
		return ap;
		
	}
    public boolean updateCommentStatus(int id,int doctId,String comm) {
    	boolean f = false;
    	 
    	String query = "update  hospitalmanagementsystem.appointment set status =? where id=? and doctorId=?";
    	try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, comm);
			ps.setInt(2, id);
			ps.setInt(3, doctId);
			int i = ps.executeUpdate();
			if (i>0) {
				f = true;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
		
	}
    public List<Appointment> getAllAppoint() {
    	List<Appointment> list = new ArrayList<Appointment>();
    	Appointment ap = null;
    	
    	 String query = "select * from hospitalmanagementsystem.appointment order by id desc";
		    try {
				PreparedStatement ps = connection.prepareStatement(query);
			
				
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					ap = new Appointment();
					ap.setId(rs.getInt(1));
					ap.setUserId(rs.getInt(2));
					ap.setFullName(rs.getString(3));
					ap.setGender(rs.getString(4));
					ap.setAge(rs.getString(5));
					ap.setAppointmentDate(rs.getString(6));
					ap.setEmail(rs.getString(7));
					ap.setPhoneNo(rs.getString(8));
					ap.setDiaeases(rs.getString(9));
					ap.setDoctorId(rs.getInt(10));
					ap.setAddress(rs.getString(11));
					ap.setStatus(rs.getString(12));
					list.add(ap);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	
		return list;
		
   }
}
