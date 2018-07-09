package com.org.quiz.dao;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.quiz.model.Role;
import com.org.quiz.model.User;
import com.org.quiz.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public User save(User user) {
		return userRepository.save(user);
	}
	
	public List<User> listAllUsers() {
		return userRepository.findAll();
	}

}
