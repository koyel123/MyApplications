package com.org.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.quiz.model.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
