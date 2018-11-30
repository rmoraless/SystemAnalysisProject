package users;

import membership.*;

public class Customer extends User {

	private Membership membership;
	
	public Customer() {
		super();
	}

	public Customer(int userID, String email, String password, int role, User_details details) {
		
		super(userID, email, password, role, details);
		
	}
	
	public void createMembership(Membership membership) {
        this.membership = membership;
    }
	  
	public Membership getMembership(){
        return this.membership;
    }

	@Override
	public String toString() {
		return "Customer [membership=" + membership.getPoints() + "]";
	}

}

