package controller;

import javax.faces.application.Application;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import entity.Usuario;

public class AcessoListener implements PhaseListener {
	private static final long serialVersionUID = -2332229583990843261L;

	@Override
	public void afterPhase(PhaseEvent ev) {
		FacesContext fc = ev.getFacesContext();
		String pagina = fc.getViewRoot().getViewId();
		if (!"/login.xhtml".equals(pagina)) {
			Application app = fc.getApplication();
			Usuario user = app.evaluateExpressionGet(fc, "#{loginMB.usuarioAtual}", Usuario.class);
			if (user == null) {
				NavigationHandler nav = app.getNavigationHandler();
				nav.handleNavigation(fc, null, "login?faces-redirect=true");
				fc.renderResponse();
			}
		}
	}

	@Override
	public void beforePhase(PhaseEvent ev) {
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}