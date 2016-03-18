package com.levins.food.menu;

import java.util.ArrayList;
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

	public static void main(String[] args) {
		Date date = new Date();

		Employee employee = new Employee("TEO", "IT", new ArrayList<>());

		List<Food> listFood = new ArrayList<Food>();
		Food food1 = new Food(date, "domati", 10.5, 1);
		listFood.add(food1);

		Double totalAmount = 0d;
		for (Food food : listFood) {
			totalAmount += food.getPrice();
		}

		MyOrder purch = new MyOrder(employee, date, listFood, totalAmount);
		employee.getPurchase().add(purch);

		System.out.println("Employee");
		System.out.println(employee);

		System.out.println("Purch");
		System.out.println(employee.getPurchase().get(0));

		System.out.println("Food");
		System.out.println(food1);

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("FoodMenu");
		try {

			EntityManager entityManager = factory.createEntityManager();

			entityManager.getTransaction().begin();
			entityManager.persist(employee);
			entityManager.getTransaction().commit();

			entityManager.getTransaction().begin();
			entityManager.persist(purch);
			entityManager.getTransaction().commit();

			entityManager.getTransaction().begin();
			entityManager.persist(food1);
			entityManager.getTransaction().commit();

			entityManager.close();

		} finally {
			factory.close();
		}
	}
}
