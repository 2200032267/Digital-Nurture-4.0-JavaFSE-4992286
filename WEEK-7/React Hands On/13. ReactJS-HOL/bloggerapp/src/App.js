import { useState } from 'react';
import './App.css';

import BookDetails from './components/BookDetails';
import BlogDetails from './components/BlogDetails';
import CourseDetails from './components/CourseDetails';

import { books } from './data/books';
import { blogs } from './data/blogs';
import { courses } from './data/courses';

function App() {
  const [showBooks, setShowBooks] = useState(true);
  const [showBlogs, setShowBlogs] = useState(true);
  const [showCourses, setShowCourses] = useState(true);

  const renderSection = (type) => {
    if (type === 'books' && showBooks) return <BookDetails books={books} />;
    else if (type === 'blogs') return showBlogs ? <BlogDetails blogs={blogs} /> : <p>No blogs to show</p>;
    else if (type === 'courses') return showCourses && <CourseDetails courses={courses} />;
    return null;
  };

  return (
    <div className="App">
      <div className="controls">
        <button onClick={() => setShowCourses(!showCourses)}>Toggle Courses</button>
        <button onClick={() => setShowBooks(!showBooks)}>Toggle Books</button>
        <button onClick={() => setShowBlogs(!showBlogs)}>Toggle Blogs</button>
      </div>

      <div className="container">
        <div className="mystyle1">
          <h1>Course Details</h1>
          {renderSection("courses")}
        </div>

        <div className="st2">
          <h1>Book Details</h1>
          {renderSection("books")}
        </div>

        <div className="v1">
          <h1>Blog Details</h1>
          {renderSection("blogs")}
        </div>
      </div>
    </div>
  );
}
export default App;
