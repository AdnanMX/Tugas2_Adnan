package adnanmaulana.pencatatan.buku.repository;

import adnanmaulana.pencatatan.buku.entity.Book;

public interface BookRepository {
    
    // Add
    public void add(Book book);

    // Get All
    public Book[] getAll();

    //Get By Id
    public Book getById(Integer id);

    // Update
    public boolean update(Book book);

    // Delete
    public boolean delete(Integer id);
}
