package DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Connection.ConnectionManager;

import Model.Staffs;


public class StaffDAO {
	
	private static Connection con = null;
	private static PreparedStatement ps = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	private static String sql;
	private int staff_id;
	private String staff_name;
	private String staff_email;
	private String staff_password;
	private String staff_address;
	private String staff_phoneno;
	private String staff_icno;
	
	//get a staff
	public static Staffs getStaff(int staff_id) { 
		Staffs staff = new Staffs();
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();

			//create statement
			ps=con.prepareStatement("select * from staff where staff_id=?");
			ps.setInt(1, staff_id); 


			//execute query
			rs = ps.executeQuery();

			if (rs.next()) {	
				
				staff.setStaff_id(rs.getInt("staff_id"));	
				staff.setStaff_name(rs.getString("staff_name"));
				staff.setStaff_email(rs.getString("staff_email"));
				staff.setStaff_password(rs.getString("staff_password"));
				staff.setStaff_address(rs.getString("staff_address"));
				staff.setStaff_phoneno(rs.getString("staff_phoneno"));
				staff.setStaff_icno(rs.getString("staff_icno"));
				
			}
			//close connection
			con.close();
			

			} catch (Exception e) {
				e.printStackTrace();
			}
			return staff; 
	}
	
	//add staff
	public void addStaff(Staffs bean) {
		
		//get values
		
		staff_id = bean.getStaff_id();
		staff_name = bean.getStaff_name();
		staff_email= bean.getStaff_email();
		staff_password = bean.getStaff_password();
		staff_address = bean.getStaff_address();
		staff_phoneno = bean.getStaff_phoneno();
		staff_icno = bean.getStaff_icno();
		

		try {			
			//call getConnection() method
			con = ConnectionManager.getConnection();

			//create statement
			ps=con.prepareStatement("insert into staff(staff_name,staff_email,staff_password,staff_address,staff_phoneno,staff_icno)values(?,?,?,?,?,?)");
			ps.setString(1, staff_name);
			ps.setString(2, staff_email);
			ps.setString(3, staff_password);
			ps.setString(4, staff_address);
			ps.setString(5, staff_phoneno);
			ps.setString(6, staff_icno);
			

			//execute query
			ps.executeUpdate();

			//close connection
			con.close();
		

		}catch(Exception e) {
			e.printStackTrace();				
		}
	}
	
	//Complete deleteStaff() method
		public void deleteStaff(int staff_id) {
			try {
				//call getConnection() method 
				con = ConnectionManager.getConnection();

	           //create statement
				ps = con.prepareStatement("DELETE FROM staff WHERE staff_id=?");
				ps.setInt(1, staff_id);

	           //execute query
				ps.executeUpdate();
				
	           //close connection
				con.close();


	           }catch(Exception e) {
				e.printStackTrace();
			}
		}
	
	//get all staff
	public static List<Staffs> getStaffs() { 
		List<Staffs> staffs = new ArrayList<Staffs>(); 
		try { 
			//call getConnection() method
			con = ConnectionManager.getConnection();

            //create statement
			stmt = con.createStatement();
			String sql = "SELECT * FROM staff ORDER BY staff_id";

		 //execute query
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {		//process result
				Staffs staff = new Staffs();
				
				staff.setStaff_id(rs.getInt("staff_id"));	
				staff.setStaff_name(rs.getString("staff_name"));
				staff.setStaff_email(rs.getString("staff_email"));
				staff.setStaff_password(rs.getString("staff_password"));
				staff.setStaff_address(rs.getString("staff_address"));
				staff.setStaff_phoneno(rs.getString("staff_phoneno"));
				staff.setStaff_icno(rs.getString("staff_icno"));
				staffs.add(staff);
			}
			
           //close connection
			con.close();
			

		} catch (Exception e) { 
			e.printStackTrace(); 
		}

		return staffs; 
	}

}
