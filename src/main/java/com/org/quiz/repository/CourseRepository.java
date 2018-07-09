package com.org.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.quiz.model.Course;
@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{

}
