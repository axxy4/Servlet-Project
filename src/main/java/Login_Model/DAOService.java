package Login_Model;

import java.sql.ResultSet;

public interface DAOService {
	public void connectDB();
	public boolean verifyCredentials(String email,String password);
	public void saveregistration(String name,String city,String email,String mobile);
	public ResultSet listAllRegistrations();
	public void DeleteReg(String email);
	public void UpdateReg(String email, String mobile);
}
