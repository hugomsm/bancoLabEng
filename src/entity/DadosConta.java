package entity;

import java.util.Random;

import javax.persistence.Embeddable;

@Embeddable
public class DadosConta {

	private String agencia;
	private String conta;

	/**
	 * @return the agencia
	 */
	public String getAgencia() {
		return agencia;
	}

	/**
	 * @param agencia
	 *            the agencia to set
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
	 * @param conta
	 *            the conta to set
	 */
	public void setConta(String conta) {
		this.conta = conta;
	}
	
	public String gerarAgencia(){
		Random r = new Random();
		int i = r.nextInt(89999) + 10000;
		return Integer.toString(i);
	}
	
	public String gerarConta(){
		Random r = new Random();
		int i = r.nextInt(899999) + 100000;
		return Integer.toString(i);
	}
}
