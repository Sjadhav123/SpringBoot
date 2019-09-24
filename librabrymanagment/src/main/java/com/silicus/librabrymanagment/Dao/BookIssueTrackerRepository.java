package com.silicus.librabrymanagment.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.silicus.librabrymanagment.entity.BookIssueTracker;

public interface BookIssueTrackerRepository extends JpaRepository<BookIssueTracker, Long>{

}
