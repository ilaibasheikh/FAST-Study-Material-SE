import React from "react";

const Navbar = ({ setPage }) => {
  return (
    <nav className="bg-gray-800 text-white p-4 flex justify-center space-x-4">
      <button onClick={() => setPage("home")} className="hover:underline">Home</button>
      <button onClick={() => setPage("about")} className="hover:underline">About</button>
      <button onClick={() => setPage("contact")} className="hover:underline">Contact</button>
    </nav>
  );
};

export default Navbar;
