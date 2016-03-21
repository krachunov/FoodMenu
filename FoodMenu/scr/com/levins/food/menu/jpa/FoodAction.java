package com.levins.food.menu.jpa;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FoodAction {
	private DataBaseConnection connection;
	private static final String UNIT_NAME = "FoodMenu";

	public FoodAction() {
		this.connection = DataBaseConnection.getInstance();
	}

	// "dd_MM_yyyy" "dd_MM_yyyy':'HH:mm:"
	public static Date createdDate(String format) {
		DateFormat df = new SimpleDateFormat(format);
		Date today = Calendar.getInstance().getTime();
		return today;
	}

	public boolean removeEmployee(String employeeName, String employeeDepratment) {
		EntityManager entityManager = connection.getEntityManager(UNIT_NAME);
		if (employeeExists(employeeName, employeeDepratment)) {
			List<Employee> resultList = findEmployees(employeeName,
					employeeDepratment);
			for (Employee employee : resultList) {

				entityManager.getTransaction().begin();
				entityManager.remove(employee);
				entityManager.getTransaction().commit();
			}
			return true;

		} else {
			return false;
		}

	}

	public List<Employee> findEmployees(String employeeName,
			String employeeDepratment) {
		EntityManager entityManager = connection.getEntityManager(UNIT_NAME);
		Query query = entityManager
				.createQuery("select e FROM levins_employees e where e.name like (:arg1) and e.department = (:arg2)");
		query.setParameter("arg1", employeeName);
		query.setParameter("arg2", employeeDepratment);

		List<Employee> resultList = query.getResultList();
		return resultList;
	}

	/**
	 * 
	 * @param employeeName
	 * @return true if exist or false to otherwise
	 */
	private boolean employeeExists(String employeeName,
			String employeeDepratment) {
		EntityManager entityManager = connection.getEntityManager(UNIT_NAME);
		Query query = entityManager
				.createQuery("select e FROM levins_employees e where e.name like (:arg1) and e.department = (:arg2)");
		query.setParameter("arg1", employeeName);
		query.setParameter("arg2", employeeDepratment);
		return query.getResultList().size() > 0;
	}

	public void addEmployee(String name, String department) {
		if (!employeeExists(name, department)) {
			EntityManager entityManager = connection
					.getEntityManager(UNIT_NAME);
			Employee employee = new Employee(name, department);
			addUnit(employee);
		}
	}

	public void addFood(Date date, String foodName, Double price) {
		Food food = new Food(date, foodName, price);
		addUnit(food);
	}

	private void addUnit(FoodMenuUnit unit) {

		EntityManager entityManager = connection
				.getEntityManager(DataBaseConnection.UNIT);
		entityManager.getTransaction().begin();
		entityManager.persist(unit);
		entityManager.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public List<FoodMenuUnit> getAllOrderByDate(String searchDate)
			throws ClassNotFoundException {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("contact");

		EntityManager entityManager = connection
				.getEntityManager(DataBaseConnection.UNIT);
		String stringQuery = "select fo.date,emp.name,emp.department,f.value,f.singlePrice,fo.totalPrice"
				+ " from levins_food_order fo, levins_emploees emp, levins_order o, levins_food f"
				+ " where emp.id=fo.employeeID "
				+ "and o.order_id=fo.id"
				+ " and f.id=o.food_id " + "and fo.date like (:arg1)";

		System.out.println(stringQuery);
		Query query = entityManager.createQuery(stringQuery);
		query.setParameter("arg1", searchDate);
		List<FoodMenuUnit> list = query.getResultList();

		entityManager.close();
		return list;
	}
}
