package adnanmaulana.pencatatan.karyawan;

import javax.sql.DataSource;

import adnanmaulana.pencatatan.karyawan.repository.KaryawanRepository;
import adnanmaulana.pencatatan.karyawan.repository.impl.KaryawanRepositoryImpl;
import adnanmaulana.pencatatan.karyawan.service.KaryawanService;
import adnanmaulana.pencatatan.karyawan.service.impl.KaryawanServiceImpl;
import adnanmaulana.pencatatan.karyawan.util.DatabaseUtil;
import adnanmaulana.pencatatan.karyawan.view.KaryawanView;

public class App 
{
    public static void main( String[] args )
    {
        //  DataSource
        DataSource dataSource = DatabaseUtil.getDataSource();

        // Set DataSource
        KaryawanRepository karyawanRepository = new KaryawanRepositoryImpl(dataSource);
        KaryawanService karyawanService = new KaryawanServiceImpl(karyawanRepository);

        // View
        KaryawanView karyawanView = new KaryawanView(karyawanService);

        // Show View
        karyawanView.loginMenu();
    }
}
