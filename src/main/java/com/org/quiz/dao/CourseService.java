package com.org.quiz.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.quiz.model.Course;
import com.org.quiz.model.User;
import com.org.quiz.repository.CourseRepository;
import com.org.quiz.repository.UserRepository;

@Service
public class CourseService {
	@Autowired
	CourseRepository courseRepository;
	@Autowired
	UserRepository userRepository;

	public Course save(Long userId,Course course) throws Exception{
		
			User user	= userRepository.findOne(userId);
			if (user.getRoles().getRole().equals("ADMIN")) {
				course.setUser(user);
			    courseRepository.save(course);
			}
			else {
				throw new Exception("User is not admin");
			}
		return course;
		
		 
	}
	
	public List<Course> listAllCourse(){
		
	return courseRepository.findAll();
	}
}
