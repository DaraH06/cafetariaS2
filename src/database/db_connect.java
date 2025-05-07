/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author james
 */
public class db_connect {
    private static final String URL = "jdbc:mysql://localhost:3306/cafetaria"; // Pastikan "MySql" diubah menjadi "mysql"
    private static final String USER = "root";
    private static final String PASSWORD = ""; // Sesuaikan jika ada password

    public static Connection con() {
        Connection connection = null;
        try {
            // Pastikan driver MySQL di-load otomatis
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Koneksi Berhasil!");
        } catch (SQLException e) {
            System.out.println("Koneksi gagal: " + e.getMessage());
        }
        return connection;
    }
}
