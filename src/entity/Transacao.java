package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Transacao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1443846886987337607L;
	@Id
	@GeneratedValue
	private long id;
	private Date dataTransacao;
	private String tipo;
	@Min(1)
	private double valor;
	private Conta contaOrigem;
	private Conta conta = new Conta();

	/**
	 * @return the dataTransacao
	 */
	public Date getDataTransacao() {
		return dataTransacao;
	}

	/**
	 * @param dataTransacao
	 *            the dataTransacao to set
	 */
	public void setDataTransacao(Date dataTransacao) {
		this.dataTransacao = dataTransacao;
	}

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo
	 *            the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the valor
	 */
	public double getValor() {
		return valor;
	}

	/**
	 * @param valor
	 *            the valor to set
	 */
	public void setValor(double valor) {
		this.valor = valor;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the conta
	 */
	public Conta getConta() {
		return conta;
	}

	/**
	 * @param conta
	 *            the conta to set
	 */
	public void setConta(Conta conta) {
		this.conta = conta;
	}

	/**
	 * @return the contaOrigem
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	public Conta getContaOrigem() {
		return contaOrigem;
	}

	/**
	 * @param contaOrigem the contaOrigem to set
	 */
	public void setContaOrigem(Conta contaOrigem) {
		this.contaOrigem = contaOrigem;
	}

}
