package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import dao.ContaDAO;
import dao.TransacaoDAO;
import entity.Conta;
import entity.Transacao;

@RequestScoped
@ManagedBean
public class TransacaoMB {

	private Transacao transacaoAtual = new Transacao();

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
		if (transacaoAtual.getConta().equals(c)) {
			// Exception de erro
		} else {
			Conta contaDestino = ContaDAO.procurar(transacaoAtual.getConta().getContaUsuario());
			if (contaDestino != null) {
				contaDestino.setSaldo(contaDestino.getSaldo() + transacaoAtual.getValor());
				ContaDAO.atualizar(contaDestino);
				TransacaoDAO.adicionar(transacaoAtual);
			} else {
				// Mensagem de conta não existente
			}
		}
	}

}
