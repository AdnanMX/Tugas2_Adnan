package adnanmaulana.pencatatan.buku.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.zaxxer.hikari.HikariDataSource;

import adnanmaulana.pencatatan.buku.entity.Book;
import adnanmaulana.pencatatan.buku.repository.impl.BookRepositoryImpl;
import adnanmaulana.pencatatan.buku.util.DatabaseUtil;

public class BookRepositoryImplTest {
    
    // Data Source
    private static HikariDataSource dataSource;

    // Book Repository
    private BookRepository bookRepository;

    @BeforeEach
    void setup() {
        dataSource = DatabaseUtil.getDataSource();
        bookRepository = new BookRepositoryImpl(dataSource);
    }

    @Test
    void testAddBook() {
        // Initialize
        Book book = new Book();

        // Set Value
        book.setTitle("Cahaya Ilahi");
        book.setAuthor("Pandu Islami");
        book.setYear(2021);

        // Add Book
        bookRepository.add(book);
    }

    @AfterEach
    void tearDown() {
        dataSource.close();
    }
}
