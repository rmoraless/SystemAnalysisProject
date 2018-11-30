package membership;

import database.MembershipDBController;
import interfaces.I_Membership;

public class Membership implements I_Membership {

	private int points;
    
    public Membership(){
        
    }
   
    public int getPoints() {
        return points;
    }
    
    public void setPoints(int points) {
        this.points = points;
        
    }
    
    @Override
    public void addPoints(int points, int userID) throws Exception{
        this.points += points;
        System.out.println();
        MembershipDBController db = new MembershipDBController();
        db.addMembershipPoints(userID, this.points);
    }
    
    @Override
    public void subtractPoints(int points, int userID) throws Exception{
        this.points -= points;
        MembershipDBController db = new MembershipDBController();
        db.substractMembershipPoints(userID, this.points);
    }
    
}
