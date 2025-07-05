package com.example.ormdemo;

import com.example.ormdemo.model.*;
import com.example.ormdemo.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class RelationshipRunner implements CommandLineRunner {

    private final AuthorRepository authorRepo;
    private final BookRepository bookRepo;
    private final StudentRepository studentRepo;
    private final CourseRepository courseRepo;

    public RelationshipRunner(AuthorRepository authorRepo, BookRepository bookRepo,
                               StudentRepository studentRepo, CourseRepository courseRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
        this.studentRepo = studentRepo;
        this.courseRepo = courseRepo;
    }

    @Override
    @Transactional
    public void run(String... args) {
        System.out.println("--- DEMO: One-to-Many (Author -> Book) ---");

        Author author = new Author("J.R.R. Tolkien");
        Book book1 = new Book("The Hobbit");
        Book book2 = new Book("The Lord of the Rings");

        author.addBook(book1);
        author.addBook(book2);
        authorRepo.save(author);

        System.out.println("Saved Author: " + author);
        System.out.println("Books: " + author.getBooks());

        System.out.println("--- DEMO: Many-to-Many (Student <-> Course) ---");

        Student alice = new Student("Alice");
        Student bob = new Student("Bob");
        Course math = new Course("Calculus I");
        Course history = new Course("World History");

        alice.addCourse(math);
        alice.addCourse(history);
        bob.addCourse(math);

        studentRepo.save(alice);
        studentRepo.save(bob);

        System.out.println("Student Alice: " + alice + ", Courses: " + alice.getCourses());
        System.out.println("Student Bob: " + bob + ", Courses: " + bob.getCourses());
    }
}
