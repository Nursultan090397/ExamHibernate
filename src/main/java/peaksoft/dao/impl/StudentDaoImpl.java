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
        /*try {
            Session session = sessionFactory.openSession();
            session.beginTransaction().begin();
            Course course = session.find(Course.class,id);
            student.setCourse((List<Course>) course);
            course.addLessonsToCourses(student);
            session.merge(course);
            session.getTransaction().commit();
            session.close();

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }*/
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Course course1 = entityManager.find(Course.class, id);
        course1.addLessonsToCourses(course1);
        student.setCourse(course1);
        entityManager.persist(student);

        entityManager.getTransaction().commit();
        entityManager.close();

    }
}