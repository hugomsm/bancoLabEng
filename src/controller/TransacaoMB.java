//package controller;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.RequestScoped;
//import javax.faces.context.FacesContext;
//
//import dao.ContaDAO;
//import dao.TransacaoDAO;
//import entity.Conta;
//import entity.Transacao;
//
//@RequestScoped
//@ManagedBean
//public class TransacaoMB {
//
//	private Transacao transacaoAtual = new Transacao();
//	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//
//	/**
//	 * @return the transacaoAtual
//	 */
//	public Transacao getTransacaoAtual() {
//		return transacaoAtual;
//	}
//
//	/**
//	 * @param transacaoAtual
//	 *            the transacaoAtual to set
//	 */
//	public void setTransacaoAtual(Transacao transacaoAtual) {
//		this.transacaoAtual = transacaoAtual;
//	}
//
//	public void transferir() {
//		FacesContext context = FacesContext.getCurrentInstance();
//		Conta c = (Conta) context.getApplication().evaluateExpressionGet(context, "#{contaMB.conta}", Conta.class);
//		if (transacaoAtual.getConta().equals(c)) {
//			// Exception de erro
//		} else {
//			Conta contaDestino = ContaDAO.procurar(transacaoAtual.getConta().getContaUsuario());
//			if (contaDestino != null) {
//				if (transacaoAtual.getValor() <= c.getSaldo()) {
//					contaDestino.setSaldo(contaDestino.getSaldo() + transacaoAtual.getValor());
//					ContaDAO.atualizar(contaDestino);
//					transacaoAtual.setTipo("Transferência");
//					try {
//						transacaoAtual.setDataTransacao(sdf.parse(sdf.format((new Date()))));
//					} catch (ParseException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					TransacaoDAO.adicionar(transacaoAtual);
//				} else {
//					// Mensagem de saldo insuficiente
//				}
//
//			} else {
//				// Mensagem de conta não existente
//			}
//		}
//	}
//
//	public void depositar() {
//		FacesContext context = FacesContext.getCurrentInstance();
//		Conta c = (Conta) context.getApplication().evaluateExpressionGet(context, "#{contaMB.conta}", Conta.class);
//		c.setSaldo(c.getSaldo() + transacaoAtual.getValor());
//		ContaDAO.atualizar(c);
//		transacaoAtual.setConta(c);
//		transacaoAtual.setTipo("Depósito");
//		try {
//			transacaoAtual.setDataTransacao(sdf.parse(sdf.format((new Date()))));
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		TransacaoDAO.adicionar(transacaoAtual);
//	}
//
//}
