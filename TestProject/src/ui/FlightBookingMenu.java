package ui;

import flight.Flight;
import interfaces.I_Flight;
import users.Customer;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import control.data.FlightManager;

public class FlightBookingMenu extends javax.swing.JFrame {

	private Customer cust;
	private ArrayList<Flight> flightList;

	public FlightBookingMenu(Customer cust) throws Exception {
		initComponents();
		this.cust = cust;
		displayFlights();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jScrollPane1 = new javax.swing.JScrollPane();
		jTable_Flights = new javax.swing.JTable();
		jButton_continue = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setBounds(new java.awt.Rectangle(400, 300, 0, 0));

		jTable_Flights.setModel(new javax.swing.table.DefaultTableModel(

				new Object[][] {}, 
				
				new String[] { "Flight number", "Departure Time" , "Departure Date",
						"Departure Airport", "Arrival Time", "Arrival Date", "Arrival airport" }) {
			
				boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		
		jTable_Flights.setLocation(new java.awt.Point(500, 300));
		jScrollPane1.setViewportView(jTable_Flights);

		jButton_continue.setText("Continue");
		jButton_continue.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton_continueActionPerformed(evt);
			}
		});

		jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
		jLabel1.setForeground(new java.awt.Color(51, 51, 255));
		jLabel1.setText("Select a flight to Book");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 811, Short.MAX_VALUE)
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
												.addComponent(jButton_continue)))
						.addContainerGap())
				.addGroup(layout.createSequentialGroup().addGap(314, 314, 314).addComponent(jLabel1)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap(20, Short.MAX_VALUE).addComponent(jLabel1)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jButton_continue).addContainerGap()));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void jButton_continueActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton_continueActionPerformed

		if (jTable_Flights.getSelectedRow() == -1) {
			JOptionPane optionPane = new JOptionPane("Please select one of the Flights you want to Book!",
					JOptionPane.ERROR_MESSAGE);
			JDialog dialog = optionPane.createDialog("Failure");
			dialog.setAlwaysOnTop(true);
			dialog.setVisible(true);
			
		} else if (jTable_Flights.getSelectedRowCount() > 1) {
			JOptionPane optionPane = new JOptionPane("Please select only one Flight!", JOptionPane.ERROR_MESSAGE);
			JDialog dialog = optionPane.createDialog("Failure");
			dialog.setAlwaysOnTop(true);
			dialog.setVisible(true);
			
		} else {
			try {
				int selectedRow = jTable_Flights.getSelectedRow();

				this.setVisible(false);
				BookingMenu flightBooking = new BookingMenu(cust, flightList, selectedRow);
				flightBooking.setVisible(true);

			} catch (Exception ex) {
				Logger.getLogger(FlightBookingMenu.class.getName()).log(Level.SEVERE, null, ex);
			}

		}
	}// GEN-LAST:event_jButton_continueActionPerformed

	private void displayFlights() throws Exception {
		
		DefaultTableModel model = (DefaultTableModel) jTable_Flights.getModel();

		Object[] rowData = new Object[7];

		I_Flight flightManager = new FlightManager();

		this.flightList = flightManager.getFlightList();

		flightList.forEach(n -> {

			rowData[0] = n.getFlightID();
			rowData[1] = n.getDepartureTime();
			rowData[2] = n.getDepartureDate();
			rowData[3] = n.getDepartureAirport();
			rowData[4] = n.getArrivalTime();
			rowData[5] = n.getArrivalDate();
			rowData[6] = n.getArrivalAirport();

			model.addRow(rowData);
		});

	}

	/**
	 * @param args
	 *            the command line arguments
	 */

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton jButton_continue;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable_Flights;
	// End of variables declaration//GEN-END:variables

}
