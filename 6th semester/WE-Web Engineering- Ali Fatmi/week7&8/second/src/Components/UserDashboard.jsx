
const UserDashboard = ({ user }) => {
  let content;

  if (user.isLoading) {
    content = <p>Loading...</p>;
  } else if (user.isAdmin) {
    content = <p>Welcome, Admin! Here's your dashboard.</p>;
  } else if (user.isLoggedIn) {
    content = <p>Welcome back, {user.name}!</p>;
  } else {
    content = <p>Please log in to access the dashboard.</p>;
  }

  return (
    <div>
      {content}
    </div>
  );
};

export default UserDashboard;
