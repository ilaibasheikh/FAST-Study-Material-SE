import React, { useState } from 'react';

function MultiInputForm() {
  // Define state for all form inputs
  const [formData, setFormData] = useState({
    name: '',
    email: '',
    password: ''
  });

  // Define state to hold submitted data for display
  const [submittedData, setSubmittedData] = useState(null);

  // Generic change handler
  const handleChange = (event) => {
    const { name, value } = event.target;
    // Dynamically update state based on input's name
    setFormData({
      ...formData,
      [name]: value
    });
  };

  // Handle form submission
  const handleSubmit = (event) => {
    event.preventDefault();
    // Set the submitted data to display in a single div
    setSubmittedData(formData);
    // Optionally, clear the form fields after submission
    setFormData({
      name: '',
      email: '',
      password: ''
    });
  };

  return (
    <div>
      <form onSubmit={handleSubmit}>
        <div>
          <label>
            Name:
            <input
              type="text"
              name="name"
              value={formData.name}
              onChange={handleChange}
            />
          </label>
        </div>
        <div>
          <label>
            Email:
            <input
              type="email"
              name="email"
              value={formData.email}
              onChange={handleChange}
            />
          </label>
        </div>
        <div>
          <label>
            Password:
            <input
              type="password"
              name="password"
              value={formData.password}
              onChange={handleChange}
            />
          </label>
        </div>
        <button type="submit">Submit</button>
      </form>

      {/* Display submitted data inside a single div */}
      {submittedData && (
        <div className="submitted-data">
          <h3>Submitted Data:</h3>
          <p><strong>Name:</strong> {submittedData.name}</p>
          <p><strong>Email:</strong> {submittedData.email}</p>
          <p><strong>Password:</strong> {submittedData.password}</p>
        </div>
      )}
    </div>
  );
}

export default MultiInputForm;
