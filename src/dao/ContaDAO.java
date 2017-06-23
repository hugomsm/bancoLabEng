package dao;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import entity.Conta;
import entity.DadosConta;

public class ContaDAO {
	public static void adicionar(Conta novaConta) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("BANCO");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(novaConta);
		em.getTransaction().commit();
		em.clear();
		em.close();
		factory.close();
	}

	public static Conta validar(String agencia, String conta, String senha) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("BANCO");
		EntityManager em = factory.createEntityManager();
		try {
			Query query = em
					.createQuery("select c from Conta c where " + "agencia = :ag and conta = :ct " + "and senha = :sh");
			query.setParameter("ag", agencia);
			query.setParameter("ct", conta);
			query.setParameter("sh", senha);
			List<Conta> contas = query.getResultList();
			em.clear();
			em.close();
			factory.close();
			if (contas != null && contas.size() > 0) {
				return contas.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Conta procurar(DadosConta dc) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("BANCO");
		EntityManager em = factory.createEntityManager();
		Conta c = em.find(Conta.class, dc);
		em.clear();
		em.close();
		factory.close();
		if (c != null) {
			return c;
		}
		return null;

	}

	public static boolean atualizar(Conta c) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("BANCO");
		EntityManager em = factory.createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(c);
			em.getTransaction().commit();
			em.clear();
			em.close();
			factory.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static Conta procurar(String agenciaDestino, String contaDestino, String cpfDestino) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("BANCO");
		EntityManager em = factory.createEntityManager();
		DadosConta dc = new DadosConta();
		dc.setAgencia(agenciaDestino);
		dc.setConta(contaDestino);
		Conta c = em.find(Conta.class, dc);
		em.clear();
		em.close();
		factory.close();
		if (cpfDestino.equals(c.getUsuario().getCpf()) && c != null) {
			return c;
		} else {
			FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Transferência inválida", "Verifique se os dados estão corretos para completar a transação.");
			throw new ValidatorException(mensagem);
		}
	}

	public static Conta procurarSenha(String agencia, String conta, String cpf, String rg, String telefone) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("BANCO");
		EntityManager em = factory.createEntityManager();
		try {
			Query query = em.createQuery("select con FROM Conta con INNER JOIN con.usuario u "
					+ "WHERE con.contaUsuario.agencia = :ag AND con.contaUsuario.conta = :ct AND u.cpf = :cp AND u.rg = :rg AND"
					+ " u.telefone = :tel");
			query.setParameter("ag", agencia);
			query.setParameter("ct", conta);
			query.setParameter("cp", cpf);
			query.setParameter("rg", rg);
			query.setParameter("tel", telefone);
			Conta contas = (Conta) query.getSingleResult();
			em.clear();
			em.close();
			factory.close();
			if (contas != null){
				return contas;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void remover(Conta conta) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("BANCO");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Object c = em.merge(conta);
		em.remove(c);
		em.getTransaction().commit();
		em.clear();
		em.close();
		factory.close();
	}
	
	public static List<Conta> buscaDev() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("BANCO");
		EntityManager em = factory.createEntityManager();
		try {
			Query query = em.createQuery("CREATE OR REPLACE PROCEDURE listarNumConta"+
			  		 					 "BEGIN"+ 
			  		 					 	"SELECT agencia, conta FROM conta"+
			  		 					 	"WHERE saldo > 0;"+
										 "END listarNumConta;");
			query.executeUpdate();
			em.clear();
			em.close();
			factory.close();
			
		}catch (Exception e) {
			e.printStackTrace();			
		}
		
		List<Conta> contas = runProc();
		
		return contas;	
	}
	
	public static List<Conta> runProc(){
		List<Conta> contas = new ArrayList<Conta>();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("BANCO");
		EntityManager em = factory.createEntityManager();
		try {
			Query query = em.createQuery("EXEC listarNumConta;");
			contas = query.getResultList();
			
			em.clear();
			em.close();
			factory.close();
			
		}catch (Exception e) {
			e.printStackTrace();			
		}
		
		return contas;
	}
	
}
