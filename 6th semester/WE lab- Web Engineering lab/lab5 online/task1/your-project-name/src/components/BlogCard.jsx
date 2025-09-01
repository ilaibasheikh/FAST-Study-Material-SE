import React, { useState } from "react";
import "./App.css";

// Sample Blog Post Data (You can expand or update this later)
const initialPosts = [
  {
    id: 1,
    title: "My First Blog Post",
    content: "This is the content of my first blog post. Welcome to my blog!",
    author: "John Doe",
  },
  {
    id: 2,
    title: "React Basics",
    content: "Learn the basics of React, including components, hooks, and state management.",
    author: "Jane Smith",
  },
  {
    id: 3,
    title: "Exploring JavaScript",
    content: "In this post, we will dive deep into the world of JavaScript and its features.",
    author: "Alice Johnson",
  },
];

const App = () => {
  const [posts, setPosts] = useState(initialPosts);

  // Function to add a new post (optional feature)
  const addPost = () => {
    const newPost = {
      id: posts.length + 1,
      title: "New Post",
      content: "This is a new post added dynamically.",
      author: "New Author",
    };
    setPosts([...posts, newPost]);
  };

  return (
    <div className="App">
      <header>
        <h1>My Simple Blog</h1>
      </header>

      <main>
        <button onClick={addPost} className="addPostBtn">Add New Post</button>

        <div className="blog-list">
          {posts.map((post) => (
            <div key={post.id} className="blog-post">
              <h2>{post.title}</h2>
              <p className="content">{post.content}</p>
              <p className="author">Written by {post.author}</p>
            </div>
          ))}
        </div>
      </main>
    </div>
  );
};

export default App;