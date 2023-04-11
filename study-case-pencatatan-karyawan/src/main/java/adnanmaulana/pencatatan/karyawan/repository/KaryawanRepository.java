package adnanmaulana.pencatatan.karyawan.repository;

import adnanmaulana.pencatatan.karyawan.entity.Karyawan;

public interface KaryawanRepository {
     // Add
     public void add(Karyawan karyawan);

     // Get All
     public Karyawan[] getAll();
 
     //Get By Id
     public Karyawan getById(Integer id);
 
     // Update
     public boolean update(Karyawan karyawan);
 
     // Delete
     public boolean delete(Integer id);
}
