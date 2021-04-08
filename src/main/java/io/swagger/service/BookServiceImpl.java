package io.swagger.service;

import io.swagger.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteBookById(long id) {

        Optional<Book> os = bookRepository.findById(id);
        if(os.isPresent()) bookRepository.deleteById(id);
        //return os.get();
    }

    @Override
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book updateBook(Book book) {

        System.out.println("In repository");
        bookRepository.updateBookById(book.getTitle(),book.getAuthor(), book.getInfo(),  book.getYear(), book.getId());
        return book;
    }

    @Override
    public Book findBookById(long id) {

        Optional<Book> os = bookRepository.findById(id);
        if(os.isPresent()) return os.get();
        else return null;
    }

    /*
    @Override
    public List<Book> findBookByTitle(String title) {
        return bookRepository.findBookByTitle(title);
        //return book;
    }


     */

}
