package adnanmaulana.pencatatan.buku.view;

import adnanmaulana.pencatatan.buku.service.BookService;
import adnanmaulana.pencatatan.buku.util.InputUtil;

public class BookView {
    
    // Book Service
    private BookService bookService;

    public BookView(BookService bookService) {
        this.bookService = bookService;
    }

    // Show Menu
    public void showMenu() {
        while (true) {
            System.out.println("========== MAIN MENU ==========");
            System.out.println("1. Insert Data");
            System.out.println("2. Update Data");
            System.out.println("3. Show Data");
            System.out.println("4. Show Data By ID");
            System.out.println("5. Delete Data");
            System.out.println("X. Exit");

            String input = InputUtil.input("Choose >");

            if(input.equals("1")) {
                insertData();
            } else if (input.equals("2")) {
                updateData();
            } else if (input.equals("3")) {
                showData();
            } else if (input.equals("4")) {
                showDataById();
            } else if (input.equals("5")) {
                deleteData();
            } else if (input.equals("X")) {
                break;
            } else {
                System.out.println("Option doesn't recognized");
            }
        }
    }

    // Insert Data
    public void insertData() {
        // Menu
        System.out.println("========== INSERT DATA ==========");

        // Get Data Input
        String title = InputUtil.input("Title");
        String author = InputUtil.input("Author");
        String year = InputUtil.input("Year");

        // Add Data
        bookService.add(title, author, Integer.valueOf(year));
    }

    // Update Data
    public void updateData() {
        // Menu
        System.out.println("========== UPDATE DATA ==========");
    
        // Get Data Input
        String id = InputUtil.input("ID");
        String title = InputUtil.input("Title");
        String author = InputUtil.input("Author");
        String year = InputUtil.input("Year");
    
        // Update Data
        bookService.update(Integer.valueOf(id), title, author, Integer.valueOf(year));
    }

    // Show Data
    public void showData() {
        // Menu
        System.out.println("========== SHOW DATA ==========");
        
        // Get Data
        bookService.getAll();

    }

    // Show Data By ID
    public void showDataById() {
        // Menu
        System.out.println("========== SHOW DATA BY ID ==========");
    
        // Get Data Input
        String id = InputUtil.input("ID");
    
        // Get Data
        bookService.getById(Integer.valueOf(id));
    }

    // Delete Data
    public void deleteData() {
        // Menu
        System.out.println("========== DELETE DATA ==========");
    
        // Get Data Input
        String id = InputUtil.input("ID");
    
        // Delete Data
        bookService.delete(Integer.valueOf(id));
    }
    
}
