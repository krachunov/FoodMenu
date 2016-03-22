package com.levins.food.menu.ui;

import javax.swing.JFrame;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.levins.food.menu.jpa.FoodAction;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.swing.JPanel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

@SuppressWarnings("serial")
public class AddSingleFood extends JFrame {
	private AddSingleFood currentWindow = this;
	private JTextField txtFood;
	private JTextField txtPrice;
	private JButton btnAdd;
	private JPanel panelDateChooser;

	// private SpringLayout springLayout;

	public AddSingleFood() {
		setTitle("Add Food");
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		JLabel lblDate = new JLabel("Date");
		GridBagConstraints gbc_lblDate = new GridBagConstraints();
		gbc_lblDate.anchor = GridBagConstraints.WEST;
		gbc_lblDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblDate.gridx = 0;
		gbc_lblDate.gridy = 0;
		getContentPane().add(lblDate, gbc_lblDate);

		JLabel lblFood = new JLabel("Food");
		GridBagConstraints gbc_lblFood = new GridBagConstraints();
		gbc_lblFood.fill = GridBagConstraints.BOTH;
		gbc_lblFood.insets = new Insets(0, 0, 5, 5);
		gbc_lblFood.gridx = 1;
		gbc_lblFood.gridy = 0;
		getContentPane().add(lblFood, gbc_lblFood);

		JLabel lblPriceLabel = new JLabel("Price");
		GridBagConstraints gbc_lblPriceLabel = new GridBagConstraints();
		gbc_lblPriceLabel.anchor = GridBagConstraints.WEST;
		gbc_lblPriceLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblPriceLabel.gridx = 3;
		gbc_lblPriceLabel.gridy = 0;
		getContentPane().add(lblPriceLabel, gbc_lblPriceLabel);

		panelDateChooser = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;

		UtilDateModel model = new UtilDateModel();
		// model.setDate(20,04,2014);
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel,
				new DateLabelFormatter());
		datePicker.setVisible(true);

		panelDateChooser.add(datePicker);

		getContentPane().add(panelDateChooser, gbc_panel_1);

		txtFood = new JTextField();
		GridBagConstraints gbc_txtFood = new GridBagConstraints();
		gbc_txtFood.insets = new Insets(0, 0, 0, 5);
		gbc_txtFood.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFood.gridx = 1;
		gbc_txtFood.gridy = 1;
		getContentPane().add(txtFood, gbc_txtFood);
		txtFood.setColumns(10);

		txtPrice = new JTextField();
		GridBagConstraints gbc_txtPrice = new GridBagConstraints();
		gbc_txtPrice.insets = new Insets(0, 0, 0, 5);
		gbc_txtPrice.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPrice.gridx = 3;
		gbc_txtPrice.gridy = 1;
		getContentPane().add(txtPrice, gbc_txtPrice);
		txtPrice.setColumns(10);

		btnAdd = new JButton("Add");
		btnAdd.setEnabled(false);
		DocumentListenerClient listenerAddButn = new DocumentListenerClient(
				btnAdd);
		listenerAddButn.addTextField(txtFood);
		listenerAddButn.addTextField(txtPrice);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FoodAction action = new FoodAction();
				Date dateFromPicker = getDateValueFromPicker(datePicker);
				action.addFood(dateFromPicker, txtFood.getText(),
						Double.valueOf(txtPrice.getText()));
				currentWindow.dispose();
			}

			private Date getDateValueFromPicker(JDatePickerImpl datePicker) {
				Date selectedDate = (Date) datePicker.getModel().getValue();
				// DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				// String reportDate = df.format(selectedDate);
				return selectedDate;
			}
		});
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.gridx = 4;
		gbc_btnAdd.gridy = 1;
		getContentPane().add(btnAdd, gbc_btnAdd);
		this.pack();
	}
}
