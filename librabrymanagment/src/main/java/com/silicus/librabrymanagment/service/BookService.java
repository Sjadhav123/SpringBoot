package com.silicus.librabrymanagment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.silicus.librabrymanagment.Dao.BookRepository;
import com.silicus.librabrymanagment.entity.Book;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	
	public void saveBook(Book book) {
		
		bookRepository.save(book);
		
	}
	
}
