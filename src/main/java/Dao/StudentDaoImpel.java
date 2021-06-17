package Dao;

import Entities.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class StudentDaoImpel implements StudentDao{
    private  JdbcTemplate jdbcTemplate;
    @Override
    public int insert(Student student) {
        String query = "INSERT INTO student (id,name,address) VALUES(?,?,?)";
        int r = this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getAddress());
        return r;
    }

    public void delete(int sid){
        String query = "DELETE FROM student WHERE id = ?";
        int r  = this.jdbcTemplate.update(query,sid);
        if (r>0){
            System.out.println("=> Deletion Successful ");
        }


    }

    public void display (){
        String query = "SELECT * FROM student";




    }

    @Override
    public int change(Student student) {
        // Updating query
        String query  = "UPDATE student SET name = ? , address = ? WHERE id = ? ";
        int r = this.jdbcTemplate.update(query,student.getName(),student.getAddress(),student.getId());


        return r ;
    }

    @Override
    public Student getStudent(int studentId) {
        //Selecting single student data
        RowMapper rowMapper = new RowMapperImplement();
        String query = "SELECT * FROM student WHERE id = ? ";
        Student student = (Student) this.jdbcTemplate.queryForObject(query,rowMapper,studentId);
        return student;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
