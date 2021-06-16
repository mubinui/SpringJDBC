import Dao.StudentDao;
import Entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

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
        StudentDao sd = context.getBean("studentDao", StudentDao.class);
        Student s = new Student(1003,"Samindra","Dhaka");

        int res = sd.insert(s);
        System.out.println("=> Student added "+res);


    }
}