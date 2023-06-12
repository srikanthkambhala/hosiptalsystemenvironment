package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.entity.User;

public class UserDao {
	private Connection connection;

	public UserDao(Connection connection) {
		
		this.connection = connection;
	}
	
	public boolean register(User u) {
		
		boolean f = false;
		
		String query = "insert into hospitalmanagementsystem.userdetails(fullname,email,password) values(?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setString(1,u.getFname() );
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getPassword());
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
	public User login(String email,String password) {
		User u = null;
		String query = "select * from hospitalmanagementsystem.userdetails where email=? and password=?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				u = new User();
				
				u.setId(rs.getInt("id"));
				u.setFname(rs.getString("fullname"));
				u.setEmail(rs.getString("email"));
				u.setPassword(rs.getString("password"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return u;
		
	}
	public boolean checkOldPassword(int userId,String oldPassword) {
		boolean f = false;
		String query = "select * from hospitalmanagementsystem.userdetails where id=? and password=?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, userId);
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
	public boolean changePassword(int userId,String newPassword) {
		boolean f = false;
		
		String sql = "update hospitalmanagementsystem.userdetails set password =? where id=? ";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, newPassword);
			ps.setInt(2, userId);
			
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
