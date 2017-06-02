package kr.or.connect.todo.persistence;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.todo.domain.Todo;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TodoDaoTest {

	@Autowired
	private TodoDao dao;

	@Test
	public void shouldInsertAndSelect() {
		Todo todo = new Todo("장보기");

		Integer id = dao.insert(todo);

		Todo selected = dao.selectById(id);
		System.out.println(selected);
		assertThat(selected.getTodo(), is("장보기"));
	}

	@Test
	public void shouldSelectAll() {
		Collection<Todo> allTodo = dao.selectAll();
		assertThat(allTodo, is(notNullValue()));
	}

	@Test
	public void shouldUpdate() {
		Todo todo = new Todo("장보기");
		Integer id = dao.insert(todo);

		todo.setId(id);
		todo.setCompleted(true);
		int affected = dao.update(todo);

		assertThat(affected, is(1));
		Todo updated = dao.selectById(id);
		assertThat(updated.isCompleted(), is(true));
	}

	@Test
	public void shouldDelete() {
		Todo todo = new Todo("장보기");
		Integer id = dao.insert(todo);

		int affected = dao.deleteById(id);

		assertThat(affected, is(1));
	}

}
