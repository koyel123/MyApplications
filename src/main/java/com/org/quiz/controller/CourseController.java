package com.org.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.quiz.dao.CourseService;
import com.org.quiz.dao.UserService;
import com.org.quiz.model.Course;

@RestController
public class CourseController {


	@Autowired
	UserService userService;
	
	@Autowired
	CourseService courseService;

	@PostMapping("/user/{userId}/course")
	public String save(@PathVariable (value = "userId") Long userId,@RequestBody Course course) throws Exception {
	 courseService.save(userId,course);
	 return "Course created succesfully";

	}
}
