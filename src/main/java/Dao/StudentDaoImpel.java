package Dao;

import Entities.Student;
import org.springframework.jdbc.core.JdbcTemplate;

public class StudentDaoImpel implements StudentDao{
    private JdbcTemplate jdbcTemplate;
    @Override
    public int insert(Student student) {
        String query = "INSERT INTO student (id,name,address) VALUES(?,?,?)";
        int r = this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getAddress());
        return r;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
