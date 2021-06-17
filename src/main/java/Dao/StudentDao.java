package Dao;

import Entities.Student;

public interface StudentDao {
    public int insert(Student student);
    public void delete(int sid);
    public void display();
    public int change(Student student);
    public Student getStudent(int studentId);

}
