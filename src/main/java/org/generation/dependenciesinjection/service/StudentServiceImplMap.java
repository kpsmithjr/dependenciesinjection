package org.generation.dependenciesinjection.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.generation.dependenciesinjection.model.Student;
import org.springframework.stereotype.Service;

// @Service
public class StudentServiceImplMap implements StudentService{

  HashMap<String, Student> students;

  public StudentServiceImplMap() {
    students = new HashMap<String, Student>();
    addDefaultStudents();
  }

  @Override
  public void add(Student student) {
    if (!students.containsKey(student.getIdStudent())) {
      students.put(student.getIdStudent(), student);
    } else {
      throw new IllegalStateException("Key in use");
    }
    
  }

  @Override
  public void delete(Student student) {
    students.remove(student.getIdStudent());
  }

  @Override
  public List<Student> all() {
    Collection<Student> collection = students.values();
    List<Student> list = new ArrayList<Student>(collection);
    return list;
  }

  @Override
  public Student findById(String id) {
    return students.get(id);
  }
  
  private void addDefaultStudents() {
    this.add(new Student("1", 0, "Bruce", "Wayne", 0));
    this.add(new Student("2", 0, "Clark", "Kent", 1));    
    this.add(new Student("3", 1, "Peter", "Parker", 0));
  }

}
