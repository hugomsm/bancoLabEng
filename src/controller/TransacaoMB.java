package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import dao.ContaDAO;
import dao.TransacaoDAO;
import entity.Conta;
import entity.DadosConta;
import entity.Transacao;

@RequestScoped
@ManagedBean
public class TransacaoMB {

	private Transacao transacaoAtual = new Transacao();
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	/**
	 * @return the transacaoAtual
	 */
	public Transacao getTransacaoAtual() {
		return transacaoAtual;
	}

	/**
	 * @param transacaoAtual
	 *            the transacaoAtual to set
	 */
	public void setTransacaoAtual(Transacao transacaoAtual) {
		this.transacaoAtual = transacaoAtual;
	}

	public void transferir() {
		FacesContext context = FacesContext.getCurrentInstance();
		Conta c = (Conta) context.getApplication().evaluateExpressionGet(context, "#{contaMB.conta}", Conta.class);
		transacaoAtual.setContaOrigem(c);
		if (transacaoAtual.getContaOrigem().equals(c)) {
			FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Transação inválida", "Não é possível transferir para a própria conta.");

			throw new ValidatorException(mensagem);
		} else {
			Conta contaDestino = ContaDAO.procurar(transacaoAtual.getAgenciaDestino(), transacaoAtual.getContaDestino(),
					transacaoAtual.getCpfDestino());
			if (contaDestino != null) {
				if (transacaoAtual.getValor() <= c.getSaldo()) {
					contaDestino.setSaldo(contaDestino.getSaldo() + transacaoAtual.getValor());
					ContaDAO.atualizar(contaDestino);
					transacaoAtual.setTipo("Transferência");
					try {
						transacaoAtual.setDataTransacao(sdf.parse(sdf.format((new Date()))));
					} catch (ParseException e) {
						e.printStackTrace();
						transacaoAtual.setDataTransacao(new Date());
					}
					TransacaoDAO.adicionar(transacaoAtual);
				} else {
					FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Saldo insuficiente", "Seu saldo não é suficiente para completar a transação");

					throw new ValidatorException(mensagem);
				}

			} else {
				FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Conta não existe", "A conta informada não existe.");

				throw new ValidatorException(mensagem);			}
		}
	}

	public String depositar() {
		FacesContext context = FacesContext.getCurrentInstance();
		Conta c = (Conta) context.getApplication().evaluateExpressionGet(context, "#{contaMB.conta}", Conta.class);
		c.setSaldo(c.getSaldo() + transacaoAtual.getValor());
		ContaDAO.atualizar(c);
		transacaoAtual.setAgenciaDestino(c.getContaUsuario().getAgencia());
		transacaoAtual.setContaDestino(c.getContaUsuario().getConta());
		transacaoAtual.setCpfDestino(c.getUsuario().getCpf());
		transacaoAtual.setTipo("Depósito");
		try {
			transacaoAtual.setDataTransacao(sdf.parse(sdf.format((new Date()))));
		} catch (ParseException e) {
			e.printStackTrace();
			transacaoAtual.setDataTransacao(new Date());
		}
		TransacaoDAO.adicionar(transacaoAtual);
		c.getTransacoes().add(transacaoAtual);
		return "conta";
	}

}
