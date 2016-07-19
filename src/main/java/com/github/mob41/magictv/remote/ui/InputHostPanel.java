package com.github.mob41.magictv.remote.ui;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class InputHostPanel extends JPanel {
	private JTextField hostFld;
	private JSpinner portSpinner;

	/**
	 * Create the panel.
	 */
	public InputHostPanel() {
		
		JLabel lblHost = new JLabel("Host:");
		
		hostFld = new JTextField();
		hostFld.setText("255.255.255.255");
		hostFld.setColumns(10);
		
		JLabel lblPort = new JLabel("Port:");
		
		portSpinner = new JSpinner();
		portSpinner.setModel(new SpinnerNumberModel(new Integer(23456), null, null, new Integer(1)));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblPort, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblHost, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(portSpinner, GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
						.addComponent(hostFld, GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHost)
						.addComponent(hostFld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPort)
						.addComponent(portSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(72, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
	
	public String getHostname(){
		return hostFld.getText();
	}
	
	public int getPort(){
		return (Integer) portSpinner.getValue();
	}
}
