package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;

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
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({@JoinColumn(name = "agencia"), @JoinColumn(name = "conta")})
	private Conta contaOrigem;
	private String agenciaDestino;
	private String contaDestino;
	private String cpfDestino;

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
	 * @return the contaOrigem
	 */

	public Conta getContaOrigem() {
		return contaOrigem;
	}

	/**
	 * @param contaOrigem
	 *            the contaOrigem to set
	 */
	public void setContaOrigem(Conta contaOrigem) {
		this.contaOrigem = contaOrigem;
	}

	/**
	 * @return the agenciaDestino
	 */
	public String getAgenciaDestino() {
		return agenciaDestino;
	}

	/**
	 * @param agenciaDestino the agenciaDestino to set
	 */
	public void setAgenciaDestino(String agenciaDestino) {
		this.agenciaDestino = agenciaDestino;
	}

	/**
	 * @return the contaDestino
	 */
	public String getContaDestino() {
		return contaDestino;
	}

	/**
	 * @param contaDestino the contaDestino to set
	 */
	public void setContaDestino(String contaDestino) {
		this.contaDestino = contaDestino;
	}

	/**
	 * @return the cpfDestino
	 */
	public String getCpfDestino() {
		return cpfDestino;
	}

	/**
	 * @param cpfDestino the cpfDestino to set
	 */
	public void setCpfDestino(String cpfDestino) {
		this.cpfDestino = cpfDestino;
	}

}
