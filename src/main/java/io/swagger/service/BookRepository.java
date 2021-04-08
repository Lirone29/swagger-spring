package io.swagger.service;

import io.swagger.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Modifying
    @Query("update Book b set b.title = ?1, b.author = ?2, b.info = ?3, b.year = ?4 where b.id = ?5")
    void updateBookById(String title, String author, String info, Long year, Long id);


    @Modifying
    @Query("update Book b set b.title = ?1, b.author = ?2, b.info = ?3, b.year = ?4 where b.id = ?5")
    void updateBookById(String title, String author, String info, String year, Long id);

    @Modifying
    @Query("update Book b set b.title = ?1, b.author = ?2, b.info = ?3, b.year = ?4 where b.id = ?5")
    void updateBookById(String title, String author, String info, String year, String id);

    //@Modifying
    //@Query("SELECT b FROM books b where b.id = ?1")
    //List<Book> findBookByTitle(String title);
}
