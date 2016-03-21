package com.levins.food.menu;

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

	public void removeEmployee(Long employeeID){
		EntityManager entityManager = connection.getEntityManager(UNIT_NAME);
		Employee find = entityManager.find(Employee.class, employeeID);
		entityManager.getTransaction().begin();
		entityManager.remove(find);
		entityManager.getTransaction().commit();
	}
	/**
	 * 
	 * @param employeeName
	 * @return true if exist or false to otherwise
	 */
	public boolean employeeExists(String employeeName) {
		EntityManager entityManager = connection.getEntityManager(UNIT_NAME);
		  Query query = entityManager.createQuery("select e FROM levins_employees e where e.name like (:arg1)");
		  query.setParameter("arg1", employeeName);
		  return query.getResultList().size()>1;
	}
	public void addEmployee(String name, String department) {
		EntityManager entityManager = connection.getEntityManager(UNIT_NAME);
	
		Employee employee = new Employee(name, department);
		addUnit(employee);
	}

	public void addFood(String foodName, Double price) {

		Date date = createdDate("dd_MM_yyyy':'HH:mm:");
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
