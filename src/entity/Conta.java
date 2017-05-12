package entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Conta {

	@EmbeddedId
	private DadosConta contaUsuario;
	private String senha;
	private String tipoConta;
	private double saldo;

	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * @param senha
	 *            the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * @return the tipoConta
	 */
	public String getTipoConta() {
		return tipoConta;
	}

	/**
	 * @param tipoConta
	 *            the tipoConta to set
	 */
	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}

	/**
	 * @return the saldo
	 */
	public double getSaldo() {
		return saldo;
	}

	/**
	 * @param saldo
	 *            the saldo to set
	 */
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	/**
	 * @return the contaUsuario
	 */
	public DadosConta getContaUsuario() {
		return contaUsuario;
	}

	/**
	 * @param contaUsuario
	 *            the contaUsuario to set
	 */
	public void setContaUsuario(DadosConta contaUsuario) {
		this.contaUsuario = contaUsuario;
	}
}