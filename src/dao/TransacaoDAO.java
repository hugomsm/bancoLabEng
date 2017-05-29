package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.Transacao;

public class TransacaoDAO {

	public static void adicionar(Transacao transacaoAtual) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("BANCO");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(transacaoAtual);
		em.getTransaction().commit();
		em.clear();
		factory.close();
	}

}
