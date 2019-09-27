package com.silicus.librabrymanagment.service;

import java.util.List;
import java.util.Optional;

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

	public Book getBook(long id) throws Exception {
		Optional<Book> book = bookRepository.findById(id);
		if (book.isPresent()) {
			return book.get();
		} else {

			throw new Exception("Book not found");
		}

	}

	public List<Book> getAllBooks() {
		List<Book> bookList = bookRepository.findAll();
		return bookList;

	}

	public Book updateBook(long id, Book book) {
		Optional<Book> existingBook = bookRepository.findById(id);
		if (existingBook.isPresent()) {

			Book oldBook = existingBook.get();
			oldBook.setAuthor(book.getAuthor());
			oldBook.setIsAvailable(book.getIsAvailable());
			oldBook.setId(book.getId());
			oldBook.setIsbn(book.getIsbn());
			oldBook.setName(book.getName());
			oldBook.setRackName(book.getRackName());

			bookRepository.save(oldBook);
			return oldBook;

		} else {
			book = bookRepository.save(book);
			return book;
		}

	}

	public void deleteBookById(long id) throws Exception {
		
		Optional<Book> book = bookRepository.findById(id);
		if (book.isPresent()) {
			bookRepository.deleteById(id);
			
	}
		else {
			throw new Exception("Book not found to perform delete operation");
		}
	}

}
