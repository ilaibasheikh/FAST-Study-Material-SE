import * as React from "react";
import { useState } from "react";

const App = () => {
  const [todos, setTodos] = useState([]);  
  const [newTodo, setNewTodo] = useState(''); 

  const addTodo = () => {
    if (newTodo.trim() !== '') {
      setTodos([...todos, newTodo]);
      setNewTodo('');
    }
  };

  const handleInputChange = (e) => {  
    setNewTodo(e.target.value);
  };

  return (
    <div>
      <h1>Todo List</h1>
      <input 
        type="text" 
        value={newTodo} 
        onChange={handleInputChange} 
        placeholder="Enter a new todo" 
      />
      <button onClick={addTodo}>Add Todo</button>
      <ul>
        {todos.map((todo, index) => (
          <li key={index}>{todo}</li>
        ))}
      </ul>
    </div>
  );
};

export default App