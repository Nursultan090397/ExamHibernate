package peaksoft.service;


import peaksoft.entity.Course;
import peaksoft.entity.Student;
import peaksoft.entity.Teacher;

public interface AllService {
    void save(Long id,Course course);

    void deleteCourseById(Long id);

    void save(Long id,Student student);

    void save(Teacher teacher);

}