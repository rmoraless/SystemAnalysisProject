package users;

public abstract class User {

	protected int userID;
    protected String email;
    protected String password;
    protected int role;
    protected User_details details;
    
    public User() {
    	
    }
    
	public User(int userID, String email, String password, int role, User_details details) {
		
		this.userID = userID;
		this.email = email;
		this.password = password;
		this.role = role;
		this.details = details;
		
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public User_details getDetails() {
		return details;
	}

	public void setDetails(User_details details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", email=" + email + ", password=" + password + ", role=" + role +""+ getDetails() + "]";
	}
	
}
