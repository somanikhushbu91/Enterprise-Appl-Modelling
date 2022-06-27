package com.humber.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.humber.model.Book;
import com.humber.service.BookService;

@RestController
public class BookController {
	
	@Autowired
	BookService bookservice;
	
	@GetMapping("/books")
	public List<Book> getAllBooks() {
		
		List<Book> books = new ArrayList<Book>();
		books = (List<Book>) bookservice.getAllBooks();
		return books;
	}

	@GetMapping("/books/{id}")
	public Book getBook(@PathVariable("id") int bookId) {
		return bookservice.getBook(bookId);
	}
	
	@PostMapping("/books")
	public void addBook(@RequestBody Book book) {
		bookservice.addBook(book);
	}
	
	@PutMapping("/books/{id}")
	public void updateBook(@PathVariable("id") int bookId, @RequestBody Book book) {
		bookservice.updateBook(book);
	}
	
	@DeleteMapping("books/{id}")
	public void deleteBook(@PathVariable("id") int bookId) {
		bookservice.deleteBook(bookId);
	}
	
}
