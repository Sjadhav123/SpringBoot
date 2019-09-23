package com.silicus.librabrymanagment.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.silicus.librabrymanagment.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

}
