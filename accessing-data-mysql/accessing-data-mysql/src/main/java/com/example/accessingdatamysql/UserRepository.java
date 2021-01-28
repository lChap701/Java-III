package com.example.accessingdatamysql;

import org.springframework.data.repository.CrudRepository;

import com.example.accessingdatamysql.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

/**
 * Created 8/7/2020 by Lucas Chapman
 * This interface is used to display users in the User table
 * Visit https://spring.io/guides/gs/accessing-data-mysql/ for more information
 */
public interface UserRepository extends CrudRepository<User, Integer> {

}