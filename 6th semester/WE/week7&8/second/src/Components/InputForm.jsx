import React, { useState } from 'react';

const InputForm = () => {
  const [inputValue, setInputValue] = useState('');
  const [submittedValue, setSubmittedValue] = useState('');

  // Handles input change
  const handleInputChange = (event) => {
    setInputValue(event.target.value);
  };

  // Handles button click
  const handleClick = () => {
    setSubmittedValue(inputValue);
  };

  return (
    <div>
      <label>
        Enter Text:
        <input type="text" value={inputValue} onChange={handleInputChange} />
      </label>
      {/* Button to trigger value submission */}
      <button type="button" onClick={handleClick}>Submit</button>

      {/* Display the submitted value */}
      <div>
        <h3>Submitted Value:</h3>
        <p>{submittedValue}</p>
      </div>
    </div>
  );
};

export default InputForm;
