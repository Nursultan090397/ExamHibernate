package peaksoft;

import peaksoft.config.DataBaseConfig;
import peaksoft.dao.impl.CourseDaoImpl;
import peaksoft.dao.impl.StudentDaoImpl;
import peaksoft.dao.impl.TeacherDaoImpl;
import peaksoft.entity.Course;
import peaksoft.entity.Student;
import peaksoft.entity.Teacher;


import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println(DataBaseConfig.createsessionFactory());


        Student student1 = new Student("Nursultan", 25);
        Student student2 = new Student("Eldiar", 19);
        Student student3 = new Student("Zhazgul", 19);
        Student student4 = new Student("Nurislam", 16);

        Teacher teacher1 = new Teacher("Zhanarbek", "Abdurasulov");
        Teacher teacher2 = new Teacher("Muhkammed", "Allanov");

        Course course1 = new Course("Peaksoft", LocalDate.of(2018, 10, 02));
        Course course2 = new Course("Motion Web", LocalDate.of(2020, 9, 10));

        CourseDaoImpl courseDao = new CourseDaoImpl();
        StudentDaoImpl studentDao = new StudentDaoImpl();
        TeacherDaoImpl teacherDao = new TeacherDaoImpl();

        /*courseDao.save(course1);
        courseDao.save(course2);*/

        /*studentDao.save(1l, student1);
        studentDao.save(2l, student2);
        studentDao.save(3l, student3);
        studentDao.save(4l, student4);*/

       /*teacherDao.save(teacher1);
        teacherDao.save(teacher2);*/

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Select Number :");
            String SelectNumber = scanner.nextLine();

            System.out.println();

            switch (SelectNumber) {
                case "1" -> courseDao.save(course1);
                case "2" -> courseDao.deleteCourseById(1L);
                case "3" -> studentDao.save(3l, student1);
                case "4" -> teacherDao.save(teacher1);


            }
        }
    }
}

