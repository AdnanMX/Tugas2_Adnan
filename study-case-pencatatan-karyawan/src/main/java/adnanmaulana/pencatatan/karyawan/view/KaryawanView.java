package adnanmaulana.pencatatan.karyawan.view;

import adnanmaulana.pencatatan.karyawan.service.KaryawanService;
import adnanmaulana.pencatatan.karyawan.util.InputUtil;

public class KaryawanView {

    // Karyawan Service
    private KaryawanService karyawanService;

    public KaryawanView(KaryawanService karyawanService) {
        this.karyawanService = karyawanService;
    }

    // Login Menu
    public void loginMenu() {

        System.out.println("===============================");
        System.out.println("|          LOGIN MENU         |");
        System.out.println("===============================");
        String username = InputUtil.input("Username >");
        String password = InputUtil.input("Password >");


        // Autentikasi user
        if (username.equals("user") && password.equals("user")) {
            // Show user menu
            showUserMenu();
        } else if (username.equals("admin") && password.equals("admin")) {
            // Show admin menu
            showAdminMenu();
        } else {
            System.out.println("Username or Password Is Wrong");
            // Return
            loginMenu();
        }
    }

    // Show User Menu
    public void showUserMenu() {

        while(true){
            System.out.println("==============================");
            System.out.println("|          USER MENU         |");
            System.out.println("==============================");
            System.out.println("| Options:                   |");
            System.out.println("| 1. Show Data               |");
            System.out.println("| 2. Show Data By ID         |");
            System.out.println("| X. Exit                    |");
            System.out.println("==============================");

            String input = InputUtil.input("Choose >");

            if (input.equals("1")) {
                showData();
            } else if (input.equals("2")) {
                showDataById();
            } else if (input.equalsIgnoreCase("X")) {
                break;
            } else {
                System.out.println("Option Doesn't Recognized");
            }
        }
    }
    // Show Admin Menu
    public void showAdminMenu() {
        while (true) {
            System.out.println("===============================");
            System.out.println("|          ADMIN MENU         |");
            System.out.println("===============================");
            System.out.println("| Options:                    |");
            System.out.println("| 1. Insert Data              |");
            System.out.println("| 2. Update Data              |");
            System.out.println("| 3. Show Data                |");
            System.out.println("| 4. Show Data By ID          |");
            System.out.println("| 5. Delete Data              |");
            System.out.println("| X. Exit                     |");
            System.out.println("===============================");

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
                System.out.println("Option Doesn't Recognized");
            }
        }
    }

    // Insert Data
    public void insertData() {
        // Menu
        System.out.println("================================");
        System.out.println("|          INSERT DATA         |");
        System.out.println("================================");

        // Get Data Input
        String nama = InputUtil.input("Nama");
        String jabatan = InputUtil.input("Jabatan");
        String gaji = InputUtil.input("Gaji");

        // Add Data
        karyawanService.add(nama, jabatan, Integer.valueOf(gaji));
    }

    // Update Data
    public void updateData() {
        // Menu
        System.out.println("================================");
        System.out.println("|          UPDATE DATA         |");
        System.out.println("================================");
    
        // Get Data Input
        String id = InputUtil.input("ID");
        String nama = InputUtil.input("Nama");
        String jabatan = InputUtil.input("Jabatan");
        String gaji = InputUtil.input("Gaji");
    
        // Update Data
        karyawanService.update(Integer.valueOf(id), nama, jabatan, Integer.valueOf(gaji));
    }

    // Show Data
    public void showData() {
        // Menu
        System.out.println("==============================");
        System.out.println("|          SHOW DATA         |");
        System.out.println("==============================");
        
        // Get Data
        karyawanService.getAll();

    }

    // Show Data By ID
    public void showDataById() {
        // Menu
        System.out.println("====================================");
        System.out.println("|          SHOW DATA BY ID         |");
        System.out.println("====================================");
    
        // Get Data Input
        String id = InputUtil.input("ID");
    
        // Get Data
        karyawanService.getById(Integer.valueOf(id));
    }

    // Delete Data
    public void deleteData() {
        // Menu
        System.out.println("================================");
        System.out.println("|          DELETE DATA         |");
        System.out.println("================================");
    
        // Get Data Input
        String id = InputUtil.input("ID");
    
        // Delete Data
        karyawanService.delete(Integer.valueOf(id));
    }
    
}
