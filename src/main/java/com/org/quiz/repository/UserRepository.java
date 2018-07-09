package com.org.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.quiz.model.Course;
import com.org.quiz.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
