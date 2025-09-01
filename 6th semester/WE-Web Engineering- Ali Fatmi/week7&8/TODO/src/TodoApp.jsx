import React, { useState } from 'react';
import './TodoApp.css'; // Import CSS

function TodoApp() {
  const [tasks, setTasks] = useState([]);
  const [taskName, setTaskName] = useState('');
  const [editIndex, setEditIndex] = useState(null);

  // Handle input change for task name
  const handleChange = (event) => {
    setTaskName(event.target.value);
  };

  // Add or Update task
  const handleAddUpdateTask = () => {
    if (taskName.trim() === '') return; // Don't allow empty task names
    if (editIndex !== null) {
      // Update task
      const updatedTasks = tasks.map((task, index) =>
        index === editIndex ? { ...task, name: taskName } : task
      );
      setTasks(updatedTasks);
      setEditIndex(null);
    } else {
      // Add new task
      setTasks([...tasks, { name: taskName, isComplete: false }]);
    }
    setTaskName('');
  };

  // Edit task
  const handleEditTask = (index) => {
    setTaskName(tasks[index].name);
    setEditIndex(index);
  };

  // Delete task
  const handleDeleteTask = (index) => {
    const filteredTasks = tasks.filter((_, i) => i !== index);
    setTasks(filteredTasks);
  };

  // Mark task as complete
  const handleCompleteTask = (index) => {
    const updatedTasks = tasks.map((task, i) =>
      i === index ? { ...task, isComplete: !task.isComplete } : task
    );
    setTasks(updatedTasks);
  };

  // Sort tasks by name
  const handleSortByName = () => {
    const sortedTasks = [...tasks].sort((a, b) =>
      a.name.localeCompare(b.name)
    );
    setTasks(sortedTasks);
  };

  // Calculate completed and incomplete tasks
  const completedTasks = tasks.filter(task => task.isComplete).length;
  const incompleteTasks = tasks.length - completedTasks;

  return (
    <div className="todo-app">
      <h1>Todo List</h1>
      <div className="task-input">
        <input
          type="text"
          placeholder="Enter task"
          value={taskName}
          onChange={handleChange}
        />
        <button onClick={handleAddUpdateTask}>
          {editIndex !== null ? 'Update Task' : 'Add Task'}
        </button>
      </div>
      <div className="task-actions">
        <button onClick={handleSortByName}>Sort by Name</button>
      </div>

      {/* Display task statistics */}
      <div className="task-stats">
        <p>Total Completed: {completedTasks}</p>
        <p>Total Incomplete: {incompleteTasks}</p>
      </div>

      <ul className="task-list">
        {tasks.map((task, index) => (
          <li key={index} className="task-item">
            <span
              className={task.isComplete ? 'completed' : ''}
              onClick={() => handleCompleteTask(index)}
            >
              {task.name}
            </span>
            <div className="task-buttons">
              <button onClick={() => handleEditTask(index)}>Edit</button>
              <button onClick={() => handleDeleteTask(index)}>Delete</button>
            </div>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default TodoApp;
