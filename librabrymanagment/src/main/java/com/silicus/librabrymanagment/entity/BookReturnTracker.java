package com.silicus.librabrymanagment.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class BookReturnTracker {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id", nullable = false)
	private int id;
	@Column(name="IssueId", nullable = false)
	private int issueId;
	@Column(name="ReturnDate", nullable = false)
	private String returnDate;

	@Override
	public String toString() {
		return "BookReturnTracker [id=" + id + ", issueId=" + issueId + ", returnDate=" + returnDate + ", receiver="
				+ receiver + ", fineAmount=" + fineAmount + "]";
	}
	
	@OneToOne(targetEntity=User.class,cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	private User receiver;
	@Column(name="FineAmount", nullable = false)
	private double fineAmount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIssueId() {
		return issueId;
	}

	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public User getReceiver() {
		return receiver;
	}

	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}

	public void setFineAmount(double fineAmount) {
		this.fineAmount = fineAmount;
	}

	public double getFineAmount() {
		return fineAmount;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(fineAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
		result = prime * result + issueId;
		result = prime * result + ((receiver == null) ? 0 : receiver.hashCode());
		result = prime * result + ((returnDate == null) ? 0 : returnDate.hashCode());
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
		BookReturnTracker other = (BookReturnTracker) obj;
		if (Double.doubleToLongBits(fineAmount) != Double.doubleToLongBits(other.fineAmount))
			return false;
		if (id != other.id)
			return false;
		if (issueId != other.issueId)
			return false;
		if (receiver == null) {
			if (other.receiver != null)
				return false;
		} else if (!receiver.equals(other.receiver))
			return false;
		if (returnDate == null) {
			if (other.returnDate != null)
				return false;
		} else if (!returnDate.equals(other.returnDate))
			return false;
		return true;
	}

}
