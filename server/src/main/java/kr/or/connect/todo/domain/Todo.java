package kr.or.connect.todo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "todo" )
public class Todo {
	
	@Id
    @Column( name = "id" )
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column
	private String task;
	
	@Column
	private boolean checked;
	
	public Todo() {}
	public Todo(String task) {
		this.task = task;
		this.checked = false;
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
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	

}
