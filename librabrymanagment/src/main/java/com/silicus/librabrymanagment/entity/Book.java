package com.silicus.librabrymanagment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="BOOK")
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id", nullable = false)
	private long id;
	@Column(name="Name", nullable = false)
	private String name;
	@Column(name="Author", nullable = false)
	private String author;
	@Column(name="Isbn", nullable = false)
	private String isbn;
	@Column(name="RackName", nullable = false)
	private String rackName;
	@Column(name="IsAvailable", nullable = false)
	private boolean isAvailable;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "issueTracker_id", nullable = false)
	private BookIssueTracker bookIssueTracker;
	
	public long getId() {
		
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

	public String getRackName() {
		return rackName;
	}
	public void setRackName(String rackName) {
		this.rackName = rackName;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public BookIssueTracker getBookIssueTracker() {
		return bookIssueTracker;
	}
	public void setBookIssueTracker(BookIssueTracker bookIssueTracker) {
		this.bookIssueTracker = bookIssueTracker;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", ISBN=" + isbn + ", rackName=" + rackName
				+ ", isAvailable=" + isAvailable + "]";
	}
	
	
	
	
	


}
