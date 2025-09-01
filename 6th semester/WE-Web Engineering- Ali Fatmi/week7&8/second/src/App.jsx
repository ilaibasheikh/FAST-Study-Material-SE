

function App() {
  
return <p>this somethign new sdasd</p>;
  
}

export default App


const UserComponent = ({ role }) => {
    switch (role) {
      case 'admin':
        return <AdminComponent />;
      case 'moderator':
        return <ModeratorComponent />;
      default:
        return <GuestComponent />;
    }
  };
  

  const UserProfile = ({ isAdmin }) => {
    return (
      <div>
        <h1>Welcome, User!</h1>
        {isAdmin && <button>Admin Panel</button>}
      </div>
    );
  };
  