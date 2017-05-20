package entity;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;

public class Transacao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1443846886987337607L;
	private Date dataTransacao;
	private String tipo;
	@Min(1)
	private double valor;
	@NotEmpty
	private String destino;
	
	/**
	 * @return the dataTransacao
	 */
	public Date getDataTransacao() {
		return dataTransacao;
	}
	/**
	 * @param dataTransacao the dataTransacao to set
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
	 * @param tipo the tipo to set
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
	 * @param valor the valor to set
	 */
	public void setValor(double valor) {
		this.valor = valor;
	}
	/**
	 * @return the destino
	 */
	public String getDestino() {
		return destino;
	}
	/**
	 * @param destino the destino to set
	 */
	public void setDestino(String destino) {
		this.destino = destino;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
