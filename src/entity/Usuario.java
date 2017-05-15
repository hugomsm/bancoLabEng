package entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Usuario {

	private String nome;
	@Id
	private String cpf;
	private String logradouro;
	private String numero;
	private String cep;
	//private Conta conta = new Conta();

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * @param cpf
	 *            the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * @return the logradouro
	 */
	public String getLogradouro() {
		return logradouro;
	}

	/**
	 * @param logradouro
	 *            the logradouro to set
	 */
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	/**
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * @param numero
	 *            the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * @return the cep
	 */
	public String getCep() {
		return cep;
	}

	/**
	 * @param cep
	 *            the cep to set
	 */
	public void setCep(String cep) {
		this.cep = cep;
	}

	/*
	 * 
	 * @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuario") public Conta
	 * getConta() { return conta; }
	 */
	
//	/**
//	 * @param conta
//	 *            the conta to set
//	 */
//	@Cascade(org.hibernate.annotations.CascadeType.ALL)
//	public void setConta(Conta conta) {
//		this.conta = conta;
//	}

}
