package adnanmaulana.pencatatan.karyawan.service.impl;

import adnanmaulana.pencatatan.karyawan.entity.Karyawan;
import adnanmaulana.pencatatan.karyawan.repository.KaryawanRepository;
import adnanmaulana.pencatatan.karyawan.service.KaryawanService;

public class KaryawanServiceImpl implements KaryawanService {

    private KaryawanRepository karyawanRepository;

    public KaryawanServiceImpl(KaryawanRepository karyawanRepository) {
        this.karyawanRepository = karyawanRepository;
    }

    @Override
    public void add(String nama, String jabatan, Integer gaji) {
       // Initialize
       Karyawan karyawan = new Karyawan(nama, jabatan, gaji);

       // Add Karyawan
       karyawanRepository.add(karyawan);

       // Return
       System.out.println("Karyawan Added Succesfully : " + karyawan.getNama());
    }

    @Override
    public void getAll() {
        // Initialize
        Karyawan[] list = karyawanRepository.getAll();
    
        // Return
        System.out.println("========================================================");
        System.out.println("| ID |        Nama        |     Jabatan     |   Gaji   |");
        System.out.println("========================================================");
        for (Karyawan karyawan : list) {
            System.out.println(String.format("| %2d | %-18s | %-15s | %8d |", karyawan.getId(), karyawan.getNama(), karyawan.getJabatan(), karyawan.getGaji()));
        }
        System.out.println("========================================================");
    }
    
    @Override
    public void getById(Integer id) {
        // Get Data
        Karyawan karyawan = karyawanRepository.getById(id);
    
        if (karyawan != null) {
        // Return
        System.out.println("========================================================");
        System.out.println("| ID |        Nama        |     Jabatan     |   Gaji   |");
        System.out.println("========================================================");
        System.out.println(String.format("| %2d | %-18s | %-15s | %8d |", karyawan.getId(), karyawan.getNama(), karyawan.getJabatan(), karyawan.getGaji()));
        System.out.println("========================================================");
        } else {
            System.out.println("Karyawan With ID " + id + " Not Found");
        }
    }     

    @Override
    public void update(Integer id, String nama, String jabatan, Integer gaji) {
        // Initialize
        Karyawan karyawan = new Karyawan(id, nama, jabatan, gaji);

        // Update Karyawan
        karyawanRepository.update(karyawan);

        // Return
        System.out.println("Karyawan Updated Succesfully : " + karyawan.getNama());
    }

    @Override
    public void delete(Integer id) {
        // Delete Data
        boolean succes = karyawanRepository.delete(id); //true or false

        if (succes) {
            // Return
            System.out.println("Karyawan Deleted Successfully : " + id);
        } else {
            // Return
            System.out.println("Failed To Deleted Karyawan : " + id);

        }
    }
}
