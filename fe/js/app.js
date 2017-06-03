(function (window) {
	'use strict';

	// Your starting point. Enjoy the ride!
	findAll();
	$('#new-todo').keydown(function(e){
		if(e.which == 13) {
			var todoValue = $('#new-todo').val();
			var obj = {"todo":todoValue};
			var todoJSON = JSON.stringify(obj);
			var arg = {method:'POST', data:todoJSON, func:findAll}
			allAjax(arg);
			$('#new-todo').val("");
		}
	})

})(window);
