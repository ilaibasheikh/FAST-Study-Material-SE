
function Renobj(){

  const users = [
    { id: 1, name: "John Doe", age: 28 },
    { id: 2, name: "Jane Smith", age: 22 },
    { id: 3, name: "Mike Johnson", age: 35 }
  ];
  const User = ({ name, age }) => {
    return (
      <div>
        <h3>{name}</h3>
        <p>Age: {age}</p>
      </div>
    );
  };

  return (
    <div>
      <h2>User List</h2>
      {users.map(user => (
        <User key={user.id} name={user.name} age={user.age} />
      ))}
    </div>
  );
}

export default Renobj;
