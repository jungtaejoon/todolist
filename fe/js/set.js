function setAll(response) {
  if(response.length > 1) {
    response.sort(function(a, b) {
      return b['date'] - a['date'];
    });
  }
  var completedTodos = new Array();
  var yet = new Array();
  for(let i of response) {
    if(i.completed) completedTodos.push(i);
    else yet.push(i);
  }
  var h = "";
  for(let i of yet) {
    h += '<li>';
    h += '<div class="view">';
    h += '<input class="toggle" onclick="doCheck(this, ' + i.id + ')" type="checkbox">';
    h += '<label>' + i.todo + '</label>';
    h += '<button class="destroy" onclick="destroy(' + i.id + ')"></button>';
    h += '</div>';
    h += '</li>';
  }
  for(let i of completedTodos) {
    h += '<li class="completed">';
    h += '<div class="view">';
    h += '<input class="toggle" onclick="doCheck(this, ' + i.id + ')" type="checkbox" checked>';
    h += '<label>' + i.todo + '</label>';
    h += '<button class="destroy" onclick="destroy(' + i.id + ')"></button>';
    h += '</div>';
    h += '</li>';
  }
  $('#yet').text(yet.length);
  $('#todo-list').html(h);
}
function doCheck(dom, id) {
  var completed = dom.checked ? true : false;
  var obj = {"completed":completed};
  var todoJSON = JSON.stringify(obj);
  var arg = {method:'put', arg:id, data:todoJSON, func:setAll};
  allAjax(arg);
}
function destroy(id) {
  var arg = {method:'delete', arg:id, func:setAll};
  allAjax(arg);
}
function findAll() {
  var arg = {method:'get', func:setAll};
  allAjax(arg);
}
