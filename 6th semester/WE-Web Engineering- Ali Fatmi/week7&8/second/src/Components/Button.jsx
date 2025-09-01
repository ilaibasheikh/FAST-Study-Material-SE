import React from 'react';

const Button = () => {
  const handleClick = () => {
    alert('Button clicked!');
  };

  return (
    <button onClick={handleClick}>
      Click me
    </button>
  );
};

export default Button;
