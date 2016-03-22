package com.levins.food.menu.ui;

import javax.swing.JFrame;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.event.DocumentListener;

import com.levins.food.menu.jpa.FoodAction;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddSingleUser extends JFrame {
	private AddSingleUser currentWindow = this;
	private JTextField txtName;
	private JTextField txtDepartment;
	private JButton btnAdd;

	public AddSingleUser() {
		setTitle("Add Employee");
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		JLabel lblName = new JLabel("Name");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.WEST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 0;
		getContentPane().add(lblName, gbc_lblName);

		JLabel lblDepartmentLabel = new JLabel("Department");
		GridBagConstraints gbc_lblDepartmentLabel = new GridBagConstraints();
		gbc_lblDepartmentLabel.anchor = GridBagConstraints.WEST;
		gbc_lblDepartmentLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblDepartmentLabel.gridx = 2;
		gbc_lblDepartmentLabel.gridy = 0;
		getContentPane().add(lblDepartmentLabel, gbc_lblDepartmentLabel);

		txtName = new JTextField();
		GridBagConstraints gbc_txtName = new GridBagConstraints();
		gbc_txtName.insets = new Insets(0, 0, 0, 5);
		gbc_txtName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtName.gridx = 0;
		gbc_txtName.gridy = 1;
		getContentPane().add(txtName, gbc_txtName);
		txtName.setColumns(10);

		txtDepartment = new JTextField();
		GridBagConstraints gbc_txtDepartment = new GridBagConstraints();
		gbc_txtDepartment.insets = new Insets(0, 0, 0, 5);
		gbc_txtDepartment.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDepartment.gridx = 2;
		gbc_txtDepartment.gridy = 1;
		getContentPane().add(txtDepartment, gbc_txtDepartment);
		txtDepartment.setColumns(10);

		btnAdd = new JButton("Add");
		btnAdd.setEnabled(false);
		DocumentListenerClient listenerAddButn = new DocumentListenerClient(btnAdd);
		listenerAddButn.addTextField(txtName);
		listenerAddButn.addTextField(txtDepartment);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FoodAction action = new FoodAction();
				action.addEmployee(txtName.getText(), txtDepartment.getText());
				currentWindow.dispose();
			}
		});
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.gridx = 3;
		gbc_btnAdd.gridy = 1;
		getContentPane().add(btnAdd, gbc_btnAdd);
		this.pack();
	}

}
