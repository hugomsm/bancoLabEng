package entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
//<f:actionListener binding="#{contaMB.salvar()}" />
//</h:commandButton>
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="conta")
public class Conta {

	private DadosConta contaUsuario = new DadosConta();
	@NotEmpty(message="Senha não pode estar em branco")
	private String senha;
	@NotEmpty(message="Selecione uma opção")
	private String tipoConta;
	private double saldo;
	private Usuario usuario = new Usuario();
	private List<Transacao> transacoes = new ArrayList<>();

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
	@EmbeddedId
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

	/**
	 * @return the usuario
	 */
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="USER_CPF", unique= true, nullable=false, insertable=true, updatable=true)
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario
	 *            the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the transacoes
	 */
	@OneToMany(mappedBy="contaOrigem", fetch = FetchType.EAGER)
	public List<Transacao> getTransacoes() {
		return transacoes;
	}

	/**
	 * @param transacoes the transacoes to set
	 */
	public void setTransacoes(List<Transacao> transacoes) {
		this.transacoes = transacoes;
	}
}