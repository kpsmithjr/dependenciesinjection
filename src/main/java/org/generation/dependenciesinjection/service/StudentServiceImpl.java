package org.generation.dependenciesinjection.service;

import java.util.ArrayList;
import java.util.List;

import org.generation.dependenciesinjection.model.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{
  ArrayList<Student> students;

  public StudentServiceImpl() {
    students = new ArrayList<Student>();

    addDefaultStudents();
  }

  @Override
  public void add( Student student ) {
    Student tmpStudent = find(student.getIdStudent());

    if (tmpStudent == null) {
      students.add(student);
    } else {
      System.out.println("Student with id " 
      + student.getIdStudent()
       + "already exists");
    }
    
  }

  @Override
  public void delete( Student studentToRemove ) {
    boolean removedStudent = false;
    for (Student student: students) {
      if (student.getIdStudent().equals(studentToRemove.getIdStudent())) {
        removedStudent = students.remove(student);
        break;
      }
    }
    
    if (!removedStudent){      
      System.out.println("Student with id: "
       + studentToRemove.getIdStudent() 
       + " was not found. Could not delete");
    }
  }

  @Override
  public List<Student> all() {
    return students;
  }

  @Override
  public Student findById( String id ) {
    Student student = find(id);

    if (student == null) {
      System.out.println("Student with id: " + id + " was not found");
    }    
    return student;
  }

  private Student find(String id) {
    for(Student student : students) {
      // System.out.println(student.getIdStudent());
      if (student.getIdStudent().equals(id)) {
        return student;
      }
    }    
    return null;
  }

  private void addDefaultStudents() {
    this.add(new Student("1", 0, "Bruce", "Wayne", 0));
    this.add(new Student("2", 0, "Clark", "Kent", 1));    
    this.add(new Student("3", 1, "Peter", "Parker", 0));
  }
}
