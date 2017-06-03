(function (window) {
	'use strict';

	// Your starting point. Enjoy the ride!
	findAll();
	$('#new-todo').keydown(function(e){
		if(e.which == 13) {
			if($('#new-todo').val().trim()) {
				var todoValue = $('#new-todo').val();
				var obj = {"todo":todoValue};
				var todoJSON = JSON.stringify(obj);
				var arg = {method:'POST', data:todoJSON, func:findAll}
				allAjax(arg);
			}
			$('#new-todo').val("");
		}
	})
	$('.filters li a').click(function(e) {
		$('.filters li a').removeClass('selected');
		var dom = e.target;
		dom.classList.add('selected');
		if(dom.text == "All") showAll();
		else if(dom.text == "Active") showActive();
		else if(dom.text == "Completed") showCompleted();
		console.log(dom.text);
	})
	function showAll() {
		console.log("@@");
		$('#todo-list li').show();
	}
	function showActive() {
		$('#todo-list li').show();
		$('#todo-list .completed').hide();
	}
	function showCompleted() {
		$('#todo-list li').hide();
		$('#todo-list .completed').show();
	}

})(window);
