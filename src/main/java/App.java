import Dao.StudentDao;
import Entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ListIterator;

public class App {
    public static void main(String[] args) throws IOException {
        ApplicationContext context = new AnnotationConfigApplicationContext(JDBCConfig.class);
        //here configuration style Configuration Class Name dot class
        StudentDao std = context.getBean("studentDao",StudentDao.class);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(" |||| WELCOME TO STUDENT MANAGE SYSTEM ||||");
        while(true){
            System.out.println(" => Press [1] To Add New Student ");
            System.out.println(" => Press [2] To Update details  ");
            System.out.println(" => Press [3] To Delete Records  ");
            System.out.println(" => Press [4] To Display Student Details ");
            System.out.println(" => Press [5] To Display All Student Details ");
            System.out.println(" => Press [6] To Exit ");

            System.out.println(" [*] Insert a number =>");
            int selector = Integer.parseInt(br.readLine());
            if (selector == 1){
                // Insert Operation
                System.out.println(" => ID");
                int id = Integer.parseInt(br.readLine());
                System.out.println(" => Name");
                String name = br.readLine();
                System.out.println(" => Address ");
                String address = br.readLine();
                Student student = new Student(id,name,address);
                int row_affected = std.insert(student);
                System.out.println();
                System.out.println();
                if (row_affected>0){
                    System.out.println("Successful Insertion ");
                }
                System.out.println();
                System.out.println();


            }
            else if (selector == 2){
                // Update Operation
                System.out.println(" => ID");
                int id = Integer.parseInt(br.readLine());
                System.out.println(" => New Name");
                String name = br.readLine();
                System.out.println(" => New Address ");
                String address = br.readLine();
                Student student = new Student(id,name,address);
                int row = std.change(student);
                if (row>0){
                    System.out.println("Update Successful  ");
                }
                System.out.println();
                System.out.println();
            }
            else if (selector == 3){
                // Delete Operation
                System.out.println(" => ID");
                int id = Integer.parseInt(br.readLine());
                std.delete( id);
                System.out.println();
                System.out.println();
            }
            else if (selector == 4){
                // Display single object

                int id = Integer.parseInt(br.readLine());
                Student student = std.getStudent(id);
                System.out.println(student);


            }
            else if (selector == 5){
                // Display Table
                List<Student> students = std.getAllStudents();
                for(Student s : students){
                    System.out.println(s);
                }


            }
            else if (selector == 6){
                System.out.println(" => Thank You For Using My System ");
                break;
            }
            else{
                System.out.println("Enter a valid number ");
                continue;
            }




        }






    }
}
