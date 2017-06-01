package kr.or.connect.todo.api;

import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.todo.domain.Todo;
import kr.or.connect.todo.service.TodoService;

@RestController
@RequestMapping("/api/todos")
public class TodoController {
	
	private TodoService service;
	
	TodoController(TodoService service) {
		this.service = service;
	}
	
	@GetMapping
	public Collection<Todo> readList() {
		return service.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Todo create(@RequestBody Todo todo) {
		return service.create(todo);
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public boolean update(@RequestBody Todo todo) {
		return service.update(todo);
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public boolean delete(@PathVariable Integer id) {
		return service.delete(id);
	}

}
