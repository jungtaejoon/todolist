package kr.or.connect.todo.api;

import java.sql.Timestamp;
import java.util.ArrayList;
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
	public Collection<Todo> create(@RequestBody Todo todo) {
		todo.setDate(new Timestamp(System.currentTimeMillis()));
		return service.create(todo);
	}

	@PutMapping("{id}")
	public Collection<Todo> update(@PathVariable Integer id, @RequestBody Todo todo) {
		todo.setId(id);
		return service.update(todo);
	}

	@DeleteMapping("{id}")
	public Collection<Todo> delete(@PathVariable Integer id) {
		return service.delete(id);
	}

	@DeleteMapping
	public Collection<Todo> deleteTodos(@RequestBody ArrayList<Integer> ids) {
		for (Integer id : ids) {
			service.delete(id);
		}
		return service.findAll();
	}

}
