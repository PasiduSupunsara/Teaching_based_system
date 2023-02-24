package com.example.Teaching_based_system.Service;

import com.example.Teaching_based_system.Entity.Courseteacher;
import com.example.Teaching_based_system.Repository.TeacherCourseRepo;
import com.example.Teaching_based_system.ResponseDTO.Out1DTO;
import com.example.Teaching_based_system.ResponseDTO.Out2DTO;
import com.example.Teaching_based_system.ResponseDTO.OutDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private TeacherCourseRepo teacherCourseRepo;
  //  @PostMapping("/mapTeacherCourse")
    public Courseteacher saveCourseTeacher(Courseteacher courseteacher){
        return teacherCourseRepo.save(courseteacher);
    }
    public List<OutDTO> findCourseNameByUserIdForTeacher(){
        return teacherCourseRepo.findCourseNameByUserIdForTeacher();
    }
    public List<Out1DTO> findTeacherId(){
        return teacherCourseRepo.findTeacherId();
    }

    public List<Out2DTO> findTeacherName(){
        return teacherCourseRepo.findTeacherName();
    }


}
