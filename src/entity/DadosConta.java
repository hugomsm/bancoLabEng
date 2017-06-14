package entity;

import java.io.Serializable;
import java.util.Random;

import javax.faces.context.FacesContext;
import javax.persistence.Embeddable;

import org.hibernate.validator.constraints.NotEmpty;

@Embeddable
public class DadosConta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7021727065659352073L;
	@NotEmpty(message="Não pode estar vazio.")
	private String agencia;
	@NotEmpty(message="Não pode estar vazio")
	private String conta;

	/**
	 * @return the agencia
	 */
	public String getAgencia() {
		FacesContext ctx = FacesContext.getCurrentInstance();
		String pagina = ctx.getViewRoot().getViewId();
		
		if ("/cadastro.xhtml".equals(pagina)) {
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
		FacesContext ctx = FacesContext.getCurrentInstance();
		String pagina = ctx.getViewRoot().getViewId();
		
		if ("/cadastro.xhtml".equals(pagina)) {
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
