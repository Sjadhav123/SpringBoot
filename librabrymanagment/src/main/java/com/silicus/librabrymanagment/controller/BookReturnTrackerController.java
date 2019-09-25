package com.silicus.librabrymanagment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.silicus.librabrymanagment.entity.BookReturnTracker;
import com.silicus.librabrymanagment.service.BookReturnTrackerService;

@Controller
@RestController
public class BookReturnTrackerController {
	@Autowired
	BookReturnTrackerService bkreturnSer;

	@RequestMapping("/")
	public String welcome() {
		return "Welcome to Java4s Spring Boot Tutorials";
	}

	@RequestMapping("/hello")
	public String myData() {
		return "Hello Spring Boot";
	}

	@RequestMapping("/welcome")
	public String WelCome() {
		return "Welcome to sanTbkreturnSerech";
	}

	@PostMapping(path = "/insertRecord", consumes = "application/json", produces = "application/json")
	public BookReturnTracker insertRecord(@RequestBody BookReturnTracker bkreturn) {
		System.out.println("inside controller 1111");
		BookReturnTracker insert = bkreturnSer.insert(bkreturn);
		System.out.println("inserted the record in database");
		System.out.println("inside controller 2222");

		return insert;
	}

	@GetMapping("/getAllRecords")
	public Iterable<BookReturnTracker> getAllRecords() {
		Iterable<BookReturnTracker> allRecords = bkreturnSer.getAllRecords();

		return allRecords;

	}

	@DeleteMapping("/deleteReturnRecord/{id}")
	public String deleteReturnRecords(@PathVariable(required = true) int id) {

		String deleteStatus = bkreturnSer.deleteById(id);
		return deleteStatus;
	}

	@PutMapping("/UpdateReturnRecord/{id}")
	public String updateReturnRecords(@PathVariable(required = true) int id, @RequestBody BookReturnTracker bookrtn) {

		String updateStatus = bkreturnSer.updateById(id, bookrtn);
		return updateStatus;
	}

}
