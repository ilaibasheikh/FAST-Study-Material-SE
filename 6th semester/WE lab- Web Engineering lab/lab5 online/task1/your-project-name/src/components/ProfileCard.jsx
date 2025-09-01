import React from "react";
import "./ProfileCard.css";

const ProfileCard = ({ name, email, phone }) => {
  return (
    <div className="profile-card">
      <h2>{name}</h2>
      <p>Email: {email}</p>
      <p>Phone: {phone}</p>
    </div>
  );
};

export default ProfileCard;
