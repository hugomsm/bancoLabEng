package entity;

import java.io.Serializable;
import java.util.Random;

import javax.persistence.Embeddable;
import javax.persistence.Id;

@Embeddable
public class DadosConta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7021727065659352073L;
	private String agencia;
	private String conta;

	/**
	 * @return the agencia
	 */
	public String getAgencia() {
		if (agencia == null) {
			Random r = new Random();
			int i = r.nextInt(89999) + 10000;
			return Integer.toString(i);
		}
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
		if (conta == null) {
			Random r = new Random();
			int i = r.nextInt(899999) + 100000;
			return Integer.toString(i);
		}

		return conta;
	}

	/**
	 * @param conta
	 *            the conta to set
	 */
	public void setConta(String conta) {
		this.conta = conta;
	}

}
