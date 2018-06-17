package com.july.backend.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.july.backend.models.Books;
import com.july.backend.service.BookService;

@RestController
public class BookAPIController {

	@Autowired
	private BookService bookService;

	@RequestMapping(value = "/api/books/all", method = RequestMethod.GET)
	public ResponseEntity<?> getAllBook() {
		List<Books> list = null;
		list = bookService.listBooks();
		System.out.println("Getting list");
		return new ResponseEntity<List<Books>>(list, HttpStatus.OK);

	}
}
