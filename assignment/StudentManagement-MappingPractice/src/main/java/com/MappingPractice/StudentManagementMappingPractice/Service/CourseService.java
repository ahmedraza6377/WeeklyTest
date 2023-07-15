package com.MappingPractice.StudentManagementMappingPractice.Service;

import com.MappingPractice.StudentManagementMappingPractice.Model.Course;
import com.MappingPractice.StudentManagementMappingPractice.Repository.ICourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    @Autowired
    ICourseRepo courseRepo;

    public Course createCourse(Course course) {
        return courseRepo.save(course);
    }

    public Course getCourseById(Long id) {
        return courseRepo.findById(id).orElse(null);
    }

    public Course updateCourse(Long id, Course updatedCourse) {
        Course existingCourse = courseRepo.findById(id).orElse(null);
        if (existingCourse != null) {
            existingCourse.setTitle(updatedCourse.getTitle());
            existingCourse.setDescription(updatedCourse.getDescription());
            existingCourse.setDuration(updatedCourse.getDuration());
            existingCourse.setStudentList(updatedCourse.getStudentList());
            return courseRepo.save(existingCourse);
        }
        return null;
    }

    public void deleteCourse(Long id) {
        courseRepo.deleteById(id);
    }
}
