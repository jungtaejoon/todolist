package kr.or.connect.todo.persistence;

public class TodoSqls {
	static final String DELETE_BY_ID = "DELETE FROM todo WHERE id= :id";
	static final String SELECT_ALL = "SELECT * FROM todo";
	static final String UPDATE = "UPDATE todo SET isChecked = :isCheked WHERE id = :id";
}
