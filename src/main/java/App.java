import Dao.StudentDao;
import Entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.ListIterator;

public class App {
    public static void main(String[] args) {
        System.out.println("=> My Program Started !");
        //Spring jdbc => JdbcTemplate
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringJDBCconfig.xml");
//        JdbcTemplate jt = (JdbcTemplate)context.getBean("jdbctemp");
//
//        //insert query
//        String query = "INSERT INTO student(id,name,address) values (?,?,?)";
//        //fire the query
//        int result = jt.update(query,1002,"Muhib Nayem","Dakata");
//        System.out.println("Number of record inserted => "+result);


        // StudentDao
        //Insert operation
//        StudentDao sd = context.getBean("studentDao", StudentDao.class);
//        Student s = new Student(1003,"Samindra","Dhaka");
//
//        int res = sd.insert(s);
//        System.out.println("=> Student added "+res);

        // Delete operation
//        StudentDao sd1 = context.getBean("studentDao",StudentDao.class);
//        sd1.delete(1003);

        //Update
//        StudentDao sd0 = context.getBean("studentDao",StudentDao.class);
//        Student student = new Student(1003,"Samindra Ferdous","Hightech");
//
//        int a = sd0.change(student);


        // Single (object) data selector

//        StudentDao studentdao = context.getBean("studentDao",StudentDao.class);
//        Student s = studentdao.getStudent(1001);
//        System.out.println(s);

        // Selecting allstudents
        StudentDao std = context.getBean("studentDao",StudentDao.class);
        List<Student> allStudents = std.getAllStudents();

//        ListIterator<Student> e = allStudents.listIterator();
//        while(e.hasNext()){
//            System.out.println(e.next());
//        }
        //or
        for (Student s : allStudents){
            System.out.println(s);
        }







    }
}
