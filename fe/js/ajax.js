function allAjax(arg) {
  var url = 'http://localhost:8080/api/todos/';
  var sync = true;
  function func() {};
  if(arg.arg) url += arg.arg;
  if(arg.func) func = arg.func;
  if(!arg.asyn) sync = arg.asyn;
  $.ajax({
    method : arg.method,
    data : arg.data,
    async : sync,
    contentType : 'application/json; charset=utf-8',
    dataType : 'json',
    url : url,
    success : function(response) {
      func(response);
    }
  })
}
