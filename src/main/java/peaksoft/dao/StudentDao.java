package peaksoft.dao;


import peaksoft.entity.Student;

public interface StudentDao {
    void save(Long id,Student student);
}