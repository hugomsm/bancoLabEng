package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.Conta;

public class ContaDAO {
	public static void adicionar(Conta novaConta) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("BANCO");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(novaConta);
		em.getTransaction().commit();
		em.clear();
		factory.close();
	}
}
