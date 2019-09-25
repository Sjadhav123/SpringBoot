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

import com.silicus.librabrymanagment.entity.BookIssueTracker;
import com.silicus.librabrymanagment.service.BookIssueTrackerService;

@RestController
@RequestMapping("/bookIssueController")
public class BookIssueTrackerController {

	@Autowired
	private BookIssueTrackerService bookIssueTrackerService;

	@RequestMapping(value = "/saveBook", method = RequestMethod.POST)
	public ResponseEntity<BookIssueTracker> createBook(@RequestBody BookIssueTracker bookIssueTracker) {
		bookIssueTrackerService.saveBookIssueTracker(bookIssueTracker);
		return new ResponseEntity<BookIssueTracker>(HttpStatus.OK);

	}

	@RequestMapping(value = "/getBookIssueTrackerById/{id}", method = RequestMethod.GET)
	public ResponseEntity<BookIssueTracker> getBook(@PathVariable("id") long id) throws Exception {

		BookIssueTracker bookIssueTracker = bookIssueTrackerService.getBookIssueTracker(id);
		return new ResponseEntity<BookIssueTracker>(bookIssueTracker, new HttpHeaders(), HttpStatus.OK);

	}

	@RequestMapping(value = "/getAllBookIssueTrackers", method = RequestMethod.GET)
	public ResponseEntity<List<BookIssueTracker>> getAllBooks() throws Exception {

		List<BookIssueTracker> bookIssueTrackerList = bookIssueTrackerService.getAllBookIssueTrackers();
		return new ResponseEntity<List<BookIssueTracker>>(bookIssueTrackerList, new HttpHeaders(), HttpStatus.OK);

	}

	@RequestMapping(value = "/updateBookIssueTracker/{id}", method = RequestMethod.PUT)
	public ResponseEntity<BookIssueTracker> updateBook(@PathVariable("id") long id,
			@RequestBody BookIssueTracker bookIssueTracker) {

		BookIssueTracker updateBookIssueTracker = bookIssueTrackerService.updateBookIssueTracker(id, bookIssueTracker);
		return new ResponseEntity<BookIssueTracker>(updateBookIssueTracker, new HttpHeaders(), HttpStatus.OK);

	}

	@RequestMapping(value = "/deleteBookById/{id}", method = RequestMethod.DELETE)
	public HttpStatus deleteBook(@PathVariable("id") long id) throws Exception {

		bookIssueTrackerService.deleteBookIssueTrackerById(id);
		return HttpStatus.OK;

	}

}
