package peaksoft.service.impl;

import peaksoft.dao.CourseDao;
import peaksoft.dao.StudentDao;
import peaksoft.dao.TeacherDao;
import peaksoft.dao.impl.CourseDaoImpl;
import peaksoft.dao.impl.StudentDaoImpl;
import peaksoft.dao.impl.TeacherDaoImpl;
import peaksoft.entity.Course;
import peaksoft.entity.Student;
import peaksoft.entity.Teacher;
import peaksoft.service.AllService;

public class AllServiceImpl implements AllService {
    CourseDao courseDao = new CourseDaoImpl();
    TeacherDao teacherDao = new TeacherDaoImpl();
    StudentDao studentDao = new StudentDaoImpl();


    @Override
    public void save(Long id,Course course) {
        courseDao.save(id,course);
    }
    @Override
    public void deleteCourseById(Long id) {
        courseDao.deleteCourseById(id);
    }

    @Override
    public void save(Long id,Student student) {
        studentDao.save(id,student);
    }

    @Override
    public void save(Teacher teacher) {
        teacherDao.save(teacher);
    }
}