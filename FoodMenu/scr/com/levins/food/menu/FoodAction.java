package com.levins.food.menu;

import javax.persistence.EntityManager;

public class FoodAction {
	private DataBaseConnection connection;

	public FoodAction() {
		this.connection = DataBaseConnection.getInstance();
	}

	public void addUnit(FoodMenuUnit unit) {

		EntityManager em = null;

		em = connection.getEntityManager(DataBaseConnection.UNIT);
		em.getTransaction().begin();
		em.persist(unit);
		em.getTransaction().commit();
	}
}
