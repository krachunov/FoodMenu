package com.levins.food.menu.ui.table.food;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.levins.food.menu.jpa.Employee;
import com.levins.food.menu.jpa.FoodAction;
import com.levins.food.menu.jpa.FoodMenuUnit;

@SuppressWarnings("serial")
public class TableModelFood extends AbstractTableModel {
	private static final int COLUMNS_COUNT = 4;
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
		@SuppressWarnings({ "rawtypes", "unused" })
		List list = getListToTable();
		Employee singleResult = (Employee) listToTable.get(rowIndex);

		switch (columnIndex) {
		case 0:
			return singleResult.getId();
		case 1:
			return singleResult.getName();
		case 2:
			return singleResult.getDepartment();
		}
		return null;
	}

	public void deleteRecord(int index) {
		Employee remove = (Employee) listToTable.remove(index);
		FoodAction action = new FoodAction();
		action.removeEmployee(remove.getName(), remove.getDepartment());
		fireTableDataChanged();
	}
}
