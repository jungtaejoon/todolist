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
  for(let i of completedTodos) {
    h += '<li class="completed">';
    h += '<div class="view">';
    h += '<input type="hidden" name="id" value="' + i.id + '">';
    h += '<input class="toggle" type="checkbox" checked>';
    h += '<label>' + i.todo + '</label>';
    h += '<button class="destroy"></button>';
    h += '</div>';
    h += '<input class="edit" value="Create a TodoMVC template">';
    h += '</li>';
  }
  for(let i of yet) {
    h += '<li>';
    h += '<div class="view">';
    h += '<input type="hidden" name="id" value="' + i.id + '">';
    h += '<input class="toggle" type="checkbox">';
    h += '<label>' + i.todo + '</label>';
    h += '<button class="destroy"></button>';
    h += '</div>';
    h += '<input class="edit" value="Create a TodoMVC template">';
    h += '</li>';
  }
  $('#todo-list').html(h);
}
function findAll() {
  var arg = {method:'get', func:setAll}
  allAjax(arg);
}
