package kr.or.connect.todo.domain;


public class Todo {
	private Integer id;
	private String task;
	private Boolean isChecked;
	
	public Todo() {}
	public Todo(String task) {
		this.task = task;
		this.isChecked = false;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public Boolean getIsChecked() {
		return isChecked;
	}
	public void setIsChecked(Boolean isChecked) {
		this.isChecked = isChecked;
	}
	
}
