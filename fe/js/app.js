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
	var filterText;
	$('.filters li a').click(function(e) {
		$('.filters li a').removeClass('selected');
		var dom = e.target;
		dom.classList.add('selected');
		filterText = dom.text;
		doFilter();
	})
	function doFilter() {
		if(filterText == "All") showAll();
		else if(filterText == "Active") showActive();
		else if(filterText == "Completed") showCompleted();
	}
	function getRule(rule) {
		var sheets = document.styleSheets;
		for(let i of sheets) {
			for(let ii of i.cssRules) {
				if(ii.selectorText == rule) {
					return ii;
				}
			}
		}
	}

	var liRule = getRule('.todo-list li');
	var completedRule = getRule('.todo-list .completed');
	function showAll() {
		liRule.style.display = 'block';
		completedRule.style.display = 'block';
	}
	function showActive() {
		liRule.style.display = 'block';
		completedRule.style.display = 'none';
	}
	function showCompleted() {
		liRule.style.display = 'none';
		completedRule.style.display = 'block';
	}

})(window);
