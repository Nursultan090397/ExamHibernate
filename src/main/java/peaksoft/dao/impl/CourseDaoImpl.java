package peaksoft.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import peaksoft.config.DataBaseConfig;
import peaksoft.dao.CourseDao;
import peaksoft.entity.Course;
import peaksoft.entity.Student;

import java.util.List;


public class CourseDaoImpl implements CourseDao {
    private final SessionFactory sessionFactory = DataBaseConfig.createsessionFactory();
    private EntityManagerFactory entityManagerFactory = DataBaseConfig.createEntityManagerFactory();

    @Override
    public void save(Course course) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.save(course);
        System.out.println("course added");
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public void deleteCourseById(Long id) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Course course = session.get(Course.class, id);
            session.remove(course);
            System.out.println("deleted");
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}