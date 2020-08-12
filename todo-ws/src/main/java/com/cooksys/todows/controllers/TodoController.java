package com.cooksys.todows.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.*;

import com.cooksys.todows.dtos.TodoDto;
import com.cooksys.todows.mappers.TodoMapper;
import com.cooksys.todows.services.TodoService;

@RestController
@CrossOrigin(origins = "*")
public class TodoController {

	private TodoService todoService;
	private TodoMapper todoMapper;

	public TodoController(TodoService todoService, TodoMapper todoMapper) {
		super();
		this.todoService = todoService;
		this.todoMapper = todoMapper;
	}

//	get all todos
//	GET /todos/ :: () -> List<Todo>
	@GetMapping("/todos/")
	public List<TodoDto> getAllTodos() {
		return todoService
				.getAllTodos()
				.stream()
				.map(todoMapper::todoToDto)
				.collect(Collectors.toList());
	}

//	create a new todo
//	POST /todos/ :: string -> Todo
	@PostMapping("/todos/")
	public TodoDto createNewTodo(@RequestParam String message) {
		return todoMapper.todoToDto(todoService.createNewTodo(message));
	}

//	update completed status of todo
//	PUT /todos/{id} :: Todo -> Todo
	@PutMapping("/todos/{id}")
	public TodoDto updateTodo(@RequestBody TodoDto updatedTodo, @PathVariable Integer id) {
		updatedTodo.setId(id);
		return todoMapper.todoToDto(todoService.updateTodo(todoMapper.dtoToTodo(updatedTodo)));
	}

//	delete an individual todo
//	DELETE /todos/{id} :: () -> Todo
	@DeleteMapping("/todos/{id}")
	public TodoDto deleteTodo(@PathVariable Integer id) {
		return todoMapper.todoToDto(todoService.deleteTodo(id));
	}

//	delete all completed todos
//	DELETE /todos/completed :: () -> List<Todo>
	@DeleteMapping("/todos/completed")
	public List<TodoDto> deleteCompletedTodos() {
		return todoService
					.deleteCompletedTodos()
					.stream()
					.map(todoMapper::todoToDto)
					.collect(Collectors.toList());
	}

}
