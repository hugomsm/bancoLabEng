package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.Usuario;

public class UsuarioDAO {

	public static void adicionar(Usuario novoUsuario) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("BANCO");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(novoUsuario);
		em.getTransaction().commit();
		em.clear();
		factory.close();
	}

}
