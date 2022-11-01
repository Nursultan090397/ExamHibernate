package peaksoft;

import peaksoft.dao.impl.CourseDaoImpl;
import peaksoft.dao.impl.StudentDaoImpl;
import peaksoft.entity.Course;
import peaksoft.entity.Student;
import peaksoft.entity.Teacher;
import peaksoft.service.AllService;
import peaksoft.service.impl.AllServiceImpl;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App

{
    public static final AllService allService = new AllServiceImpl();

    public static void main( String[] args )
    {
        Student student1 = new Student("Nursultan",25);
        Student student2 = new Student("Eldiar",19);
        Student student3 = new Student("Zhazgul",19);
        Student student4 = new Student("Nurislam",16);

        Teacher teacher1 = new Teacher("Zhanarbek","Abdurasulov");
        Teacher teacher2 = new Teacher("Muhkammed","Allanov");

        Course course1 = new Course("Peaksoft","01.01.2020", Arrays.asList(student1,student2),teacher1);
        Course course2 = new Course("Motion Web","01.10.2019", Arrays.asList(student3,student4),teacher2);

        allService.save(1L, student1);
        allService.save(2L,student2);
        allService.save(3L,student3);
        allService.save(4L,student4);
        allService.save(teacher1);
        allService.save(teacher2);
        allService.save(1l,course1);
        allService.save(2l,course2);


    }
}
