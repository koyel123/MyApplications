package com.org.quiz.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.quiz.model.Role;
import com.org.quiz.repository.RoleRepository;

@Service
public class RoleService {
    @Autowired
	RoleRepository roleRepository;
    
    public Role findByRoleId(Long id){
    	return roleRepository.findOne(id);
    	
    }
}
