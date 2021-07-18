package com.avanindra.springdemos.crudDemo.repository;

import com.avanindra.springdemos.crudDemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface User repository.
 *
 * @author Givantha Kalansuriya
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {}
