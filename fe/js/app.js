(function (window) {
	'use strict';

	// Your starting point. Enjoy the ride!
	$('#new-task').keydown(function(e){
		if(e.which == 13) {
			var taskValue = $('#new-task').val();
			var obj = {"todo":taskValue};
			var taskJSON = JSON.stringify(obj);
			console.log(taskJSON);
			$.ajax({
				method : 'POST',
				data : taskJSON,
				dataType : 'application/json',
				url : 'http://localhost:8080/api/todos',
				success : function(response) {
					$('#test').html(response);
				}
			})
		}
	})

})(window);
