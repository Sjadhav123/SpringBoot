package com.silicus.librabrymanagment.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
//@NamedQuery(name="Book.findAll", query="SELECT b FROM Book b")
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private String author;

	@Column(name="is_available")
	private byte isAvailable;

	private String isbn;

	private String name;

	@Column(name="rack_name")
	private String rackName;

	//bi-directional many-to-one association to BookIssueTracker
	@OneToMany(mappedBy="book")
	private Set<BookIssueTracker> bookIssueTrackers;

	public Book() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public byte getIsAvailable() {
		return this.isAvailable;
	}

	public void setIsAvailable(byte isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRackName() {
		return this.rackName;
	}

	public void setRackName(String rackName) {
		this.rackName = rackName;
	}

	public Set<BookIssueTracker> getBookIssueTrackers() {
		return this.bookIssueTrackers;
	}

	public void setBookIssueTrackers(Set<BookIssueTracker> bookIssueTrackers) {
		this.bookIssueTrackers = bookIssueTrackers;
	}

	public BookIssueTracker addBookIssueTracker(BookIssueTracker bookIssueTracker) {
		getBookIssueTrackers().add(bookIssueTracker);
		bookIssueTracker.setBook(this);

		return bookIssueTracker;
	}

	public BookIssueTracker removeBookIssueTracker(BookIssueTracker bookIssueTracker) {
		getBookIssueTrackers().remove(bookIssueTracker);
		bookIssueTracker.setBook(null);

		return bookIssueTracker;
	}

}