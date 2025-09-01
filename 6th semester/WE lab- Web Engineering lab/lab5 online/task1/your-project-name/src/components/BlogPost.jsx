import React from 'react';
import { useParams } from 'react-router-dom';

function BlogPost() {
  const { id } = useParams();
  
  const posts = [
    { id: 1, title: 'How to Learn React', content: 'This is the full article on how to learn React. React is a powerful JavaScript library for building user interfaces...', image: 'blog-image.jpg' },
    { id: 2, title: 'JavaScript Best Practices', content: 'This article discusses JavaScript best practices, including how to write clean, efficient, and maintainable code...', image: 'blog-image.jpg' },
    { id: 3, title: 'CSS Grid vs Flexbox', content: 'In this article, we will compare Flexbox and CSS Grid. Both are powerful tools, but knowing when to use each can make a big difference...', image: 'blog-image.jpg' },
  ];

  const post = posts.find((post) => post.id === parseInt(id));

  return (
    <div className="blog-post">
      {post ? (
        <>
          <h2>{post.title}</h2>
          <img src={`assets/${post.image}`} alt={post.title} />
          <p>{post.content}</p>
        </>
      ) : (
        <p>Post not found!</p>
      )}
    </div>
  );
}

export default BlogPost;
