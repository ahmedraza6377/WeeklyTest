package com.MappingPractice.StudentManagementMappingPractice.Service;

import com.MappingPractice.StudentManagementMappingPractice.Model.Student;
import com.MappingPractice.StudentManagementMappingPractice.Repository.IStuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StuService {
    @Autowired
    IStuRepo stuRepo;


    public Student createStudent(Student student) {
        return stuRepo.save(student);
    }

    public Student getStudentById(Long id) {
        return stuRepo.findById(id).orElse(null);
    }

    public Student updateStudent(Long id, Student updatedStudent) {
        Student existingStudent = stuRepo.findById(id).orElse(null);
        if (existingStudent != null) {
            existingStudent.setName(updatedStudent.getName());
            existingStudent.setAge(updatedStudent.getAge());
            existingStudent.setPhoneNumber(updatedStudent.getPhoneNumber());
            existingStudent.setBranch(updatedStudent.getBranch());
            existingStudent.setDepartment(updatedStudent.getDepartment());
            existingStudent.setAddress(updatedStudent.getAddress());
            return stuRepo.save(existingStudent);
        }
        return null;
    }

    public void deleteStudent(Long id) {
        stuRepo.deleteById(id);
    }


}
