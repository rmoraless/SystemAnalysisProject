package control.login;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author Xgold
 */
public class Validation  {
    
    public boolean emailCheck(String email){
        boolean valid = true;
        if (email != null){
            String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
            "[a-zA-Z0-9_+&*-]+)*@" + 
            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
            "A-Z]{2,7}$"; 
                              
            Pattern pattern = Pattern.compile(emailRegex);
            Matcher matcher = pattern.matcher(email);
            if(!matcher.matches()){
                valid = false;
            }
        }
        else{
            valid = false;
        }
        return valid; 
    } 
        
    public boolean passCheck(String password){
        boolean valid = true;
        
        if(password.length() < 8){
            valid = false;
        }
        String upperCase = "(.*[A-Z].*)";
        if(!password.matches(upperCase)){
            valid = false;
        }
        String lowerCase = "(.*[a-z].*)";
        if(!password.matches(lowerCase)){
            valid = false;
        }
        String numbers = "(.*[0-9].*)";
        if(!password.matches(numbers)){
            valid = false;
        }
            
        return valid;
        
    }
    public boolean nameCheck(String name){
      boolean valid = true;
 
      Pattern pattern = Pattern.compile("[a-zA-Z]*");

      Matcher matcher = pattern.matcher(name);
 
      if (!matcher.matches()) {
           valid = false;
      }
      
      return valid;
    }

    public boolean dobCheck(){
        return false;
    }
    public boolean sexCheck(){
        return false;
        
    }
    public boolean contactCheck(String number){
      boolean valid = true;
 
      //Pattern pattern = Pattern.compile("[0-9]*");
       Pattern pattern = Pattern.compile("^08[35679]\\d{7}$");

      Matcher matcher = pattern.matcher(number);
 
      if (!matcher.matches()) {
           valid = false;
      }
       
      return valid;
    }
    
}