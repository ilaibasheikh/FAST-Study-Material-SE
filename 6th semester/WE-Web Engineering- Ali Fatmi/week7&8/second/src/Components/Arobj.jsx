function Arobj(){


  const users = [
    { id: 1, name: "John Doe", age: 28 },
    { id: 2, name: "Jane Smith", age: 22 },
    { id: 3, name: "Mike Johnson", age: 35 }
  ];

  return (
    <div>
      <h2>User List</h2>
      <ul>
        {users.map(user => (
          <li key={user.id}>
            Name: {user.name}, Age: {user.age}
          </li>
        ))}
      </ul>
    </div>
  );
};





export default Arobj;