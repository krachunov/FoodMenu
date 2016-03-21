package com.levins.food.menu.ui;
import java.util.List;
import java.util.Queue;

import javax.swing.table.AbstractTableModel;

import com.levins.food.menu.jpa.FoodMenuUnit;

@SuppressWarnings("serial")
public class TableModel extends AbstractTableModel {
	private static final int COLUMNS_COUNT = 7;
	private List<FoodMenuUnit> listToTable;

	public List<FoodMenuUnit> getListToTable() {
		return listToTable;
	}

	public void setListToTable(List<FoodMenuUnit> listToTable) {
		this.listToTable = listToTable;
		fireTableDataChanged();
	}

	@Override
	public int getColumnCount() {
		return COLUMNS_COUNT;
	}

	@Override
	public int getRowCount() {

		return (listToTable != null ? listToTable.size() : 0);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		List list = getListToTable();
		FoodMenuUnit singleResult = listToTable.get(rowIndex);

		switch (columnIndex) {
//		case 0:
//			return singleResult.getClass();
//		case 1:
//			return singleResult.getColor();
//		case 2:
//			return singleResult.getBreed();
//		case 3:
//			return singleResult.getGender();
//		case 4:
//			return singleResult.getName();
//		case 5:
//			return singleResult.getEntry();
//		case 6:
//			return singleResult.getDate();
		}
		return null;
	}

	public void deleteRecord(int index) {
		listToTable.remove(index);
		fireTableDataChanged();
	}
}
