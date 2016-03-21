package com.levins.food.menu;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Demo {

	public static List<Employee> getAllEmployees()
			throws ClassNotFoundException {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("FoodMenu");
		EntityManager entityManager = factory.createEntityManager();

		String stringQuery = String.format("from * s where (s.Employee");
		System.out.println(stringQuery);
		Query query = entityManager.createQuery(stringQuery);
		@SuppressWarnings("unchecked")
		List<Employee> list = query.getResultList();

		entityManager.close();
		return list;
	}

	// "dd_MM_yyyy" "dd_MM_yyyy':'HH:mm:"
	public static Date createdDate(String format) {
		DateFormat df = new SimpleDateFormat(format);
		Date today = Calendar.getInstance().getTime();
		String reportDate = df.format(today);
		// return reportDate;
		return today;
	}

	public static void main(String[] args) {
		Date date = createdDate("dd_MM_yyyy':'HH:mm:");

		// Employee employee = new Employee("Teodor", "IT", new ArrayList<>());
		//
		// List<Food> listFood = new ArrayList<Food>();
		// Food food1 = new Food(date, "banica", 35.2, 1);
		// Food food2 = new Food(date, "boza", 5.2, 1);
		// listFood.add(food1);
		// listFood.add(food2);
		//
		// Double totalAmount = 0d;
		// for (Food food : listFood) {
		// totalAmount += food.getPrice();
		// }
		//
		// MyOrder purch = new MyOrder(employee, date, listFood, totalAmount);
		// employee.getPurchase().add(purch);
		//
		// System.out.println("Employee");
		// System.out.println(employee);
		//
		// System.out.println("Purch");
		// System.out.println(employee.getPurchase().get(0));
		//
		// System.out.println("Food");
		// System.out.println(food1);

		 FoodAction action = new FoodAction();
		System.out.println( action.employeeExists("JsJ"));
//		 action.addEmployee("JJ", "IT");

		// action.addUnit(food1);
		// action.addUnit(food2);
		// action.addUnit(purch);


	}
}
