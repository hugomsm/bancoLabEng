package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import entity.Transacao;

@RequestScoped
@ManagedBean
public class TransacaoMB {

	Transacao transacaoAtual = new Transacao();
	List<Transacao> transacoes = new ArrayList<>();
}
