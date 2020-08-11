package com.cooksys.todows.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cooksys.todows.entities.Todo;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Integer> {
	
	List<Todo> findAllByDeletedFalse();

	List<Todo> findAllByCompletedTrue();

}
