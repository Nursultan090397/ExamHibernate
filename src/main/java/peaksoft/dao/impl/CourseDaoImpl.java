package peaksoft.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import peaksoft.config.DataBaseConfig;
import peaksoft.dao.CourseDao;
import peaksoft.entity.Course;


public class CourseDaoImpl implements CourseDao {
    private final SessionFactory sessionFactory = DataBaseConfig.createsessionFactory();
    private EntityManagerFactory entityManagerFactory = DataBaseConfig.createEntityManagerFactory();
    @Override
    public void save(Long id,Course course) {
        /*try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Student student = session.get(Student.class,id);
            if (course == null) {
                System.out.println("No such course!)");
            } else {
                course.setStudents((List<Student>) student);
                session.persist(course);
            }
            session.getTransaction().commit();
            session.close();
        } catch (Exception exception) {
            System.out.println("An error occurred! -> (saveCourse)!");
        }*/
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(course);
        System.out.println("Course iygiliktuu koshuldu!");

        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public void deleteCourseById(Long id) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Course course = session.get(Course.class, id);
            session.remove(course);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}