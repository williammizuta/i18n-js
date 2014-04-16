var i18n = (function($) {
	var updateLocalI18n = function(key) {
		$.ajax({
			url: '/i18n/' + key,
			async: false,
			success: function(data) {
				sessionStorage.setItem("version", data.version);
				localStorage.setItem(data.key, JSON.stringify(data));
			}
		});
	}

	return {
		get: function(key) {
			var version = sessionStorage.getItem('version'),
				message = localStorage.getItem(key);
			if (!version || !message || JSON.parse(message).version != version) {
				updateLocalI18n(key);
			}
			return JSON.parse(localStorage.getItem(key)).message;
		}
	}
})(window.jQuery||window.Zepto);