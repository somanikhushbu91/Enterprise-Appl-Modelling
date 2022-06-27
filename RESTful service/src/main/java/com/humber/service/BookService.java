package com.humber.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.humber.model.Book;
import com.humber.respository.BookRepository;

@Service
public class BookService {
	
	@Autowired

	private BookRepository bookRepository;

	public List<Book> getAllBooks() {

		List<Book> books = new ArrayList<Book>();

		books = (List<Book>) bookRepository.findAll();

		return books;

	}

	public Book getBook(int id) {

		Optional<Book> book = bookRepository.findById(id);

		return book.orElseGet(null);

	}


	public void addBook(Book book) {

		bookRepository.save(book);

	}
	
	public void updateBook(Book book)
	{
		bookRepository.save(book);
	}
	
	public void deleteBook(int id) {
		bookRepository.deleteById(id);
	}

}
