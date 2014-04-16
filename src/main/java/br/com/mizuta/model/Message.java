package br.com.mizuta.model;

import br.com.caelum.vraptor.core.Localization;

public class Message {

	private final String key;
	private final String message;
	private final long version;

	public Message(Localization localization, String key, long version) {
		this.key = key;
		this.message = localization.getMessage(key);
		this.version = version;
	}

	public String getKey() {
		return key;
	}

	public String getMessage() {
		return message;
	}

	public long getVersion() {
		return version;
	}

}
