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

public class User {
    private int idUser;
    private String username, password, role;

    public User() {}

    public int getIdUser() { return idUser; }
    public void setIdUser(int idUser) { this.idUser = idUser; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public ArrayList<User> getAll() {
        ArrayList<User> list = new ArrayList();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM tbl_user ORDER BY id_user ASC");
        try {
            while (rs.next()) {
                User u = new User();
                u.setIdUser(rs.getInt("id_user"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setRole(rs.getString("role"));
                list.add(u);
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    public void save() {
        if (idUser == 0) {
            String SQL = "INSERT INTO tbl_user (username, password, role) VALUES ('" + username + "','" + password + "','" + role + "')";
            this.idUser = DBHelper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE tbl_user SET username='" + username + "', password='" + password + "', role='" + role + "' WHERE id_user=" + idUser;
            DBHelper.executeQuery(SQL);
        }
    }

    public void delete() {
        DBHelper.executeQuery("DELETE FROM tbl_user WHERE id_user=" + idUser);
    }
}