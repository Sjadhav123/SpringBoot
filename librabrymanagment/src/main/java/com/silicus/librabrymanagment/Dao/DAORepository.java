package com.silicus.librabrymanagment.Dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.silicus.librabrymanagment.entity.BookReturnTracker;

@Repository

public interface DAORepository extends JpaRepository<BookReturnTracker,Serializable>{


	
}