package com.levins.food.menu.ui;

import javax.swing.JOptionPane;

import javax.swing.JDialog;

public class ConfirmWindow {
	public ConfirmWindow() {
		JDialog.setDefaultLookAndFeelDecorated(true);
		int response = JOptionPane.showConfirmDialog(null,
				"Do you want to continue?", "Confirm",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (response == JOptionPane.NO_OPTION) {
			System.out.println("No button clicked");
		} else if (response == JOptionPane.YES_OPTION) {
			System.out.println("Yes button clicked");
		} else if (response == JOptionPane.CLOSED_OPTION) {
			System.out.println("JOptionPane closed");
		}
	}
}