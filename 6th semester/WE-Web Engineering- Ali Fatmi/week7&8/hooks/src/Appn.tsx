import React, { useState } from "react";
import { useForm, Controller } from "react-hook-form";

const Appn = () => {
  const { handleSubmit, control, reset } = useForm();
  const [phoneNumbers, setPhoneNumbers] = useState([{ number: "" }]);

  // Function to add new phone number field
  const addPhoneNumber = () => {
    setPhoneNumbers([...phoneNumbers, { number: "" }]);
  };

  // Function to remove a phone number field by index
  const removePhoneNumber = (index) => {
    const updatedPhoneNumbers = phoneNumbers.filter((_, i) => i !== index);
    setPhoneNumbers(updatedPhoneNumbers);
  };

  // Submit handler
  const onSubmit = (data) => {
    console.log("Form Data:", data);
    reset();
  };

  return (
    <form onSubmit={handleSubmit(onSubmit)}>
      <h2>Phone Numbers</h2>

      {phoneNumbers.map((phoneNumber, index) => (
        <div key={index} style={{ marginBottom: "10px" }}>
          <Controller
            name={`phoneNumbers[${index}].number`}
            control={control}
            defaultValue={phoneNumber.number}
            render={({ field }) => (
              <input
                {...field}
                placeholder={`Phone Number ${index + 1}`}
                style={{ marginRight: "10px" }}
              />
            )}
          />

          <button
            type="button"
            onClick={() => removePhoneNumber(index)}
            style={{
              backgroundColor: "red",
              color: "white",
              border: "none",
              padding: "5px 10px",
              cursor: "pointer",
            }}
          >
            Remove
          </button>
        </div>
      ))}

      <button
        type="button"
        onClick={addPhoneNumber}
        style={{
          backgroundColor: "green",
          color: "white",
          border: "none",
          padding: "5px 10px",
          cursor: "pointer",
        }}
      >
        Add More
      </button>

      <br />
      <br />

      <button type="submit" style={{ padding: "10px 20px" }}>
        Submit
      </button>
    </form>
  );
};

export default Appn;
