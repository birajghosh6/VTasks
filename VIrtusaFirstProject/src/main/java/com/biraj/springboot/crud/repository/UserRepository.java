package com.biraj.springboot.crud.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.biraj.springboot.crud.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, String>{

}
