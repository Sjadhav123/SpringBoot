package com.silicus.librabrymanagment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.silicus.librabrymanagment.entity.Book;
import com.silicus.librabrymanagment.service.BookService;

@RestController
@RequestMapping("/bookController")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@RequestMapping(value="/createBook",method=RequestMethod.POST)
	public ResponseEntity<Book>createBook(@RequestBody Book book){
		bookService.saveBook(book);
		return new ResponseEntity<Book>(HttpStatus.OK);
		
	}
}
