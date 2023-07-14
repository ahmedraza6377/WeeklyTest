package com.UniversityEventManagment.UniversityEventManagment.UniversityController;

import com.UniversityEventManagment.UniversityEventManagment.Model.Dep;
import com.UniversityEventManagment.UniversityEventManagment.Model.Student;
import com.UniversityEventManagment.UniversityEventManagment.UniService.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("Students")
    public Iterable<Student> getAllStudents(){
        return  studentService.findStudents();
    }
    @PostMapping("student")
    public String addStu(@RequestBody Student st){
        studentService.addStudent(st);
        return "Added";
    }

    @GetMapping("student/{id}")
    public Student getStudentById(@PathVariable Long id){
        return studentService.getStuById(id);
    }

    // delete a room by id
    @DeleteMapping("student/{id}")
    public String deleteAddById(@PathVariable Long id){
        studentService.deleteStudent(id);
        return "deleted";
    }

    // update room type on the basis of roomId
    @PutMapping("student/{id}")
    public String updateAddById(@PathVariable Long id,@RequestBody Dep dep){
        return studentService.updateStudentDepartment(id,dep);


    }


}
