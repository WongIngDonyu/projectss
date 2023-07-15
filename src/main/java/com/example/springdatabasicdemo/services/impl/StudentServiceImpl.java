package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.GroupDto;
import com.example.springdatabasicdemo.dtos.StudentDto;
import com.example.springdatabasicdemo.models.Group;
import com.example.springdatabasicdemo.models.Student;
import com.example.springdatabasicdemo.repositories.GroupRepository;
import com.example.springdatabasicdemo.repositories.StudentRepository;
import com.example.springdatabasicdemo.services.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService<Integer> {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public StudentDto register(StudentDto student) {
        Student s = modelMapper.map(student, Student.class);
        if (student.getGroup().getId() != 0) {
            Group g = groupRepository.findById(student.getGroup().getId()).get();
            s.setGroup(g);
        }
        return modelMapper.map(studentRepository.save(s), StudentDto.class);
    }

    @Override
    public void expel(StudentDto student) {
        studentRepository.deleteById(student.getId());
    }

    @Override
    public void expel(Integer id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void transfer(StudentDto student, GroupDto group) {
        Student s = studentRepository.findById(student.getId()).get();
        Group g = groupRepository.findById(group.getId()).get();
        s.setGroup(g);
        studentRepository.save(s);
    }

    @Override
    public Optional<StudentDto> findStudent(Integer id) {
        return Optional.ofNullable(modelMapper.map(studentRepository.findById(id), StudentDto.class));
    }

    @Override
    public List<StudentDto> getAll() {
        return studentRepository.findAll().stream().map((s) -> modelMapper.map(s, StudentDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<StudentDto> findStudentsByGroup(String group) {
        return studentRepository.findAllByGroupName(group).stream().map((s) -> modelMapper.map(s, StudentDto.class)).collect(Collectors.toList());
    }
}