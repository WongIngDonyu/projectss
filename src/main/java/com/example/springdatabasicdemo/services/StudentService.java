package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.GroupDto;
import com.example.springdatabasicdemo.dtos.StudentDto;
import com.example.springdatabasicdemo.models.Group;
import com.example.springdatabasicdemo.models.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService<ID> {

    StudentDto register(StudentDto student);

    void expel(StudentDto student);

    void expel(ID id);

    void transfer(StudentDto student, GroupDto group);

    Optional<StudentDto> findStudent(ID id);

    List<StudentDto> getAll();

    List<StudentDto> findStudentsByGroup(String group);
}

