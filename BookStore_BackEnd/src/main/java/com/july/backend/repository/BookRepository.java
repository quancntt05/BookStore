package com.july.backend.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.july.backend.models.Books;
import java.lang.String;
import com.july.backend.models.Category;
import java.lang.Integer;

public interface BookRepository extends Repository<Books, Integer>{
	List<Books> listBooks();
	List<Books> findByAuthor(String author);
	List<Books> findByCategory(Category category);
	Books findById(Integer id);
	void addBook(Books book);
	
}
