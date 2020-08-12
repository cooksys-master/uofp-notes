import React from 'react';

const Todo = ({ todo, handleToggleTodo, handleDelete }) => {
  const [hover, setHover] = React.useState(false);

  return (
    <div
      className="Todo"
      onMouseEnter={() => setHover(true)}
      onMouseLeave={() => setHover(false)}
    >
      <div className="TodoCheckBox">
        <input
          id={`checkbox${todo.id}`}
          type="checkbox"
          checked={todo.completed}
          onChange={() => handleToggleTodo(todo)}
        />
        <label htmlFor={`checkbox${todo.id}`} />
      </div>
      <label className={`TodoMessage ${todo.completed ? 'complete' : ''}`}>
        {todo.message}
      </label>
      {hover
        ? <button onClick={() => handleDelete(todo.id)}>X</button>
        : undefined}
    </div>
  );
};

export default Todo;
