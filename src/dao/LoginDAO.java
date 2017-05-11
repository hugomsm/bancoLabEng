package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entity.DadosConta;
import entity.Usuario;

public class LoginDAO {

	public static boolean validar(String agencia, String conta, String senha) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("");
		EntityManager em = factory.createEntityManager();
		try {
			Query query = em.createQuery("select u from Usuario where " + "u.agencia = :agencia and u.conta= :conta "
					+ "and u.senha = :senha");
			Usuario u = (Usuario) query.getResultList();
			if (u != null) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static Usuario getUsuario(DadosConta contaUsuario) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("");
		EntityManager em = factory.createEntityManager();
		Usuario u = em.find(Usuario.class, contaUsuario);
		factory.close();
		em.close();
		return u;
	}
}