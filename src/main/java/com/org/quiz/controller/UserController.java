package com.org.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.quiz.dao.CourseService;
import com.org.quiz.dao.RoleService;
import com.org.quiz.dao.UserService;
import com.org.quiz.model.Course;
import com.org.quiz.model.Role;
import com.org.quiz.model.User;
@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	RoleService roleService;
	
	@Autowired
	CourseService courseService;
	
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public List<Course> save(@RequestBody User user) {
		Role role = roleService.findByRoleId(1L);
        user.setRoles(role);
		userService.save(user);
		return courseService.listAllCourse();
	}
	

	@RequestMapping(value = "/loginUser", method = RequestMethod.POST)
	public List<Course> loginUser(@RequestBody User user) throws Exception {
		List<User> userList = userService.listAllUsers();
		
		
		for(User user1:userList) {
			
			if(user1.getUser_name().equals(user.getUser_name()) && user1.getPwd().equals(user.getPwd()) && user1.getRoles().getRole().equals("USER"))
				return courseService.listAllCourse();
		
		}
		throw new Exception("Incorrect credentials or userId not registered ");
	}
	
	@RequestMapping(value = "/loginAdmin", method = RequestMethod.POST)
	public String loginAdmin(@RequestBody User user) throws Exception {
		List<User> userList = userService.listAllUsers();
		
		
		for(User user1:userList) {
			
			if(user1.getUser_name().equals(user.getUser_name()) && user1.getPwd().equals(user.getPwd()) && user1.getRoles().getRole().equals("ADMIN"))
				return "/";
		
		}
		throw new Exception("Admin credentials incorrect");
	}
	
	
}
