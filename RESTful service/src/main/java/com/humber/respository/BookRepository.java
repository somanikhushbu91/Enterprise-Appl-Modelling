package com.humber.respository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.humber.model.Book;

public interface BookRepository extends CrudRepository<Book, Integer>{

}
