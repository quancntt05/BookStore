package com.july.backend.api;

import java.util.List;

import com.july.backend.models.Books;
import com.july.backend.service.BookService;

public class Controller {
	public static void main(String[] args) {
		BookService bookService = new BookService();
		List<Books> list = bookService.listBooks();
		for(Books book : list) {
			System.out.println(book.getNamebook());
		}
	}
}