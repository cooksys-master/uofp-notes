package com.cooksys.todows.mappers;

import org.mapstruct.Mapper;

import com.cooksys.todows.dtos.TodoDto;
import com.cooksys.todows.entities.Todo;

@Mapper(componentModel = "spring")
public interface TodoMapper {
	
	TodoDto todoToDto(Todo todo);
	
	Todo dtoToTodo(TodoDto dto);

}
