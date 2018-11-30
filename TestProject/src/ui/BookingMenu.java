package ui;

import booking.Booking;
import control.data.BookingManager;
import control.data.FlightManager;
import flight.Flight;
import interfaces.I_Booking;
import interfaces.I_Flight;
import users.Customer;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author alialdobyan
 */
public class BookingMenu extends javax.swing.JFrame {

	private Customer cust;
	private ArrayList<Flight> flightList;
	private int selectedFlight;

	public BookingMenu(Customer cust, ArrayList<Flight> flightList, int selectedRow) throws Exception {
		this.cust = cust;
		this.flightList = flightList;
		this.selectedFlight = selectedRow;
		initComponents();
	}

	private void initComponents() throws Exception {

		jButton1 = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jComboBox_class = new javax.swing.JComboBox<>();
		jComboBox_baggage = new javax.swing.JComboBox<>();
		jButton_calculatePrice = new javax.swing.JButton();
		jButton_book = new javax.swing.JButton();
		jLabel_FlightNumber = new javax.swing.JLabel();
		jLabel_totalPrice = new javax.swing.JLabel();
		jButton_cancel = new javax.swing.JButton();

		jButton1.setText("jButton1");

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setBounds(new java.awt.Rectangle(600, 300, 0, 0));

		jLabel1.setText("Flight Number:");

		jLabel2.setText("Class:");

		jLabel3.setText("Baggage:");

		jLabel4.setText("Total Price:");

		jLabel_FlightNumber.setText(String.valueOf(flightList.get(selectedFlight).getFlightID()) + " (" + 
				String.valueOf(flightList.get(selectedFlight).getDepartureAirport()) + " - " +
				String.valueOf(flightList.get(selectedFlight).getArrivalAirport() + ") "));

		jComboBox_class.setModel(new javax.swing.DefaultComboBoxModel<>(
				new String[] { "First Class", "Business Class", "Economy Class" }));
		jComboBox_class.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jComboBox_classActionPerformed(evt);
			}
		});

		setBaggageNumber();
		jComboBox_baggage.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jComboBox_baggageActionPerformed(evt);
			}
		});

		jButton_calculatePrice.setText("Calculate Price");
		jButton_calculatePrice.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton_calculatePriceActionPerformed(evt);
			}
		});

		jButton_book.setText("Book");
		jButton_book.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					jButton_bookActionPerformed(evt);
				} catch (Exception ex) {
					Logger.getLogger(BookingMenu.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		});

		jLabel_totalPrice.setText("0.0");

		jButton_cancel.setText("Cancel");
		jButton_cancel.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton_cancelActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jButton_calculatePrice).addGap(77, 77, 77))
				.addGroup(layout.createSequentialGroup().addGap(45, 45, 45).addGroup(layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel1)
						.addComponent(jLabel2).addComponent(jLabel3).addComponent(jLabel4))
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
								.createSequentialGroup()
								.addGroup(layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
												.createSequentialGroup()
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(jLabel_FlightNumber,
														javax.swing.GroupLayout.PREFERRED_SIZE, 107,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(layout.createSequentialGroup().addGap(105, 105, 105).addGroup(layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addComponent(jComboBox_class, 0, 173, Short.MAX_VALUE)
												.addComponent(jComboBox_baggage, 0,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
								.addContainerGap(53, Short.MAX_VALUE))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jLabel_totalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 68,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(97, 97, 97))))
				.addGroup(layout.createSequentialGroup().addGap(37, 37, 37).addComponent(jButton_cancel)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jButton_book).addGap(39, 39, 39)));
		
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addGap(46, 46, 46)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel1)
						.addComponent(jLabel_FlightNumber))
				.addGap(44, 44, 44)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel2)
						.addComponent(jComboBox_class, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(31, 31, 31)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel3)
						.addComponent(jComboBox_baggage, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(53, 53, 53)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel4)
						.addComponent(jLabel_totalPrice))
				.addGap(18, 18, 18).addComponent(jButton_calculatePrice)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(jButton_book).addComponent(jButton_cancel))
				.addGap(14, 14, 14)));

		pack();
	}

	private void jComboBox_classActionPerformed(java.awt.event.ActionEvent evt) {
		
	}

	private void jComboBox_baggageActionPerformed(java.awt.event.ActionEvent evt) {

	}

	/**
	 * 
	 * @param evt
	 */
	private void jButton_calculatePriceActionPerformed(java.awt.event.ActionEvent evt) {
		
		int number = flightList.get(selectedFlight).getFlightID();
		String className = String.valueOf(jComboBox_class.getSelectedItem());

		I_Flight flightManager = new FlightManager();
		Flight f = null;
		try {
			f = flightManager.createFlight(number);
		} catch (Exception ex) {
			Logger.getLogger(BookingMenu.class.getName()).log(Level.SEVERE, null, ex);
		}

		if (className.equals("First Class")) {
			jLabel_totalPrice.setText(String.valueOf(f.getFlightPrice().getFirstPrice()));
		}

		else if (className.equals("Business Class")) {
			jLabel_totalPrice.setText(String.valueOf(f.getFlightPrice().getBusinessPrice()));
		}

		else {
			jLabel_totalPrice.setText(String.valueOf(f.getFlightPrice().getEconomicPrice()));
		}

	}

	/**
	 * 
	 * @param evt
	 * @throws Exception
	 */
	private void jButton_bookActionPerformed(java.awt.event.ActionEvent evt) throws Exception {// GEN-FIRST:event_jButton_bookActionPerformed
		
		I_Booking bookingManager = new BookingManager();
		I_Flight flightManager = new FlightManager();

		Flight flight = flightList.get(selectedFlight);

		String className = String.valueOf(jComboBox_class.getSelectedItem());

		System.out.println(flightManager.checkAvaliability(flight, className));
		
		int baggage = Integer.parseInt(String.valueOf(jComboBox_baggage.getSelectedItem()));
		
		if(flightManager.checkAvaliability(flight, className))
			{ displayMessage(); }

		else{
			Booking b = bookingManager.makeBooking(cust, flight, baggage, className);
			MembershipMenu m = new MembershipMenu(cust, b);
			this.setVisible(false);
			m.setVisible(true);
		}
	}

	/**
	 * Cancels the booking and goes back to the FlightsList window
	 * @param evt
	 */
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

	/**
	 * Sets number of baggage of the airplane in the Baggage ComboBox
	 * @throws Exception
	 */
	public void setBaggageNumber() throws Exception {

		int baggageSize = this.flightList.get(selectedFlight).getAirplane().getBaggage();

		String[] baggageArray = new String[baggageSize];
		for (int x = 0; x < baggageArray.length; x++)
			baggageArray[x] = Integer.toString((x + 1));

		jComboBox_baggage.setModel(new javax.swing.DefaultComboBoxModel<>(baggageArray));

	}
	
	/**
	 * Displays a message when there are no seats available
	 */
	public void displayMessage() {
		
		JOptionPane optionPane = new JOptionPane("There is no seats left in this class, choose another one or change your flight", JOptionPane.INFORMATION_MESSAGE);
		JDialog dialog = optionPane.createDialog("Sorry");
		dialog.setAlwaysOnTop(true);
		dialog.setVisible(true);
		
	}

	/**
	 * @param args
	 *            the command line arguments
	 */

	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton_book;
	private javax.swing.JButton jButton_calculatePrice;
	private javax.swing.JButton jButton_cancel;
	private javax.swing.JComboBox<String> jComboBox_baggage;
	private javax.swing.JComboBox<String> jComboBox_class;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel_FlightNumber;
	private javax.swing.JLabel jLabel_totalPrice;
	// End of variables declaration
}
