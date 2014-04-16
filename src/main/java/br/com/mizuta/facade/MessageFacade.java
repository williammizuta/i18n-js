package br.com.mizuta.facade;

import java.util.Calendar;

import javax.annotation.PostConstruct;

import br.com.caelum.vraptor.core.Localization;
import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import br.com.mizuta.model.Message;

@Component
@ApplicationScoped
public class MessageFacade {

	private long version;

	@PostConstruct
	void postConstruct() {
		this.version = Calendar.getInstance().getTimeInMillis();
	}

	public Message getMessage(Localization localization, String key) {
		return new Message(localization, key, version);
	}

}
