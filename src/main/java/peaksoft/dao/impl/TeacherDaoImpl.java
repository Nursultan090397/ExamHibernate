package peaksoft.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import peaksoft.config.DataBaseConfig;
import peaksoft.dao.TeacherDao;
import peaksoft.entity.Teacher;


public class TeacherDaoImpl implements TeacherDao {
    private final SessionFactory sessionFactory = DataBaseConfig.createsessionFactory();

    @Override
    public void save(Teacher teacher) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.persist(teacher);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}