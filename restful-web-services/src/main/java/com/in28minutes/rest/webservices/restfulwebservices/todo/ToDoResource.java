package com.in28minutes.rest.webservices.restfulwebservices.todo;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ToDoResource {

	@Autowired
	private TodoHardcodedService todoService;

	@GetMapping(path = "/users/{username}/todos")
	public List<ToDo> getAllTodos(@PathVariable String username) {
		return todoService.findAll();
	}

	// Used to get one ToDo for update page
	@GetMapping(path = "/users/{username}/todos/{id}")
	public ToDo getTodo(@PathVariable String username, @PathVariable long id) {
		return todoService.findById(id);
	}

	@PutMapping("/users/{username}/todos/{id}")
	// Response entity allows us to send back a result to client. Here we will send
	// back a ToDo that was updated
	public ResponseEntity<ToDo> updateTodo(@PathVariable String username, @PathVariable long id,
			@RequestBody ToDo todo) {
		ToDo todoUpdated = todoService.save(todo);
		return new ResponseEntity<ToDo>(todo, HttpStatus.OK);
	}

	@PostMapping("/users/{username}/todos/")
	public ResponseEntity<Void> updateTodo(@PathVariable String username, @RequestBody ToDo todo){
		ToDo createdTodo = todoService.save(todo);
		
		// Want to send back the location, so we append the id to the end of the current (request path)
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
		
	}

	@DeleteMapping("/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id) {
		// call the service method to delete by id
		ToDo todo = todoService.deleteById(id);
		if (todo != null) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}

	}

}
