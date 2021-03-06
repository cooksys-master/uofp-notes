import React from 'react';
import Todo from './Todo';
import './App.css';

function App() {
  const [todos, setTodos] = React.useState([]);
  const [inputText, setInputText] = React.useState('');

  React.useEffect(() => {
    fetch('http://localhost:8080/todos/')
      .then(response => response.json())
      .then(data => setTodos(data));
  }, []);

  const handleCreateTodo = keyPressEvent => {
    if (keyPressEvent.key === 'Enter') {
      fetch(`http://localhost:8080/todos/?message=${inputText}`, {
        method: 'POST'
      })
        .then(response => response.json())
        .then(newTodo => setTodos([...todos, newTodo]));
      setInputText('');
    }
  };

  const handleToggleTodo = todo => {
    const todoUpdate = { message: todo.message, completed: !todo.completed };
    fetch(`http://localhost:8080/todos/${todo.id}`, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(todoUpdate)
    })
      .then(response => response.json())
      .then(updatedTodo =>
        setTodos(
          todos.map(todo => (todo.id === updatedTodo.id ? updatedTodo : todo))
        )
      );
  };

  const handleDelete = id => {
    fetch(`http://localhost:8080/todos/${id}`, {
      method: 'DELETE'
    })
      .then(response => response.json())
      .then(deletedTodo =>
        setTodos(todos.filter(todo => todo.id !== deletedTodo.id))
      );
  };

  return (
    <div className="TodoApp">
      <h1 className="Header">todos</h1>
      <div className="TodoList">
        <input
          className="NewTodo"
          type="text"
          value={inputText}
          onChange={event => {
            setInputText(event.target.value);
          }}
          onKeyPress={handleCreateTodo}
        />
        {todos.map(todo =>
          <Todo
            key={todo.id}
            todo={todo}
            handleToggleTodo={handleToggleTodo}
            handleDelete={handleDelete}
          />
        )}
      </div>
    </div>
  );
}

export default App;
