function CourseDetails({ courses }) {
  return (
    <ul>
      {courses.map((course) => (
        <div key={course.id}>
          <h2>{course.name}</h2>
          <h4>{course.date}</h4>
        </div>
      ))}
    </ul>
  );
}
export default CourseDetails;
