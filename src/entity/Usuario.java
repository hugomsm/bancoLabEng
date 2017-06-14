package entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import controller.ValidarCampos;

@Entity
@Table(name = "usuario")
public class Usuario {
	@NotEmpty(message = "Não pode estar vazio")
	private String nome;
	@NotEmpty(message = "O CPF deve possuir 11 caracteres")
	@Length(min = 14, max = 14, message = "O CPF deve possuir 11 caracteres")
	@Id
	private String cpf;
	@NotEmpty(message = "Não pode estar vazio")
	@Length(min = 12, max = 12, message = "O RG deve possuir 9 caracteres")
	private String rg;
	@Past(message = "A data não pode ser futura")
	@NotNull(message = "Não pode estar vazio")
	private Date dataNasc;
	@NotEmpty(message = "Não pode estar vazio")
	@Length(min = 13, max = 14, message = "O telefone deve possuir 10 ou 11 dígitos, incluindo DDD")
	private String telefone;
	@Email(message = "O Email não é válido")
	@NotEmpty(message = "Não pode estar vazio")
	private String email;
	@NotEmpty(message = "Não pode estar vazio")
	private String logradouro;
	@NotEmpty(message = "Não pode estar vazio")
	@Min(0)
	private String numero;
	@NotEmpty(message = "Não pode estar vazio")
	@Length(min = 9, max = 9, message = "O CEP deve possuir 8 caracteres")
	private String cep;

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
	 * @throws Exception 
	 */
	public void setCpf(String cpf) throws Exception {
			this.cpf = cpf;
	}

	/**
	 * @return the rg
	 */
	public String getRg() {
		return rg;
	}

	/**
	 * @param rg
	 *            the rg to set
	 */
	public void setRg(String rg) {
		this.rg = rg;
	}

	/**
	 * @return the dataNasc
	 */
	public Date getDataNasc() {
		return dataNasc;
	}

	/**
	 * @param dataNasc
	 *            the dataNasc to set
	 */
	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	/**
	 * @return the telefone
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * @param telefone
	 *            the telefone to set
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
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

}