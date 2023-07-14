package com.UniversityEventManagment.UniversityEventManagment.UniService;

import com.UniversityEventManagment.UniversityEventManagment.Model.Dep;
import com.UniversityEventManagment.UniversityEventManagment.Model.Student;
import com.UniversityEventManagment.UniversityEventManagment.Repo.IStuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    IStuRepo studentRepo;
    public Iterable<Student> findStudents() {
        return studentRepo.findAll();
    }

    public void addStudent(Student st) {

        studentRepo.save(st);
    }


    public Student getStuById(Long id) {

            return studentRepo.findById(id).orElse(null);
    }

    public String updateStudentDepartment(Long id, Dep department) {
        Student student = studentRepo.findById(id).orElse(null);
        if (student != null) {
            student.setDep(department);
             studentRepo.save(student);
             return "updated";
        }
        return "id not found";
    }

    public void deleteStudent(Long studentId) {
        studentRepo.deleteById(studentId);
    }

}
