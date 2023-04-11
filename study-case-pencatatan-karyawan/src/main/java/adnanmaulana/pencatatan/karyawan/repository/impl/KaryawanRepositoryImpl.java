package adnanmaulana.pencatatan.karyawan.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import adnanmaulana.pencatatan.karyawan.entity.Karyawan;
import adnanmaulana.pencatatan.karyawan.repository.KaryawanRepository;

public class KaryawanRepositoryImpl implements KaryawanRepository {

    private DataSource dataSource;

    public KaryawanRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void add(Karyawan karyawan) {
        // Query
        String sql = "INSERT INTO karyawan(nama,jabatan,gaji) VALUES (?,?,?)";

        // Execute / Handle Write To Database
        try (Connection connection = dataSource.getConnection(); 
                PreparedStatement statement = connection.prepareStatement(sql)) {
                
            // Set Value
            // setString(Index, value)
            statement.setString(1, karyawan.getNama());
            statement.setString(2, karyawan.getJabatan());
            statement.setInt(3, karyawan.getGaji());

            // Execute
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Karyawan[] getAll() {
        // Query
        String query = "SELECT id, nama, jabatan, gaji FROM karyawan";

        // Execute / Handle Select From Database
        try (Connection connection = dataSource.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query)) {

            // Initialize
            List<Karyawan> list = new ArrayList<Karyawan>();

            while (resultSet.next()) {
                // Initialize
                Karyawan karyawan = new Karyawan();

                // Set Value 
                karyawan.setId(resultSet.getInt("id"));
                karyawan.setNama(resultSet.getString("nama"));
                karyawan.setJabatan(resultSet.getString("jabatan"));
                karyawan.setGaji(resultSet.getInt("gaji"));

                // Add Karyawan To List Of Karyawan
                list.add(karyawan);

            }

            // Return List
            return list.toArray(new Karyawan[] {});
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Karyawan getById(Integer id) {
        // Query
        String query = "SELECT id, nama, jabatan, gaji FROM karyawan WHERE id = ?"; 

        // Execute / Handle Select From Database
        try (Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(query)) {
            
            // Set Value 
            statement.setInt(1, id);

            //Execute
            try (ResultSet resultSet = statement.executeQuery();) {
            // Intialize
            Karyawan karyawan = new Karyawan();

            while (resultSet.next()) {
                // Set Value From Database
                karyawan.setId(resultSet.getInt("id"));
                karyawan.setNama(resultSet.getString("nama"));
                karyawan.setJabatan(resultSet.getString("jabatan"));
                karyawan.setGaji(resultSet.getInt("gaji"));
            }

            // Return Karyawan
            return karyawan;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(Karyawan karyawan) {
        // Query
        String query = "UPDATE karyawan SET nama = ?, jabatan = ?, gaji = ? WHERE id = ?";
    
        // Execute / Handle Update To Database
        try (Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(query)) {
    
            // Set Value
            statement.setString(1, karyawan.getNama());
            statement.setString(2, karyawan.getJabatan());
            statement.setInt(3, karyawan.getGaji());
            statement.setInt(4, karyawan.getId());
    
            // Execute
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
    
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(Integer id) {
        // Query
        String query = "DELETE FROM karyawan WHERE id = ?";
    
        try (Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(query)) {
    
            // Set Value
            statement.setInt(1, id);
    
            // Execute
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
    
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}
