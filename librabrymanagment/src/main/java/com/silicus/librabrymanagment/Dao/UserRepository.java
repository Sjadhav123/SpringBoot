package com.silicus.librabrymanagment.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.silicus.librabrymanagment.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
