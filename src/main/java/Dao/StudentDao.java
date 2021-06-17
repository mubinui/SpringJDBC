package Dao;

import Entities.Student;

import java.util.List;

public interface StudentDao {
    public int insert(Student student);
    public void delete(int sid);
    public void display();//Unused
    public int change(Student student);
    public Student getStudent(int studentId);
    public List<Student> getAllStudents ();

}
