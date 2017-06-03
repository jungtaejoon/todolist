(function (window) {
	'use strict';

	// Your starting point. Enjoy the ride!
	$('#new-task').keydown(function(e){
		if(e.which == 13) {
			var todoValue = $('#new-todo').val();
			var obj = {"todo":taskValue};
			var todoJSON = JSON.stringify(obj);
			$.ajax({
				method : 'POST',
				data : todoJSON,
				contentType : 'application/json; charset=utf-8',
				dataType : 'json',
				url : 'http://localhost:8080/api/todos',
				success : function(response) {
					$('#test').html(response);
				}
			})
		}
	})

})(window);
