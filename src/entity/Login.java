package entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Login {
	
	private long id;
	private String agencia;
	private String conta;
	private String senha;
	
	/**
	 * @return the id
	*/
	@Id
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the agencia
	 */
	public String getAgencia() {
		return agencia;
	}
	/**
	 * @param agencia the agencia to set
	 */
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	/**
	 * @return the conta
	 */
	public String getConta() {
		return conta;
	}
	/**
	 * @param conta the conta to set
	 */
	public void setConta(String conta) {
		this.conta = conta;
	}
	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}
	/**
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
