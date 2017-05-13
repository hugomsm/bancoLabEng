package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entity.Conta;
import entity.DadosConta;
import entity.Usuario;

public class LoginDAO {

	public static boolean validar(String agencia, String conta, String senha) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("BANCO");
		EntityManager em = factory.createEntityManager();
		try {
			Query query = em.createQuery("select c from conta where " + "agencia = :agencia and conta= :conta "
					+ "and senha = :senha");
			query.setParameter("agencia", agencia);
			query.setParameter("conta", conta);
			query.setParameter("senha", senha);
			Conta c = (Conta) query.getResultList();
			if (c != null) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static Conta getConta(DadosConta contaUsuario) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("BANCO");
		EntityManager em = factory.createEntityManager();
		Conta c = em.find(Conta.class, contaUsuario);
		factory.close();
		em.close();
		return c;
	}
}