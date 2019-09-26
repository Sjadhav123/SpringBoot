package com.silicus.librabrymanagment.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BookIssueTracker")
public class BookIssueTracker {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "issueTracker_Id", nullable = false)
	private int id;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="book_Id",referencedColumnName="book_Id")
	private Book book;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="user_Id",referencedColumnName="user_Id") 
	private User user;

	@Column(name = "DateOfIssue", nullable = false)
	private String dateOfIssue;
	@Column(name = "ExpDate", nullable = false)
	private String expDate;
	@Column(name = "Issuer", nullable = false)
	private String issuer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDateOfIssue() {
		return dateOfIssue;
	}

	public void setDateOfIssue(String dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public String getIssuer() {
		return issuer;
	}

	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		BookIssueTracker other = (BookIssueTracker) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BookIssueTracker [id=" + id + ", book=" + book + ", user=" + user + ", dateOfIssue=" + dateOfIssue
				+ ", expDate=" + expDate + ", issuer=" + issuer + "]";
	}

	

}
