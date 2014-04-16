package br.com.mizuta.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.Localization;
import br.com.caelum.vraptor.view.Results;
import br.com.mizuta.facade.MessageFacade;
import br.com.mizuta.model.Message;

@Resource
public class I18nController {

	private final Result result;
	private final Localization localization;
	private final MessageFacade messageFacade;

	public I18nController(Result result, Localization localization, MessageFacade messageFacade) {
		this.result = result;
		this.localization = localization;
		this.messageFacade = messageFacade;
	}

	@Get("/i18n/{key}")
	public void show(String key) {
		Message message = messageFacade.getMessage(localization, key);
		result.use(Results.json()).withoutRoot().from(message).serialize();
	}

}
