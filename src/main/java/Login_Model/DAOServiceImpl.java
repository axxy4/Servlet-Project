package Login_Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAOServiceImpl implements DAOService {
	Connection con;
	Statement stmnt;
		
	@Override
	public void connectDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/manav","root","Manav@123");
		stmnt = con.createStatement();
	}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean verifyCredentials(String email, String password) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			ResultSet result = stmnt.executeQuery("Select * from m1 where email = '"+email+"' and password='"+password+"'");
			return result.next();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void saveregistration(String name, String city, String email, String mobile) {
		try {
			stmnt.executeUpdate("insert into m2 values('"+name+"','"+city+"','"+email+"','"+mobile+"')");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ResultSet listAllRegistrations() {
		try {
			ResultSet result = stmnt.executeQuery("select * from m2");
			return result;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void DeleteReg(String email) {
		try {
			stmnt.executeUpdate("Delete from m2 where email='"+email+"'");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void UpdateReg(String email, String mobile) {
		try {
			stmnt.executeUpdate("Update m2 SET mobile='"+mobile+"' WHERE email='"+email+"'");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
