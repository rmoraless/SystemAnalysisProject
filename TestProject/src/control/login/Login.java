package control.login;

import ui.LoginMenu;
import database.*;
import interfaces.I_Login;
import interfaces.I_User;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import control.data.UserManager;

public class Login implements I_Login {

	@Override
	public boolean login(String username, String password) throws Exception {
		
		Validation val = new Validation();
		LoginDBController loginCheck = new LoginDBController();
		I_User userManager = new UserManager();
		
		boolean loginSucc = false;
		boolean ValidEmail = false;
		boolean ValidPass = false;

		System.out.println(password);
		try {
			ValidEmail = val.emailCheck(username);
			ValidPass = val.passCheck(password);
			loginSucc = loginCheck.loginCheck(username, password);
		} catch (Exception ex) {
			Logger.getLogger(LoginMenu.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		if (!ValidEmail) {
			JOptionPane optionPane = new JOptionPane("Email is not Valid", JOptionPane.ERROR_MESSAGE);
			JDialog dialog = optionPane.createDialog("Failure");
			dialog.setAlwaysOnTop(true);
			dialog.setVisible(true);
		}
		
		if (!ValidPass) {
			JOptionPane optionPane = new JOptionPane("Password is not Valid", JOptionPane.ERROR_MESSAGE);
			JDialog dialog = optionPane.createDialog("Failure");
			dialog.setAlwaysOnTop(true);
			dialog.setVisible(true);
		}
		
		if (ValidEmail && ValidPass) {
			if (loginSucc) {
				userManager.createUser(username, password);
				return true;
			}
		}
		return false;
	}

}
