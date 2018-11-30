package ui;

import interfaces.I_User;
import users.Customer;
import control.data.UserManager;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alialdobyan
 */
public class UserMenu extends javax.swing.JFrame {

	private Customer user;

	public UserMenu(Customer user) {
		initComponents();
		this.user = user;
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jButton_Booking = new javax.swing.JButton();
		jButton_CancelBooking = new javax.swing.JButton();
		jButton_ViewFlights = new javax.swing.JButton();
		jButton_Logout = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setLocation(new java.awt.Point(600, 300));

		jButton_Booking.setText("Make Booking");
		jButton_Booking.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					jButton_BookingActionPerformed(evt);
				} catch (Exception ex) {
					Logger.getLogger(UserMenu.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		});

		jButton_CancelBooking.setText("Cancel Booking");
		jButton_CancelBooking.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton_CancelBookingActionPerformed(evt);
			}
		});

		jButton_ViewFlights.setText("View Flights");
		jButton_ViewFlights.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton_ViewFlightsActionPerformed(evt);
			}
		});

		jButton_Logout.setText("Logout");
		jButton_Logout.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton_LogoutActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addContainerGap(95, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jButton_Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 312,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jButton_ViewFlights, javax.swing.GroupLayout.PREFERRED_SIZE, 312,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jButton_CancelBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 312,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jButton_Booking, javax.swing.GroupLayout.PREFERRED_SIZE, 312,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(93, 93, 93)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(45, 45, 45)
						.addComponent(jButton_Booking, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(49, 49, 49)
						.addComponent(jButton_CancelBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
						.addComponent(jButton_ViewFlights, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(44, 44, 44).addComponent(jButton_Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(50, 50, 50)));

		pack();
	}// </editor-fold>

	private void jButton_BookingActionPerformed(java.awt.event.ActionEvent evt) throws Exception {
		// TODO add your handling code here:
		this.setVisible(false);
		FlightBookingMenu menu;
        try {
            menu = new FlightBookingMenu(user);
            menu.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
	}

	private void jButton_CancelBookingActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jButton_ViewFlightsActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		I_User userManager = new UserManager();
		try {
			userManager.viewFlights();
		} catch (Exception ex) {
			Logger.getLogger(UserMenu.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	private void jButton_LogoutActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	/**
	 * @param args
	 *            the command line arguments
	 */

	// Variables declaration - do not modify
	private javax.swing.JButton jButton_Booking;
	private javax.swing.JButton jButton_CancelBooking;
	private javax.swing.JButton jButton_Logout;
	private javax.swing.JButton jButton_ViewFlights;
	// End of variables declaration
}
