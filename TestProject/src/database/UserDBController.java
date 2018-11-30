package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import users.Customer;
import users.User_details;

public class UserDBController {
	
	private Connection connect = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	public UserDBController() {
		
	}
	
	public int getRole(String email, String password) throws SQLException, Exception{
	
		DatabaseManager db;
		db = DatabaseManager.getInstance();
		db.connectDB();
		this.connect = db.returnConnection();
		
		int role = 0;

		preparedStatement = connect
				.prepareStatement("SELECT role_id FROM abcs.user WHERE email = ? AND password = ?;");
		preparedStatement.setString(1, email);
		preparedStatement.setString(2, password);
		resultSet = preparedStatement.executeQuery();

		while(resultSet.next()){
			role = resultSet.getInt("role_id");
		}
		
		db.close();

		System.out.println(role);

		return role;
	}

	public void createUser(Customer user, String email, String password) throws Exception{

		DatabaseManager db;
		db = DatabaseManager.getInstance();
		db.connectDB();
		this.connect = db.returnConnection();

		int role = 0;
		int userID = 0;
		String userEmail = "";
		String  pass = "";
		User_details details = new User_details();

		preparedStatement = connect
				.prepareStatement("SELECT * FROM abcs.user WHERE email = ? AND password = ?;");
		preparedStatement.setString(1, email);
		preparedStatement.setString(2, password);
		resultSet = preparedStatement.executeQuery();

		while(resultSet.next()){
			userID = resultSet.getInt("user_id");
			userEmail = resultSet.getString("email");
			pass = resultSet.getString("password");
			role = resultSet.getInt("role_id");
		}
		
		preparedStatement = connect
				.prepareStatement("SELECT * FROM abcs.user_details WHERE user_id = ?;");
		preparedStatement.setInt(1, userID);
		resultSet = preparedStatement.executeQuery();

		while(resultSet.next()){
			details.setFirstName(resultSet.getString("first_name"));
			details.setLastName(resultSet.getString("last_name"));
			details.setDateOfBirth(resultSet.getString("dob"));
			details.setGender(resultSet.getInt("sex"));
			details.setContactNumber(resultSet.getString("contact_number"));
		}
		
		db.close();

		user.setUserID(userID);
		user.setEmail(userEmail);
		user.setPassword(pass);
		user.setRole(role);
		user.setDetails(details);

	}

}
