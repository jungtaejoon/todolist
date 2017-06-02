package kr.or.connect.todo.domain;

import java.sql.Timestamp;

public class Todo {

	private Integer id;

	private String todo;

	private boolean completed;
	
	private Timestamp date;

	public Todo() {
	}

	public Todo(String todo) {
		this.todo = todo;
		this.completed = false;
		this.date = new Timestamp(System.currentTimeMillis());
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public Todo(Integer id, String todo, boolean completed) {
		this(todo);
		this.id = id;
		this.completed = completed;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTodo() {
		return todo;
	}

	public void setTodo(String todo) {
		this.todo = todo;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public String toString() {
		return "id = " + this.id + ", todo = " + this.todo + ", completed = "
	+ this.completed + ", date = " + date;
	}
}
