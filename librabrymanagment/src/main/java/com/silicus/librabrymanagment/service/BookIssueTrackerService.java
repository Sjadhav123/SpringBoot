package com.silicus.librabrymanagment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.silicus.librabrymanagment.Dao.BookIssueTrackerRepository;
import com.silicus.librabrymanagment.entity.BookIssueTracker;

@Service
public class BookIssueTrackerService {

	@Autowired
	private BookIssueTrackerRepository bookIssueRepository;

	public void saveBookIssueTracker(BookIssueTracker bookIssueTracker) {

		bookIssueRepository.save(bookIssueTracker);

	}

	public BookIssueTracker getBookIssueTracker(long id) throws Exception {
		Optional<BookIssueTracker> bookIssueTracker = bookIssueRepository.findById(id);
		if (bookIssueTracker.isPresent()) {
			return bookIssueTracker.get();
		} else {

			throw new Exception("Book not found");
		}

	}

	public List<BookIssueTracker> getAllBookIssueTrackers() {
		List<BookIssueTracker> bookIssueTrackerList = bookIssueRepository.findAll();
		return bookIssueTrackerList;

	}

	public BookIssueTracker updateBookIssueTracker(long id, BookIssueTracker bookIssueTracker) {
		Optional<BookIssueTracker> existingBookIssueTracker = bookIssueRepository.findById(id);
		if (existingBookIssueTracker.isPresent()) {

			BookIssueTracker oldBookIssueTracker = existingBookIssueTracker.get();
			oldBookIssueTracker.setBook(bookIssueTracker.getBook());
			oldBookIssueTracker.setDateOfIssue(bookIssueTracker.getDateOfIssue());
			oldBookIssueTracker.setExpDate(bookIssueTracker.getExpDate());
			oldBookIssueTracker.setIssuer(bookIssueTracker.getIssuer());
			oldBookIssueTracker.setUser(bookIssueTracker.getUser());

			bookIssueRepository.save(oldBookIssueTracker);
			return oldBookIssueTracker;

		} else {
			bookIssueTracker = bookIssueRepository.save(bookIssueTracker);
			return bookIssueTracker;
		}

	}

	public void deleteBookIssueTrackerById(long id) throws Exception {

		Optional<BookIssueTracker> bookIssueTracker = bookIssueRepository.findById(id);
		if (bookIssueTracker.isPresent()) {
			bookIssueRepository.deleteById(id);

		} else {
			throw new Exception("BookIssueTracker Record not found to perform delete operation");
		}
	}

}
