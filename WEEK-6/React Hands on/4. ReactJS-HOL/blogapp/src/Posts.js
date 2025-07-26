import React from 'react';
import Post from './Post';

class Posts extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
      error: null
    };
  }

  loadPosts() {
    fetch('https://jsonplaceholder.typicode.com/posts')
      .then((response) => response.json())
      .then((data) => {
        const postsArray = data.map(p => new Post(p.id, p.title, p.body));
        this.setState({ posts: postsArray });
      })
      .catch((error) => {
        this.setState({ error });
      });
  }

  componentDidMount() {
    this.loadPosts();
  }

  componentDidCatch(error, info) {
    alert("An error occurred in Posts component.");
    console.error("Error caught:", error, info);
  }

  render() {
    return (
      <div>
        <h2>Blog Posts</h2>
        {this.state.posts.length > 0 ? (
          this.state.posts.map((post) => (
            <div key={post.id}>
              <h3>{post.title}</h3>
              <p>{post.body}</p>
              <hr />
            </div>
          ))
        ) : (
          <p>Loading posts...</p>
        )}
      </div>
    );
  }
}

export default Posts;
