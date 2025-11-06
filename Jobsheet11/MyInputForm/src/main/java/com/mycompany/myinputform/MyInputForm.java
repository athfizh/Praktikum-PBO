/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.myinputform;

/**
 *
 * @author H A F I Z H
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MyInputForm extends JFrame {

    private static final int FRAME_WIDTH = 600;
    private static final int FRAME_HEIGHT = 200;
    private JLabel aLabel;
    private JLabel bLabel;
    private JLabel cLabel;
    private JTextField aField;
    private JTextField bField;
    private JButton button; // Tombol Calculate
    private JButton buttonTambah; // Tombol Tambah (Modifikasi)
    private JPanel panel;

    public MyInputForm() {
        createTextField();
        createButton();
        createButtonTambah(); // Memanggil method tombol tambah (Modifikasi)
        createPanel();

        setSize(FRAME_WIDTH, FRAME_WIDTH); 
    }

    private void createTextField() {
        aLabel = new JLabel("Nilai A: ");
        bLabel = new JLabel("Nilai B: "); 
        cLabel = new JLabel("Hasil: ");

        final int FIELD_WIDTH = 10;
        aField = new JTextField(FIELD_WIDTH);
        aField.setText("0");
        bField = new JTextField(FIELD_WIDTH);
        bField.setText("0");
    }

    // Method untuk tombol "Calculate" (Perkalian)
    private void createButton() {
        button = new JButton("Calculate");//untuk membuat tombol "Calculate"

        class AddInterestListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent event) {
                int a = Integer.valueOf(aField.getText());//mengambil inputan textbox
                int b = Integer.valueOf(bField.getText());
                // Typo 'a b;' di PDF diperbaiki menjadi perkalian
                int c = a * b; 
                cLabel.setText("Hasil: " + c);
            }
        }

        ActionListener listener = new AddInterestListener();
        button.addActionListener(listener);
    }
    
    // Method untuk tombol "Tambah" (Penjumlahan) (Modifikasi)
    private void createButtonTambah() {
        buttonTambah = new JButton("Tambah");

        class AddAdditionListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent event) {
                int a = Integer.valueOf(aField.getText());
                int b = Integer.valueOf(bField.getText());
                int c = a + b; // Logika diubah menjadi penambahan
                cLabel.setText("Hasil: " + c);
            }
        }
        ActionListener listener = new AddAdditionListener();
        buttonTambah.addActionListener(listener);
    }


    private void createPanel() {
        panel = new JPanel();
        panel.add(aLabel);
        panel.add(aField);
        panel.add(bLabel);
        panel.add(bField);
        panel.add(button);
        panel.add(buttonTambah); // Menambahkan tombol Tambah ke panel (Modifikasi)
        panel.add(cLabel);
        add(panel);
    }

    public static void main(String[] args) {
        // TODO code application logic here
        JFrame frame = new MyInputForm();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}