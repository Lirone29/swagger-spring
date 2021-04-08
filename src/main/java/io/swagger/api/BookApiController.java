package io.swagger.api;

import io.swagger.annotations.ApiParam;
import io.swagger.model.Book;
import io.swagger.model.BookPath;
import io.swagger.model.Books;
import io.swagger.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-04-08T08:21:17.323Z[GMT]")
@RestController
public class BookApiController implements BookApi {

    @Autowired
    private BookService bookService;

    private static final Logger log = LoggerFactory.getLogger(BookApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public BookApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

   // public ResponseEntity<Book> addBook(@ApiParam(value = "Record object that needs to be added to the shelf", required = true) @RequestBody Book book) {

    public ResponseEntity<Book> addBook(@NotNull @Parameter(in = ParameterIn.QUERY, description = "Book object" ,required=true,schema=@Schema()) Book book) {
        //String accept = request.getHeader("Accept");

        /*if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Book>(objectMapper.readValue("{\n  \"year\" : 6,\n  \"author\" : \"author\",\n  \"id\" : 0,\n  \"title\" : \"title\",\n  \"info\" : \"info\"\n}", Book.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Book>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Book>(HttpStatus.NOT_IMPLEMENTED);

         */
        System.out.println("In the middle of creation " + book.getTitle());


        //return new ResponseEntity<Book>(bookService.addBook(book),HttpStatus.OK);
        return ResponseEntity.ok(bookService.addBook(book));
    }

    public ResponseEntity<Void> deleteBook(@Parameter(in = ParameterIn.PATH, description = "Book id to delete", required=true, schema=@Schema()) @PathVariable("bookId") Long bookId,@Parameter(in = ParameterIn.HEADER, description = "" ,schema=@Schema()) @RequestHeader(value="api_key", required=false) String apiKey) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Resource> dwonloadBook(@Parameter(in = ParameterIn.PATH, description = "ID of book to update", required=true, schema=@Schema()) @PathVariable("bookId") Long bookId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Resource>(objectMapper.readValue("\"\"", Resource.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Resource>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Resource>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Book>> findBooksByAuthor(@Parameter(in = ParameterIn.PATH, description = "Author values that need to be considered for filter", required=true, schema=@Schema()) @PathVariable("author") String author) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Book>>(objectMapper.readValue("[ {\n  \"year\" : 6,\n  \"author\" : \"author\",\n  \"id\" : 0,\n  \"title\" : \"title\",\n  \"info\" : \"info\"\n}, {\n  \"year\" : 6,\n  \"author\" : \"author\",\n  \"id\" : 0,\n  \"title\" : \"title\",\n  \"info\" : \"info\"\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Book>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Book>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Book>> findBooksByTitle(@Parameter(in = ParameterIn.PATH, description = "Title values that need to be considered for filter", required=true, schema=@Schema()) @PathVariable("title") String title) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Book>>(objectMapper.readValue("[ {\n  \"year\" : 6,\n  \"author\" : \"author\",\n  \"id\" : 0,\n  \"title\" : \"title\",\n  \"info\" : \"info\"\n}, {\n  \"year\" : 6,\n  \"author\" : \"author\",\n  \"id\" : 0,\n  \"title\" : \"title\",\n  \"info\" : \"info\"\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Book>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Book>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Book>> findBooksByUsername(@Parameter(in = ParameterIn.PATH, description = "Username values that need to be considered for filter", required=true, schema=@Schema()) @PathVariable("username") String username) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Book>>(objectMapper.readValue("[ {\n  \"year\" : 6,\n  \"author\" : \"author\",\n  \"id\" : 0,\n  \"title\" : \"title\",\n  \"info\" : \"info\"\n}, {\n  \"year\" : 6,\n  \"author\" : \"author\",\n  \"id\" : 0,\n  \"title\" : \"title\",\n  \"info\" : \"info\"\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Book>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Book>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Books> getAllBooks() {
        String accept = request.getHeader("Accept");

       /* if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Book>>(objectMapper.readValue("[ {\n  \"year\" : 6,\n  \"author\" : \"author\",\n  \"id\" : 0,\n  \"title\" : \"title\",\n  \"info\" : \"info\"\n}, {\n  \"year\" : 6,\n  \"author\" : \"author\",\n  \"id\" : 0,\n  \"title\" : \"title\",\n  \"info\" : \"info\"\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Book>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Book>>(HttpStatus.NOT_IMPLEMENTED);

        */
        Books sts = new Books();
        sts.setBooks(bookService.findAllBooks());
        return ResponseEntity.ok(sts);
    }

    public ResponseEntity<Book> getBookById(@Parameter(in = ParameterIn.PATH, description = "ID of book to return", required=true, schema=@Schema()) @PathVariable("bookId") Long bookId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Book>(objectMapper.readValue("{\n  \"year\" : 6,\n  \"author\" : \"author\",\n  \"id\" : 0,\n  \"title\" : \"title\",\n  \"info\" : \"info\"\n}", Book.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Book>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Book>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<String> readBook(@Parameter(in = ParameterIn.PATH, description = "ID of book to display", required=true, schema=@Schema()) @PathVariable("bookId") Long bookId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<String>(objectMapper.readValue("\"\"", String.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<String>(HttpStatus.NOT_IMPLEMENTED);
    }

    //public ResponseEntity<Book> updateBook(@NotNull @Parameter(in = ParameterIn.QUERY, description = "Book object" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "book", required = true) Book book) {
    public ResponseEntity<Book> updateBook(@NotNull @Parameter(in = ParameterIn.QUERY, description = "Book object" ,required=true,schema=@Schema()) Book book) {
        String accept = request.getHeader("Accept");
        /*if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Book>(objectMapper.readValue("{\n  \"year\" : 6,\n  \"author\" : \"author\",\n  \"id\" : 0,\n  \"title\" : \"title\",\n  \"info\" : \"info\"\n}", Book.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Book>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Book>(HttpStatus.NOT_IMPLEMENTED);

         */

        System.out.println("In the middle of creation " + book.getTitle());
        return ResponseEntity.ok(bookService.updateBook(book));

    }

    public ResponseEntity<Book> uploadBookFile(@Parameter(in = ParameterIn.PATH, description = "ID of book to update", required=true, schema=@Schema()) @PathVariable("bookId") Long bookId,@NotNull @Parameter(in = ParameterIn.QUERY, description = "Path of book to be uploaded" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "bookPath", required = true) BookPath bookPath) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Book>(objectMapper.readValue("{\n  \"year\" : 6,\n  \"author\" : \"author\",\n  \"id\" : 0,\n  \"title\" : \"title\",\n  \"info\" : \"info\"\n}", Book.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Book>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Book>(HttpStatus.NOT_IMPLEMENTED);
    }

}
