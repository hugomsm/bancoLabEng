package controller;

import javax.faces.application.Application;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import entity.Conta;
import entity.Usuario;

public class AcessoListener implements PhaseListener {
	private static final long serialVersionUID = -2332229583990843261L;

	@Override
	public void afterPhase(PhaseEvent ev) {
		// System.out.println(ev.getPhaseId().getName() + "afterPhase");
		// FacesContext fc = ev.getFacesContext();
		// String pagina = fc.getViewRoot().getViewId();
		// if (!"/login.xhtml".equals(pagina)) {
		// Application app = fc.getApplication();
		// Conta c = app.evaluateExpressionGet(fc, "#{contaMB.conta}",
		// Conta.class);
		// if (c == null) {
		// NavigationHandler nav = app.getNavigationHandler();
		// nav.handleNavigation(fc, null, "login?faces-redirect=true");
		// fc.renderResponse();
		// }
		// }
	}

	@Override
	public void beforePhase(PhaseEvent ev) {
		// System.out.println(ev.getPhaseId().getName() + "beforePhase");
	}

	@Override
	public PhaseId getPhaseId() {
		// return PhaseId.RESTORE_VIEW;
		return PhaseId.ANY_PHASE;
	}

}