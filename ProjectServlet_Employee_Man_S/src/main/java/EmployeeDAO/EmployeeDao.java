package EmployeeDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import EmployeeBO.EmployeeBo;

public class EmployeeDao {
	public static Connection getConnection() {
		Connection con=null;
		
		try {
			//Class.forName("com.mysql.cj.jdbc.Driver");
			
			//con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagementsystem?useSSL=false&allowPublicKeyRetrival=true","root","Pass@123");
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagementsystem?useSSL=false&allowPublicKeyRetrival=true","root","Pass@123");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
				
	}
	
	public static int insert(EmployeeBo em) {
		int result=0;
		try {
			Connection con= EmployeeDao.getConnection();
			
			String sql="insert into emp (name,email,password,country,city) values(?,?,?,?,?)";
			
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, em.getName());
			ps.setString(2, em.getEmail());
			ps.setString(3, em.getPassword());
			ps.setString(4, em.getCountry());
			ps.setString(5, em.getCity());
			
			result=ps.executeUpdate();
			con.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}


	public static List<EmployeeBo> DataFetch() {
		List<EmployeeBo> al=new ArrayList<EmployeeBo>();
		
		try {
            Connection con= EmployeeDao.getConnection();
			
			String sql="select * from emp";
			
			PreparedStatement ps=con.prepareStatement(sql);
			
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				EmployeeBo em =new EmployeeBo();
				em.setId(rs.getInt(1));
				em.setName(rs.getString(2));
				em.setEmail(rs.getString(3));
				em.setPassword(rs.getString(4));
				em.setCountry(rs.getString(5));
				em.setCity(rs.getString(6));
				al.add(em);
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return al;
	}
	
	public static int Delete(int id) {
		int result=0;
		try {
			Connection con=EmployeeDao.getConnection();
			String sql="delete from emp where id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			
			result=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static EmployeeBo search( int id) {
		EmployeeBo ob=new EmployeeBo();
		Connection con=EmployeeDao.getConnection();
		String sql="select * from emp where id=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
			ob.setId(rs.getInt(1));
		    ob.setName(rs.getString(2));
			ob.setEmail(rs.getString(3));
		    ob.setPassword(rs.getString(4));
			ob.setCountry(rs.getString(5));
			ob.setCity(rs.getString(6));
			}
			
			
		} catch (Exception ee) {
			ee.printStackTrace();
		}
		 
		
		return ob;
	}
	public static int update(EmployeeBo em) {
		int result=0;
		Connection con=EmployeeDao.getConnection();
		String sql="update emp set name=?,email=?,password=?,country=?,city=? where id=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, em.getName());
			ps.setString(2, em.getEmail());
			ps.setString(3, em.getPassword());
			ps.setString(4, em.getCountry());
			ps.setString(5, em.getCity());
			ps.setInt(6, em.getId());
			
			result=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
	public static boolean search1( String password,String email) {
		
		Connection con=EmployeeDao.getConnection();
		String sql="select * from emp where password=? and email=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, password);
			ps.setString(2, email);
			 ResultSet rs=ps.executeQuery();
			 return rs.next();
			
		} catch (Exception ee) {
			ee.printStackTrace();
			return false;
		}	
	}
	
	public static List<EmployeeBo> searchdata(int id) {
		List<EmployeeBo> ob=new ArrayList<EmployeeBo>();
		 try {
			 Connection con=EmployeeDao.getConnection();
			  
			 String sql="select *  from emp where id=?";
			 
			 PreparedStatement ps=con.prepareStatement(sql);
			 ps.setInt(1, id);
			 
			 ResultSet rs=ps.executeQuery();
			 
			 while (rs.next()) {
				 EmployeeBo o=new EmployeeBo();
				 
				 o.setId(rs.getInt(1));
				 o.setName(rs.getString(2));				 
				 o.setEmail(rs.getString(3));				 
				 o.setPassword(rs.getString(4));
				 o.setCountry(rs.getString(5));
				 o.setCity(rs.getString(6));
				 ob.add(o);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		 return ob;
	}
}
