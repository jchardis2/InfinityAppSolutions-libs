package com.infinityappsolutions.server.lib.views;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

public class JSFView {

	protected void addMessage(FacesMessage msg) {
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	protected void addMessage(String title, String message) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(title, message));
	}

	protected void addMessage(Severity severity, String title, String message) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(severity, title, message));
	}
}
