package ui;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import booking.Booking;
import control.data.BookingManager;
import control.data.FlightManager;
import interfaces.I_Booking;
import interfaces.I_Flight;
import interfaces.I_Membership;
import users.Customer;

public class MembershipMenu extends javax.swing.JFrame {
	
	private Customer cust;
	private Booking booking;
	
	public MembershipMenu(Customer cust, Booking booking) throws Exception {
		super();
		this.cust = cust;
		this.booking = booking;
		initComponents();
	}
	
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() throws Exception {
		
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel_yourPoints = new javax.swing.JLabel();
		jLabel_bookPoints = new javax.swing.JLabel();
		jLabel_discount = new javax.swing.JLabel();
		jButton_discount = new javax.swing.JButton();
		jButton_points = new javax.swing.JButton();
		jButton_cancel = new javax.swing.JButton();
		
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setBounds(new java.awt.Rectangle(600, 300, 0, 0));

		jLabel1.setText("Your points:");

		jLabel2.setText("Earn:");
		
		jLabel3.setText("Or new price:");
		
		jLabel_yourPoints.setText(String.valueOf(cust.getMembership().getPoints()));
		jLabel_bookPoints.setText(String.valueOf(calculatePoints(booking)));
		jLabel_discount.setText(String.valueOf(calculateDiscount(cust, booking)));
		
		jButton_discount.setText("Discount");
		jButton_discount.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					jButton_discountActionPerformed(evt);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		jButton_points.setText("Points");
		jButton_points.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					jButton_pointsActionPerformed(evt);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		jButton_cancel.setText("Cancel");
		jButton_cancel.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton_cancelActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addGap(45, 45, 45)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel1)
						.addComponent(jLabel2).addComponent(jLabel3))
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
						.createSequentialGroup()
						.addGroup(layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
										.createSequentialGroup()
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jLabel_yourPoints)
												.addComponent(jLabel_bookPoints)
												.addComponent(jLabel_discount))))))
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
						.createSequentialGroup()
						.addGap(39, 39, 39)
						.addComponent(jButton_cancel)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jButton_points)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jButton_discount)
						.addGap(39, 39, 39)))));
		
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addGap(46, 46, 46)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel1)
						.addComponent(jLabel_yourPoints))
				.addGap(44, 44, 44)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel2)
						.addComponent(jLabel_bookPoints, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(44, 44, 44)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel3)
						.addComponent(jLabel_discount, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(jButton_cancel).addComponent(jButton_points).addComponent(jButton_discount))
				.addGap(14, 14, 14)));

		pack();
				
	}
	
	private void jButton_discountActionPerformed(java.awt.event.ActionEvent evt) throws Exception {
		
		float discount = Float.parseFloat(String.valueOf( jLabel_discount.getText()));
		I_Flight flightManager = new FlightManager();
		
		I_Booking bookingManager = new BookingManager();
		bookingManager.changePrice(booking, discount);
		
		I_Membership membership = cust.getMembership();
		membership.subtractPoints(cust.getMembership().getPoints(), cust.getUserID());
		
		try {
			bookingManager.insertBooking(booking);
			flightManager.decreaseSeats(booking.getFlight(), booking.getClassType());
		} catch (Exception ex) {
			Logger.getLogger(BookingMenu.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		displayMessage();
		
		this.setVisible(false);
		
	}
	
	private void jButton_pointsActionPerformed(java.awt.event.ActionEvent evt) throws Exception {
		
		int points = Integer.parseInt(String.valueOf(jLabel_bookPoints.getText()));
		I_Flight flightManager = new FlightManager();
		I_Booking bookingManager = new BookingManager();
		
		I_Membership membership = cust.getMembership();
		membership.addPoints(points, cust.getUserID());
		
		try {
			bookingManager.insertBooking(booking);
			flightManager.decreaseSeats(booking.getFlight(), booking.getClassType());
		} catch (Exception ex) {
			Logger.getLogger(BookingMenu.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		displayMessage();
		
		this.setVisible(false);
		
	}
	
	private void jButton_cancelActionPerformed(java.awt.event.ActionEvent evt) {
		this.dispose();
		FlightBookingMenu flightsList = null;
		try {
			flightsList = new FlightBookingMenu(cust);
		} catch (Exception ex) {
			Logger.getLogger(BookingMenu.class.getName()).log(Level.SEVERE, null, ex);
		}
		flightsList.setVisible(true);
	}
	
	public int calculatePoints(Booking booking) {
		
		int price = (int)(0.15*booking.getPrice());
		return price;
		
	}
	
	public float calculateDiscount(Customer customer, Booking booking) {
		
		int points = customer.getMembership().getPoints();
		float price = (float) (booking.getPrice() - 0.15*points);
		
		return price;
		
	}
	
	public void displayMessage() {
		
		JOptionPane optionPane = new JOptionPane("Your purchase it's been completed", JOptionPane.INFORMATION_MESSAGE);
		JDialog dialog = optionPane.createDialog("Thanks");
		dialog.setAlwaysOnTop(true);
		dialog.setVisible(true);
		
		UserMenu u = new UserMenu(cust);
		u.setVisible(true);
		
	}
	
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel_yourPoints;
	private javax.swing.JLabel jLabel_bookPoints;
	private javax.swing.JLabel jLabel_discount;
	private javax.swing.JButton jButton_discount;
	private javax.swing.JButton jButton_points;
	private javax.swing.JButton jButton_cancel;

}
