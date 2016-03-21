package com.levins.food.menu.ui;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class ControlPanelMenu extends JFrame {
	public ControlPanelMenu() {
		setTitle("Food Order");
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblManageEmployees = new JLabel("Manage Employees");
		GridBagConstraints gbc_lblManageEmployees = new GridBagConstraints();
		gbc_lblManageEmployees.insets = new Insets(0, 0, 5, 5);
		gbc_lblManageEmployees.gridx = 0;
		gbc_lblManageEmployees.gridy = 0;
		getContentPane().add(lblManageEmployees, gbc_lblManageEmployees);
		
		JLabel lblManageFood = new JLabel("Manage Food");
		GridBagConstraints gbc_lblManageFood = new GridBagConstraints();
		gbc_lblManageFood.insets = new Insets(0, 0, 5, 5);
		gbc_lblManageFood.gridx = 2;
		gbc_lblManageFood.gridy = 0;
		getContentPane().add(lblManageFood, gbc_lblManageFood);
		
		JLabel lblManageOrder = new JLabel("Manage Order");
		GridBagConstraints gbc_lblManageOrder = new GridBagConstraints();
		gbc_lblManageOrder.insets = new Insets(0, 0, 5, 0);
		gbc_lblManageOrder.gridx = 4;
		gbc_lblManageOrder.gridy = 0;
		getContentPane().add(lblManageOrder, gbc_lblManageOrder);
		
		JButton btnAddemployee = new JButton("Add Employee");
		btnAddemployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnAddemployee = new GridBagConstraints();
		gbc_btnAddemployee.gridwidth = 2;
		gbc_btnAddemployee.anchor = GridBagConstraints.WEST;
		gbc_btnAddemployee.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddemployee.gridx = 0;
		gbc_btnAddemployee.gridy = 1;
		getContentPane().add(btnAddemployee, gbc_btnAddemployee);
		
		JButton btnAddfood = new JButton("Add Single Food");
		btnAddfood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnAddfood = new GridBagConstraints();
		gbc_btnAddfood.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddfood.anchor = GridBagConstraints.WEST;
		gbc_btnAddfood.gridx = 2;
		gbc_btnAddfood.gridy = 1;
		getContentPane().add(btnAddfood, gbc_btnAddfood);
		
		JButton btnExportAllOrder = new JButton("Export All Order");
		GridBagConstraints gbc_btnExportAllOrder = new GridBagConstraints();
		gbc_btnExportAllOrder.anchor = GridBagConstraints.EAST;
		gbc_btnExportAllOrder.insets = new Insets(0, 0, 5, 0);
		gbc_btnExportAllOrder.gridx = 4;
		gbc_btnExportAllOrder.gridy = 1;
		getContentPane().add(btnExportAllOrder, gbc_btnExportAllOrder);
		
		JButton btnRemoveEmployee = new JButton("Remove Employee");
		GridBagConstraints gbc_btnRemoveEmployee = new GridBagConstraints();
		gbc_btnRemoveEmployee.insets = new Insets(0, 0, 5, 5);
		gbc_btnRemoveEmployee.gridx = 0;
		gbc_btnRemoveEmployee.gridy = 2;
		getContentPane().add(btnRemoveEmployee, gbc_btnRemoveEmployee);
		
		JButton btnAddAllMenu = new JButton("Add All Menu");
		GridBagConstraints gbc_btnAddAllMenu = new GridBagConstraints();
		gbc_btnAddAllMenu.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddAllMenu.anchor = GridBagConstraints.WEST;
		gbc_btnAddAllMenu.gridx = 2;
		gbc_btnAddAllMenu.gridy = 2;
		getContentPane().add(btnAddAllMenu, gbc_btnAddAllMenu);
		
		JButton btnExportOrderBy = new JButton("Export Order By Name");
		GridBagConstraints gbc_btnExportOrderBy = new GridBagConstraints();
		gbc_btnExportOrderBy.anchor = GridBagConstraints.EAST;
		gbc_btnExportOrderBy.insets = new Insets(0, 0, 5, 0);
		gbc_btnExportOrderBy.gridx = 4;
		gbc_btnExportOrderBy.gridy = 2;
		getContentPane().add(btnExportOrderBy, gbc_btnExportOrderBy);
		
		JButton btnRemoveFood = new JButton("Remove Food");
		GridBagConstraints gbc_btnRemoveFood = new GridBagConstraints();
		gbc_btnRemoveFood.anchor = GridBagConstraints.WEST;
		gbc_btnRemoveFood.insets = new Insets(0, 0, 5, 5);
		gbc_btnRemoveFood.gridx = 2;
		gbc_btnRemoveFood.gridy = 3;
		getContentPane().add(btnRemoveFood, gbc_btnRemoveFood);
		
		JButton btnExportOrderBy_1 = new JButton("Export Order By Date");
		GridBagConstraints gbc_btnExportOrderBy_1 = new GridBagConstraints();
		gbc_btnExportOrderBy_1.anchor = GridBagConstraints.EAST;
		gbc_btnExportOrderBy_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnExportOrderBy_1.gridx = 4;
		gbc_btnExportOrderBy_1.gridy = 3;
		getContentPane().add(btnExportOrderBy_1, gbc_btnExportOrderBy_1);
		
		JButton btnExportOrderBy_2 = new JButton("Export Order By Department");
		GridBagConstraints gbc_btnExportOrderBy_2 = new GridBagConstraints();
		gbc_btnExportOrderBy_2.gridx = 4;
		gbc_btnExportOrderBy_2.gridy = 4;
		getContentPane().add(btnExportOrderBy_2, gbc_btnExportOrderBy_2);
		this.pack();
	}
	
}
