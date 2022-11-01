package peaksoft.dao;


import peaksoft.entity.Course;

public interface CourseDao {
    void save(Course course);
    void deleteCourseById(Long id);


}