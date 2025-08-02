function BlogDetails({ blogs }) {
  return (
    <ul>
      {blogs.map((blog) => (
        <div key={blog.id}>
          <h2>{blog.title}</h2>
          <h4>{blog.author}</h4>
          <p>{blog.content}</p>
        </div>
      ))}
    </ul>
  );
}
export default BlogDetails;
