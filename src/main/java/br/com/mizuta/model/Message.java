package br.com.mizuta.model;

import br.com.caelum.vraptor.core.Localization;

public class Message {

	private final String key;
	private final String message;

	public Message(Localization localization, String key) {
		this.key = key;
		this.message = localization.getMessage(key);
	}

	public String getKey() {
		return key;
	}

	public String getMessage() {
		return message;
	}

}
