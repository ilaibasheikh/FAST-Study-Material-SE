
const UserStatus = ({ isLoggedIn }) => {
  if (isLoggedIn) {
    return <h1>Welcome, User!</h1>;
  } else {
    return <h1>Please log in</h1>;
  }
};

export default UserStatus;
