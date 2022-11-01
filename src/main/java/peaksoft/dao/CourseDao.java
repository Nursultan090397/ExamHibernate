package peaksoft.dao;


import peaksoft.entity.Course;

public interface CourseDao {
    void save(Long id,Course course);
    void deleteCourseById(Long id);


}