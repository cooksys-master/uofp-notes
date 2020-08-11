package com.cooksys.todows.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.cooksys.todows.dtos.TodoDto;
import com.cooksys.todows.entities.Todo;
import com.cooksys.todows.exceptions.TodoNotFoundException;
import com.cooksys.todows.repositories.TodoRepository;

@Service
public class TodoService {
	
	private TodoRepository todoRepo;
	
	public TodoService(TodoRepository todoRepo) {
		super();
		this.todoRepo = todoRepo;
	}
	
	public Todo getTodoById(Integer id) {
		Optional<Todo> optionalTodo  = todoRepo.findById(id);
		if (optionalTodo.isEmpty() || optionalTodo.get().getDeleted()) {
			throw new TodoNotFoundException("Couldn't find todo with id " + id);
		} else {
			return optionalTodo.get();
		}
	}
	
	public List<Todo> getAllTodos() {
		return todoRepo.findAllByDeletedFalse();
	}

	public Todo createNewTodo(String message) {
		Todo todo = new Todo(message); // default todo initialization logic
		return todoRepo.save(todo);
	}

	public Todo updateTodo(Todo updatedTodo) {
		Todo todoToUpdate = getTodoById(updatedTodo.getId());
		todoToUpdate.setMessage(updatedTodo.getMessage());
		todoToUpdate.setCompleted(updatedTodo.getCompleted());
		return todoRepo.save(todoToUpdate);
	}

	public Todo deleteTodo(Integer id) {
		Todo deleted = getTodoById(id);
		deleted.setDeleted(true);
		todoRepo.save(deleted);
		return deleted;
	}

	public List<Todo> deleteCompletedTodos() {
		List<Todo> deleted = 
				todoRepo
					.findAllByCompletedTrue()
					.stream()
					.filter(todo -> !todo.getDeleted())
					.map(todo -> {
						todo.setDeleted(true);
						return todo;
					})
					.collect(Collectors.toList());
		
		todoRepo.saveAll(deleted);
		return deleted;
	}
}
