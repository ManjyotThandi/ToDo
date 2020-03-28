package com.in28minutes.rest.webservices.restfulwebservices.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoHardcodedService {
	private static List<ToDo> todos = new ArrayList<ToDo>();
	private static int idCounter = 0;
	
	static {
		todos.add(new ToDo(idCounter++, "Manjyot", "Get Rich", new Date(), false));
		todos.add(new ToDo(idCounter++, "Manjyot", "Get Jacked", new Date(), false));
		todos.add(new ToDo(idCounter++, "Manjyot", "Take Roids", new Date(), false));
		todos.add(new ToDo(idCounter++, "Manjyot", "Go Back to Miami", new Date(), false));
		todos.add(new ToDo(idCounter++, "Manjyot", "Go to Cali", new Date(), false));
	}
	
	public List<ToDo> findAll(){
		return todos;
	}
	
	public ToDo deleteById(long id) {
		ToDo todo = findById(id);
		if(todo == null) {
			return null;
		}
		else {
			todos.remove((todo));
		}
		// return back to ToDo which was deleted
		return todo;
	}

	public ToDo findById(long id) {
		for(ToDo todo : todos) {
			if(todo.getId() == id) {
				return todo;
			}
		}
		return null;
	}
	
	public ToDo save(ToDo todo) {
		if(todo.getId() == -1 || todo.getId() == 0) {
			// Used for JPA, means that this ToDo is a new entry. Save it. Since we are using a list, add it to the list
			todo.setId(++idCounter);
			todos.add(todo);
		} else {
			// Since this is a list, in order to update, just delete the existing entry and create a new one
			deleteById(todo.getId());
			todos.add(todo);
			
		}
		return todo;
	}
}
