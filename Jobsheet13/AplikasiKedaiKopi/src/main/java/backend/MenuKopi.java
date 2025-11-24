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

public class MenuKopi {
    private int idMenu;
    private String namaMenu;
    private Kategori kategori = new Kategori(); // Relasi ke Kategori
    private double harga;
    private int stok;

    public MenuKopi() {}

    public int getIdMenu() { return idMenu; }
    public void setIdMenu(int idMenu) { this.idMenu = idMenu; }
    public String getNamaMenu() { return namaMenu; }
    public void setNamaMenu(String namaMenu) { this.namaMenu = namaMenu; }
    public Kategori getKategori() { return kategori; }
    public void setKategori(Kategori kategori) { this.kategori = kategori; }
    public double getHarga() { return harga; }
    public void setHarga(double harga) { this.harga = harga; }
    public int getStok() { return stok; }
    public void setStok(int stok) { this.stok = stok; }

    public MenuKopi getById(int id) {
        MenuKopi mk = new MenuKopi();
        String sql = "SELECT m.*, k.nama_kategori FROM tbl_menu m LEFT JOIN tbl_kategori k ON m.id_kategori = k.id_kategori WHERE m.id_menu = " + id;
        ResultSet rs = DBHelper.selectQuery(sql);
        try {
            while (rs.next()) {
                mk = new MenuKopi();
                mk.setIdMenu(rs.getInt("id_menu"));
                mk.setNamaMenu(rs.getString("nama_menu"));
                mk.getKategori().setIdKategori(rs.getInt("id_kategori"));
                mk.getKategori().setNamaKategori(rs.getString("nama_kategori"));
                mk.setHarga(rs.getDouble("harga"));
                mk.setStok(rs.getInt("stok"));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return mk;
    }

    public ArrayList<MenuKopi> getAll() {
        ArrayList<MenuKopi> list = new ArrayList();
        String sql = "SELECT m.*, k.nama_kategori FROM tbl_menu m LEFT JOIN tbl_kategori k ON m.id_kategori = k.id_kategori ORDER BY id_menu ASC";
        ResultSet rs = DBHelper.selectQuery(sql);
        try {
            while (rs.next()) {
                MenuKopi mk = new MenuKopi();
                mk.setIdMenu(rs.getInt("id_menu"));
                mk.setNamaMenu(rs.getString("nama_menu"));
                mk.getKategori().setIdKategori(rs.getInt("id_kategori"));
                mk.getKategori().setNamaKategori(rs.getString("nama_kategori"));
                mk.setHarga(rs.getDouble("harga"));
                mk.setStok(rs.getInt("stok"));
                list.add(mk);
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    public void save() {
        if (idMenu == 0) {
            String SQL = "INSERT INTO tbl_menu (nama_menu, id_kategori, harga, stok) VALUES('" 
                    + this.namaMenu + "', " + this.kategori.getIdKategori() + ", " + this.harga + ", " + this.stok + ")";
            this.idMenu = DBHelper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE tbl_menu SET nama_menu = '" + this.namaMenu + "', id_kategori = " + this.kategori.getIdKategori() 
                    + ", harga = " + this.harga + ", stok = " + this.stok + " WHERE id_menu = " + this.idMenu;
            DBHelper.executeQuery(SQL);
        }
    }

    public void delete() {
        DBHelper.executeQuery("DELETE FROM tbl_menu WHERE id_menu = " + this.idMenu);
    }

    public void kurangiStok(int qty) {
        DBHelper.executeQuery("UPDATE tbl_menu SET stok = stok - " + qty + " WHERE id_menu = " + this.idMenu);
    }
    
    @Override
    public String toString() { return namaMenu; }
}