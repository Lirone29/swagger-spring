package io.swagger.service;

import io.swagger.model.Book;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface BookService {

    public Book addBook(Book book);
    public void deleteBookById(long rollNo);
    public List<Book> findAllBooks();
    public Book updateBook(Book book);
    @Cacheable("books")
    public Book findBookById(long id);

   // @Cacheable("books")
    //public List<Book> findBookByTitle(String title);

}
