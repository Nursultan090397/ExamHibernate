package peaksoft.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import peaksoft.config.DataBaseConfig;
import peaksoft.dao.StudentDao;
import peaksoft.entity.Course;
import peaksoft.entity.Student;

import java.util.List;


public class StudentDaoImpl implements StudentDao {
    private final SessionFactory sessionFactory = DataBaseConfig.createsessionFactory();
    private EntityManagerFactory entityManagerFactory= DataBaseConfig.createEntityManagerFactory();
    @Override
    public void save(Long id, Student student) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Course course = session.find(Course.class, id);
       course.addLessonsToCourses(student);
        student.setCourse(List.of(course));
        session.save(student);
        System.out.println("koshuldu");
        session.getTransaction().commit();
        session.close();
    }
}