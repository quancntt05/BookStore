package com.july.backend.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.july.backend.models.Books;
import com.july.backend.service.BookService;

@RestController
@RequestMapping(value = "/api/books")
public class BookAPIController {

	@Autowired
	private BookService bookService;

	@RequestMapping(value = "all")
	public ResponseEntity<?> getAllBook() {
		List<Books> list = new ArrayList<>();
		list = bookService.listBooks();
		return new ResponseEntity<List<Books>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "author", method=RequestMethod.POST)
	public @ResponseBody ResponseEntity<?> getBooksByAuthor(@RequestParam("name") String author) {
		List<Books> list = new ArrayList<>();
		list = bookService.findByAuthor(author);
		return new ResponseEntity<List<Books>>(list, HttpStatus.OK);
	}
}
