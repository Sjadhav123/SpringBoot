package com.silicus.librabrymanagment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping(value="/saveBook",method=RequestMethod.POST)
	public ResponseEntity<Book>createBook(@RequestBody Book book){
		bookService.saveBook(book);
		return new ResponseEntity<Book>(HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/getBookById/{id}",method=RequestMethod.GET)
	public ResponseEntity<Book>getBook(@PathVariable("id")long id) throws Exception{
		
		Book book=bookService.getBook(id);
		return new ResponseEntity<Book>(book, new HttpHeaders(), HttpStatus.OK);
		
		
	}
	
	
	@RequestMapping(value="/getAllBooks",method=RequestMethod.GET)
	public ResponseEntity<List<Book>> getAllBooks() throws Exception{
		
	     List<Book> bookList = bookService.getAllBooks();
	     return new ResponseEntity<List<Book>>(bookList, new HttpHeaders(), HttpStatus.OK);
		
		
	}
	
	@RequestMapping(value="/updateBook/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Book> updateBook(@PathVariable("id") long id, @RequestBody Book book) {
		
		Book updateBook = bookService.updateBook(id, book);
		return new ResponseEntity<Book>(updateBook, new HttpHeaders(), HttpStatus.OK);
		
		
		
	}
	
	@RequestMapping(value="/deleteBookById/{id}",method=RequestMethod.DELETE)
	public HttpStatus deleteBook(@PathVariable("id")long id) throws Exception{
		
		bookService.deleteBookById(id);
		return HttpStatus.OK;
		
		
	}
	
	
	
}
