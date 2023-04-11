package adnanmaulana.pencatatan.buku.service.impl;

import adnanmaulana.pencatatan.buku.entity.Book;
import adnanmaulana.pencatatan.buku.repository.BookRepository;
import adnanmaulana.pencatatan.buku.service.BookService;

public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void add(String title, String author, Integer year) {
       // Initialize
       Book book = new Book(title, author, year);

       // Add Book
       bookRepository.add(book);

       // Return
       System.out.println("Book Added Succesfully : " + book.getTitle());
    }

    @Override
    public void getAll() {
        // Initialize
        Book[] list = bookRepository.getAll();

        // Return
        for (Book book : list) {
            // 1. Nanti Kita Cerita Hari Ini -- (Orang - 2022)
            System.out.println(String.format("%d. %s -- (%s - %d)", book.getId(), book.getTitle(), book.getAuthor(), 
                    book.getYear()));
        }
    }

    @Override
    public void getById(Integer id) {
        // Get Data
        Book book = bookRepository.getById(id);

        // Return
        System.out.println(String.format("%d. %s -- (%s - %d)", book.getId(), book.getTitle(), book.getAuthor(), 
                book.getYear()));
    }    

    @Override
    public void update(Integer id, String title, String author, Integer year) {
        // Initialize
        Book book = new Book(id, title, author, year);

        // Update Book
        bookRepository.update(book);

        // Return
        System.out.println("Book Updated Succesfully : " + book.getTitle());
    }

    @Override
    public void delete(Integer id) {
        // Delete Data
        boolean succes = bookRepository.delete(id); //true or false

        if (succes) {
            // Return
            System.out.println("Book Deleted Successfully : " + id);
        } else {
            // Return
            System.out.println("Failed To Deleted Book : " + id);

        }
    }
    
}
