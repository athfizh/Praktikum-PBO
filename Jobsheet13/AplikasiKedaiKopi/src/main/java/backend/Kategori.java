/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author H A F I Z H
 */
    
public class Kategori {
    private int idKategori;
    private String namaKategori;

    public Kategori() {}

    public int getIdKategori() { return idKategori; }
    public void setIdKategori(int idKategori) { this.idKategori = idKategori; }
    public String getNamaKategori() { return namaKategori; }
    public void setNamaKategori(String namaKategori) { this.namaKategori = namaKategori; }

    public Kategori getById(int id) {
        Kategori kat = new Kategori();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM tbl_kategori WHERE id_kategori = " + id);
        try {
            while (rs.next()) {
                kat.setIdKategori(rs.getInt("id_kategori"));
                kat.setNamaKategori(rs.getString("nama_kategori"));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return kat;
    }

    public ArrayList<Kategori> getAll() {
        ArrayList<Kategori> list = new ArrayList();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM tbl_kategori ORDER BY id_kategori ASC");
        try {
            while (rs.next()) {
                Kategori kat = new Kategori();
                kat.setIdKategori(rs.getInt("id_kategori"));
                kat.setNamaKategori(rs.getString("nama_kategori"));
                list.add(kat);
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    public void save() {
        if (idKategori == 0) {
            String SQL = "INSERT INTO tbl_kategori (nama_kategori) VALUES ('" + this.namaKategori + "')";
            this.idKategori = DBHelper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE tbl_kategori SET nama_kategori = '" + this.namaKategori + "' WHERE id_kategori = " + this.idKategori;
            DBHelper.executeQuery(SQL);
        }
    }

    public void delete() {
        DBHelper.executeQuery("DELETE FROM tbl_kategori WHERE id_kategori = " + this.idKategori);
    }
    
    @Override
    public String toString() { return namaKategori; }
}