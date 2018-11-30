package database;

import membership.*;
import users.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MembershipDBController {
	
	private Connection connect = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	private int update;
	
	public MembershipDBController() { 
		
	}
	
	public Membership getMembership(Customer userID) throws SQLException, Exception{

		DatabaseManager db;
		db = DatabaseManager.getInstance();
		db.connectDB();
		this.connect = db.returnConnection();
		
		Membership membership = new Membership();
		int points = 0;

		preparedStatement = connect
				.prepareStatement("SELECT points FROM abcs.membership WHERE user_id = ?;");
		preparedStatement.setInt(1, userID.getUserID());
		resultSet = preparedStatement.executeQuery();

		while(resultSet.next()){
			points = resultSet.getInt("points");
		}

		db.close();
		
		membership.setPoints(points);
		return membership;
	}

	public void addMembershipPoints(int userID, int points) throws SQLException, Exception{

		DatabaseManager db;
		db = DatabaseManager.getInstance();
		db.connectDB();
		this.connect = db.returnConnection();

		preparedStatement = connect
				.prepareStatement("UPDATE abcs.membership SET points = ? WHERE user_id = ?;");
		preparedStatement.setInt(1, points);
		preparedStatement.setInt(2, userID);
		update = preparedStatement.executeUpdate();
		
		db.close();
	}
	
	public void substractMembershipPoints(int userID, int points) throws SQLException, Exception{

		DatabaseManager db;
		db = DatabaseManager.getInstance();
		db.connectDB();
		this.connect = db.returnConnection();

		preparedStatement = connect
				.prepareStatement("UPDATE abcs.membership SET points = ? WHERE user_id = ?;");
		preparedStatement.setInt(1, points);
		preparedStatement.setInt(2, userID);
		update = preparedStatement.executeUpdate();

		db.close();
	}

}
