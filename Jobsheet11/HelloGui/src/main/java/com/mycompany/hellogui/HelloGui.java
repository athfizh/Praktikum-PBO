/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.hellogui;

/**
 *
 * @author H A F I Z H
 */
import javax.swing.*;
public class HelloGui {

    public static void main(String[] args) {
        // TODO code application logic here
        JFrame frame;
        frame = new JFrame("ini percobaan HelloGui Frame");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//program akan berhenti jika ditutup
        frame.setSize(600, 300);//lebar, tinggi windows
        frame.setLocation(200,200);//x.y tampilan pada windows
        //frame.setLocationRelativeTo(null);//menempatkan frame ditengah-tengah layar
        frame.setVisible(true);// untuk menampilkan fram
    }
}