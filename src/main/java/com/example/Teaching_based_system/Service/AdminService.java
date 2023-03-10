package com.example.Teaching_based_system.Service;

import com.example.Teaching_based_system.Entity.Course;
import com.example.Teaching_based_system.Entity.Message;
import com.example.Teaching_based_system.Entity.User;
import com.example.Teaching_based_system.Exception.CourseExistenceException;
import com.example.Teaching_based_system.Repository.CourseRepo;
import com.example.Teaching_based_system.Repository.Messagerepo;
import com.example.Teaching_based_system.Repository.UserRepo;
import com.example.Teaching_based_system.RequestDTO.InputId;
import com.example.Teaching_based_system.RequestDTO.MessageDTO;
import com.example.Teaching_based_system.RequestDTO.NameDTO;
import com.example.Teaching_based_system.ResponseDTO.Out3DTO;
import com.example.Teaching_based_system.ResponseDTO.ViewUserDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CourseRepo courseRepo;
    @Autowired
    private Messagerepo messagerepo;

    @Autowired
    private UserRepo userRepo;
    public Course saveCourse(Course course){
        if( courseRepo.existsById(course.getCourseid())){
            throw new CourseExistenceException();
        }
        else{
            return courseRepo.save(course);
        }
    }
    public List<Course> getAllcourses(){
        return courseRepo.findAll();
    }

    public List<ViewUserDTO> findAllByCourseid(InputId inputId){
        return courseRepo.findAllByCourseid(inputId.getId());
    }

    public  List<Course> findAllCoursesById(NameDTO nameDTO){
        User user = userRepo.findByName(nameDTO.getName());
        return courseRepo.findAllCourseById(user.getId());
    }

    public  List<Course> findAllCoursesByTId(NameDTO nameDTO){
        User user = userRepo.findByName(nameDTO.getName());
        return courseRepo.findAllCourseByTId(user.getId());
    }

    public void putMessage(MessageDTO messageDTO){
        Message message1 = modelMapper.map(messageDTO, Message.class);
        User user = userRepo.findByName(messageDTO.getName());
        message1.setRid(user.getId());
        System.out.println(message1);
        messagerepo.save(message1);
    }
}
