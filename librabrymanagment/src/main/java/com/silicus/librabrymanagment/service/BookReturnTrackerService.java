package com.silicus.librabrymanagment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.silicus.librabrymanagment.Dao.DAORepository;
import com.silicus.librabrymanagment.entity.BookReturnTracker;

@Service

public class BookReturnTrackerService {

	@Autowired
	DAORepository reposit;

	public BookReturnTracker insert(BookReturnTracker b) {
		BookReturnTracker save = reposit.save(b);
		System.out.println("record inserted successfully");
		return save;
	}

	@ExceptionHandler(NullPointerException.class)
	public Iterable<BookReturnTracker> getAllRecords() {

		Iterable<BookReturnTracker> findAll = reposit.findAll();
		return findAll;
	}

	public String deleteById(int id) {

		reposit.deleteById(id);
		return "Record has been deleted";

	}

	public String updateById(int id, BookReturnTracker bookrtns) {

		if (reposit.existsById(id)) {

			Optional<BookReturnTracker> returnTrackerRecord = reposit.findById(id);
			System.out.println("Record Found" + returnTrackerRecord);
			
			if(returnTrackerRecord.isPresent()) {
				BookReturnTracker oldBookRtnTrackerRecord = returnTrackerRecord.get();
				oldBookRtnTrackerRecord.setFineAmount(bookrtns.getFineAmount());
				oldBookRtnTrackerRecord.setIssueId(bookrtns.getIssueId());
				oldBookRtnTrackerRecord.setReceiver(bookrtns.getReceiver());
				oldBookRtnTrackerRecord.setReturnDate(bookrtns.getReturnDate());
				
				reposit.save(oldBookRtnTrackerRecord);
				
			}

			return "updated successfully";
		}
		return "Record not found";

	}

}

/*
 * 
 */