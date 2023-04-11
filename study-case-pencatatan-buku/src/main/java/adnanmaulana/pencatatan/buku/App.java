package adnanmaulana.pencatatan.buku;

import javax.sql.DataSource;

import adnanmaulana.pencatatan.buku.repository.BookRepository;
import adnanmaulana.pencatatan.buku.repository.impl.BookRepositoryImpl;
import adnanmaulana.pencatatan.buku.service.BookService;
import adnanmaulana.pencatatan.buku.service.impl.BookServiceImpl;
import adnanmaulana.pencatatan.buku.util.DatabaseUtil;
import adnanmaulana.pencatatan.buku.view.BookView;

public class App 
{
    public static void main( String[] args ) {
        //  DataSource
        DataSource dataSource = DatabaseUtil.getDataSource();

        // Set DataSource
        BookRepository bookRepository = new BookRepositoryImpl(dataSource);
        BookService bookService = new BookServiceImpl(bookRepository);

        // View
        BookView bookView = new BookView(bookService);

        // Show View
        bookView.showMenu();
    }
}
