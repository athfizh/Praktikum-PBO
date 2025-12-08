package backend;
import java.sql.*;

public class DBHelper {
    private static Connection koneksi;

    public static void bukaKoneksi() {
        if (koneksi == null) {
            try {
                String url = "jdbc:postgresql://localhost:5432/db_kedai_kopi";
                String user = "postgres";
                String password = "kepanjen45"; 
                
                DriverManager.registerDriver(new org.postgresql.Driver());
                koneksi = DriverManager.getConnection(url, user, password);
            } catch (SQLException t) {
                System.out.println("Error koneksi PostgreSQL!");
                t.printStackTrace();
            }
        }
    }

    public static int insertQueryGetId(String query) {
        bukaKoneksi();
        int num = 0; int result = -1;
        try {
            Statement stmt = koneksi.createStatement();
            num = stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) result = rs.getInt(1); // Mengambil ID serial
            rs.close(); stmt.close();
        } catch (Exception e) { e.printStackTrace(); }
        return result;
    }

    public static boolean executeQuery(String query) {
        bukaKoneksi();
        try {
            Statement stmt = koneksi.createStatement();
            stmt.executeUpdate(query);
            stmt.close(); return true;
        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }

    public static ResultSet selectQuery(String query) {
        bukaKoneksi();
        try {
            Statement stmt = koneksi.createStatement();
            return stmt.executeQuery(query);
        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }
}