package kr.or.connect.todo.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import kr.or.connect.todo.domain.Todo;
import kr.or.connect.todo.persistence.TodoDao;

@Service
public class TodoService {
	
	private TodoDao dao;
	
	public TodoService(TodoDao dao) {
		this.dao = dao;
	}

	public Collection<Todo> findAll() {
		return dao.selectAll();
	}

	public Todo create(Todo todo) {
		dao.insert(todo);
		return todo;
	}

	public boolean update(Todo todo) {
		todo.setChecked(!todo.isChecked());
		int affected = dao.update(todo);
		return affected == 1;
	}

	public boolean delete(Integer id) {
		int affected = dao.deleteById(id);
		return affected == 1;
	}

}
