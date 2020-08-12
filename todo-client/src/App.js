import React from 'react';
import './App.css';

function App() {
  const [todos, setTodos] = React.useState([]);

  React.useEffect(() => {
    fetch('http://localhost:8080/todos/')
      .then(response => response.json())
      .then(data => setTodos(data));
  }, []);

  return (
    <div className="TodoApp">
      <h1 className="Header">todos</h1>
      <input type="text" onClick={() => alert('hi')} />
      <div className="TodoList">
        {todos.map(todo =>
          <p key={todo.id}>
            {todo.message}
          </p>
        )}
      </div>
    </div>
  );
}

export default App;
