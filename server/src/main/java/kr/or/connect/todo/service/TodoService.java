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

	public Collection<Todo> create(Todo todo) {
		dao.insert(todo);
		return findAll();
	}

	public Collection<Todo> update(Todo todo) {
		dao.update(todo);
		return findAll();
	}

	public Collection<Todo> delete(Integer id) {
		dao.deleteById(id);
		return findAll();
	}

}
