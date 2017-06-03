function allAjax(arg) {
  var url = 'http://localhost:8080/api/todos';
  function func() {};
  if(arg.arg) url += arg.arg;
  if(arg.func) func = arg.func;
  $.ajax({
    method : arg.method,
    data : arg.data,
    contentType : 'application/json; charset=utf-8',
    dataType : 'json',
    url : url,
    success : function(response) {
      console.log(response);
      func(response);
    }
  })
}
