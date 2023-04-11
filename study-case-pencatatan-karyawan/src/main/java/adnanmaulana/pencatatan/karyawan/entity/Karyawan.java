package adnanmaulana.pencatatan.karyawan.entity;

public class Karyawan {
    
     // Atribut
     private Integer id;

     private String nama;
 
     private String jabatan;
 
     private Integer gaji;
 
     // Constructor
     public Karyawan() {
 
     }
 
     public Karyawan(Integer id, String nama, String jabatan, Integer gaji) {
         this.id = id;
         this.nama = nama;
         this.jabatan = jabatan;
         this.gaji = gaji;
     }
     
     public Karyawan(String nama, String jabatan, Integer gaji) {
         this.nama = nama;
         this.jabatan = jabatan;
         this.gaji = gaji;
     }
 
     // Getter
     public Integer getId() {
         return id;
     }
 
     public String getNama() {
         return nama;
     }
 
     public String getJabatan() {
         return jabatan;
     }
 
     public Integer getGaji() {
         return gaji;
     }
 
     // Setter
     public void setId(Integer id) {
         this.id = id;
     }
 
     public void setNama(String nama) {
         this.nama = nama;
     }
 
     public void setJabatan(String jabatan) {
         this.jabatan = jabatan;
     }
 
     public void setGaji(Integer gaji) {
         this.gaji = gaji;
     }
}
