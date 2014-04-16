var i18n = (function($) {
	var updateLocalI18n = function(key) {
		$.ajax({
			url: '/i18n/' + key,
			async: false,
			success: function(data) {
				localStorage[data.key] = data.message;
			}
		});
	}

	return {
		get: function(key) {
			if (!localStorage[key]) {
				updateLocalI18n(key);
			}
			return localStorage[key];
		}
	}
})(window.jQuery||window.Zepto);