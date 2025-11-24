/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frontend;

import backend.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import com.formdev.flatlaf.FlatLightLaf; 
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *
 * @author H A F I Z H
 */
public class FrmKedaiKopi extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmKedaiKopi.class.getName());
    
    // --- VARIABEL GLOBAL ---
    private DefaultTableModel modelKeranjang;
    private double grandTotal = 0;
    private NumberFormat kurensi = new DecimalFormat("#,###");

    // --- KONSTRUKTOR ---
    public FrmKedaiKopi() {
        initComponents();
        this.setLocationRelativeTo(null); 
        
        // --- SETUP TAMPILAN TABEL ---
        tblMenu.setRowHeight(30);       
        tblKeranjang.setRowHeight(30);  
        tblKategori.setRowHeight(30);
        tblUser.setRowHeight(30);

        // Setup Tampilan Tabel
        tblMenu.setRowHeight(30);       
        tblKeranjang.setRowHeight(30);  
        tblKategori.setRowHeight(30);
        tblUser.setRowHeight(30);
        
        // Setup Model Tabel Keranjang
        String[] kolomKeranjang = {"ID Menu", "Nama Item", "Harga", "Qty", "Subtotal"};
        modelKeranjang = new DefaultTableModel(new Object[][]{}, kolomKeranjang);
        tblKeranjang.setModel(modelKeranjang);

        // Load Semua Data dari Database
        refreshSemuaData();
        
        // Reset Form
        kosongkanFormMenu();
        kosongkanFormKategori();
        kosongkanFormUser();
    }
    
    // ==================== METHOD HELPER (LOGIKA UTAMA) ====================
    
    public void refreshSemuaData() {
        loadDataKategori();
        loadDataMenu();
        loadDataUser();
        updateComboBoxes();
    }
    
    public void updateComboBoxes() {
        // Isi ComboBox Kategori (Tab Menu) dengan OBJECT Kategori
        ArrayList<Kategori> listKat = new Kategori().getAll();
        if (!listKat.isEmpty()) {
            cmbKategori.setModel(new DefaultComboBoxModel(listKat.toArray()));
        }
        
        // Isi ComboBox Menu (Tab Kasir)
        ArrayList<MenuKopi> listMenu = new MenuKopi().getAll();
        if (!listMenu.isEmpty()) {
            cmbMenuKasir.setModel(new DefaultComboBoxModel(listMenu.toArray()));
        }
        
        // Isi Role User
        cmbRole.setModel(new DefaultComboBoxModel<>(new String[] { "Kasir", "Owner", "Stocker" }));
    }

    // --- LOGIKA KASIR ---
    private void hitungGrandTotal() {
        grandTotal = 0;
        for (int i = 0; i < modelKeranjang.getRowCount(); i++) {
            double subtotal = Double.parseDouble(modelKeranjang.getValueAt(i, 4).toString());
            grandTotal += subtotal;
        }
        txtTotal.setText(String.valueOf(grandTotal));
    }

    // --- LOGIKA MENU ---
    public void kosongkanFormMenu() {
        txtId.setText("0");
        txtNama.setText("");
        txtHarga.setText("");
        txtStok.setText("");
    }

    public void loadDataMenu() {
        String[] kolom = {"ID", "Nama", "Kategori", "Harga", "Stok"};
        ArrayList<MenuKopi> list = new MenuKopi().getAll();
        DefaultTableModel model = new DefaultTableModel(new Object[][]{}, kolom);
        tblMenu.setModel(model);
        for (MenuKopi m : list) {
            model.addRow(new Object[]{ m.getIdMenu(), m.getNamaMenu(), m.getKategori().getNamaKategori(), m.getHarga(), m.getStok() });
        }
    }

    // --- LOGIKA KATEGORI ---
    public void kosongkanFormKategori() {
        txtIdKat.setText("0");
        txtNamaKat.setText("");
    }

    public void loadDataKategori() {
        String[] kolom = {"ID", "Nama Kategori"};
        ArrayList<Kategori> list = new Kategori().getAll();
        DefaultTableModel model = new DefaultTableModel(new Object[][]{}, kolom);
        tblKategori.setModel(model);
        for (Kategori k : list) {
            model.addRow(new Object[]{ k.getIdKategori(), k.getNamaKategori() });
        }
    }

    // --- LOGIKA USER ---
    public void kosongkanFormUser() {
        txtIdUser.setText("0");
        txtUsername.setText("");
        txtPass.setText("");
        cmbRole.setSelectedIndex(0);
    }

    public void loadDataUser() {
        String[] kolom = {"ID", "Username", "Role"};
        ArrayList<User> list = new User().getAll();
        DefaultTableModel model = new DefaultTableModel(new Object[][]{}, kolom);
        tblUser.setModel(model);
        for (User u : list) {
            model.addRow(new Object[]{ u.getIdUser(), u.getUsername(), u.getRole() });
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        txtHarga = new javax.swing.JTextField();
        txtStok = new javax.swing.JTextField();
        btnHapus = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        JScrollPane = new javax.swing.JScrollPane();
        tblMenu = new javax.swing.JTable();
        cmbKategori = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        btnTambahBaru = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        cmbMenuKasir = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtQty = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        btnCheckout = new javax.swing.JButton();
        btnTambahItem = new javax.swing.JButton();
        btnHapusItem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKeranjang = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        txtBayar = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtIdUser = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtPass = new javax.swing.JTextField();
        cmbRole = new javax.swing.JComboBox<>();
        btnSimpanUser = new javax.swing.JButton();
        btnHapusUser = new javax.swing.JButton();
        btnTambahUser = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblUser = new javax.swing.JTable();
        jLabel23 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtIdKat = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtNamaKat = new javax.swing.JTextField();
        btnSimpanKat = new javax.swing.JButton();
        btnHapusKat = new javax.swing.JButton();
        btnTambahKat = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblKategori = new javax.swing.JTable();
        jLabel22 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplikasi Kasir & Inventaris Kopi");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("ID Menu :");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Nama Menu :");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Kategori :");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Harga (Rp) :");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Stok Awal :");

        txtId.setEditable(false);
        txtId.setText("0");

        btnHapus.setBackground(new java.awt.Color(220, 53, 69));
        btnHapus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHapus.setForeground(new java.awt.Color(255, 255, 255));
        btnHapus.setText("HAPUS");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnSimpan.setBackground(new java.awt.Color(0, 153, 153));
        btnSimpan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSimpan.setForeground(new java.awt.Color(255, 255, 255));
        btnSimpan.setText("SIMPAN");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("DAFTAR INVENTARIS :");

        tblMenu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nama Menu", "Kategori", "Harga", "Stok"
            }
        ));
        tblMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMenuMouseClicked(evt);
            }
        });
        JScrollPane.setViewportView(tblMenu);

        cmbKategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manual Brew", "Espresso Based", "Non-Coffee", "Makanan" }));

        jPanel4.setBackground(new java.awt.Color(78, 52, 46));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("KEDAI KOPI CAK BUDIBUD");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(196, 196, 196))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        btnTambahBaru.setBackground(new java.awt.Color(0, 153, 153));
        btnTambahBaru.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTambahBaru.setForeground(new java.awt.Color(255, 255, 255));
        btnTambahBaru.setText("TAMBAH BARU");
        btnTambahBaru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahBaruActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7))
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtHarga, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                        .addComponent(txtStok)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(JScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnTambahBaru, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmbKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTambahBaru, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("INVENTARIS", jPanel2);

        cmbMenuKasir.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbMenuKasir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMenuKasirActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Pilih Menu :");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Jumlah (Qty) :");

        txtQty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQtyActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Total Tagihan (Rp) :");

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtTotal.setForeground(new java.awt.Color(180, 0, 0));
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });

        btnCheckout.setBackground(new java.awt.Color(0, 150, 136));
        btnCheckout.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCheckout.setForeground(new java.awt.Color(255, 255, 255));
        btnCheckout.setText("BAYAR & CETAK STRUK");
        btnCheckout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckoutActionPerformed(evt);
            }
        });

        btnTambahItem.setBackground(new java.awt.Color(0, 153, 153));
        btnTambahItem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTambahItem.setForeground(new java.awt.Color(255, 255, 255));
        btnTambahItem.setText("TAMBAH");
        btnTambahItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahItemActionPerformed(evt);
            }
        });

        btnHapusItem.setBackground(new java.awt.Color(0, 153, 153));
        btnHapusItem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHapusItem.setForeground(new java.awt.Color(255, 255, 255));
        btnHapusItem.setText("HAPUS ITEM");
        btnHapusItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusItemActionPerformed(evt);
            }
        });

        tblKeranjang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Menu", "Nama Item", "Harga", "Qty", "Subtotal"
            }
        ));
        jScrollPane1.setViewportView(tblKeranjang);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Uang Bayar (Rp) :");

        txtBayar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtBayar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBayarActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(80, 80, 80));
        jLabel12.setText("KERANJANG BELANJA :");

        jPanel6.setBackground(new java.awt.Color(78, 52, 46));
        jPanel6.setForeground(new java.awt.Color(255, 255, 255));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("KEDAI KOPI CAK BUDIBUD");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(197, 197, 197)
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbMenuKasir, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(txtQty, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnTambahItem, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnHapusItem, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(50, 50, 50))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnCheckout, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel12)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(179, 179, 179)
                                    .addComponent(jLabel11))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(49, 49, 49)
                                    .addComponent(txtBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbMenuKasir, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtQty, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTambahItem, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHapusItem, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBayar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnCheckout, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        jTabbedPane1.addTab("KASIR", jPanel1);

        jPanel8.setBackground(new java.awt.Color(78, 52, 46));
        jPanel8.setForeground(new java.awt.Color(255, 255, 255));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("KEDAI KOPI CAK BUDIBUD");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(197, 197, 197)
                .addComponent(jLabel16)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel16)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setText("ID User");

        txtIdUser.setEditable(false);
        txtIdUser.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtIdUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdUserActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setText("Username");

        txtUsername.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setText("Password");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setText("Role");

        txtPass.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassActionPerformed(evt);
            }
        });

        cmbRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kasir", "Owner", "Stocker" }));
        cmbRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbRoleActionPerformed(evt);
            }
        });

        btnSimpanUser.setBackground(new java.awt.Color(0, 153, 153));
        btnSimpanUser.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSimpanUser.setForeground(new java.awt.Color(255, 255, 255));
        btnSimpanUser.setText("SIMPAN");
        btnSimpanUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanUserActionPerformed(evt);
            }
        });

        btnHapusUser.setBackground(new java.awt.Color(220, 53, 69));
        btnHapusUser.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHapusUser.setForeground(new java.awt.Color(255, 255, 255));
        btnHapusUser.setText("HAPUS");
        btnHapusUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusUserActionPerformed(evt);
            }
        });

        btnTambahUser.setBackground(new java.awt.Color(0, 153, 153));
        btnTambahUser.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTambahUser.setForeground(new java.awt.Color(255, 255, 255));
        btnTambahUser.setText("TAMBAH BARU");
        btnTambahUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahUserActionPerformed(evt);
            }
        });

        tblUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Username", "Role"
            }
        ));
        tblUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUserMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblUser);

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel23.setText("User :");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnSimpanUser, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btnHapusUser, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnTambahUser, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                        .addGap(56, 56, 56)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIdUser, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbRole, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane3)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbRole, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpanUser, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHapusUser, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTambahUser, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 28, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("USER", jPanel5);

        jPanel9.setBackground(new java.awt.Color(78, 52, 46));
        jPanel9.setForeground(new java.awt.Color(255, 255, 255));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("KEDAI KOPI CAK BUDIBUD");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(197, 197, 197)
                .addComponent(jLabel17)
                .addContainerGap(198, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel17)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("ID Kategori");

        txtIdKat.setEditable(false);
        txtIdKat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtIdKat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdKatActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Nama Kategori");

        txtNamaKat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtNamaKat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaKatActionPerformed(evt);
            }
        });

        btnSimpanKat.setBackground(new java.awt.Color(0, 153, 153));
        btnSimpanKat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSimpanKat.setForeground(new java.awt.Color(255, 255, 255));
        btnSimpanKat.setText("SIMPAN");
        btnSimpanKat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanKatActionPerformed(evt);
            }
        });

        btnHapusKat.setBackground(new java.awt.Color(220, 53, 69));
        btnHapusKat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHapusKat.setForeground(new java.awt.Color(255, 255, 255));
        btnHapusKat.setText("HAPUS");
        btnHapusKat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusKatActionPerformed(evt);
            }
        });

        btnTambahKat.setBackground(new java.awt.Color(0, 153, 153));
        btnTambahKat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTambahKat.setForeground(new java.awt.Color(255, 255, 255));
        btnTambahKat.setText("TAMBAH BARU");
        btnTambahKat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahKatActionPerformed(evt);
            }
        });

        tblKategori.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Nama Kategori"
            }
        ));
        tblKategori.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKategoriMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblKategori);

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setText("Kategori :");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(btnSimpanKat, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(btnHapusKat, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(btnTambahKat, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNamaKat, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdKat, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdKat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNamaKat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpanKat, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHapusKat, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTambahKat, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 44, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("KATEGORI", jPanel7);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBayarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBayarActionPerformed

    private void btnHapusItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusItemActionPerformed
        int row = tblKeranjang.getSelectedRow();
        if (row >= 0) {
            modelKeranjang.removeRow(row);
            hitungGrandTotal();
        } else {
            JOptionPane.showMessageDialog(this, "Pilih item yang mau dihapus!");
        }
    }//GEN-LAST:event_btnHapusItemActionPerformed

    private void btnTambahItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahItemActionPerformed
        // Validasi Item Dipilih
        if(cmbMenuKasir.getItemCount() == 0 || cmbMenuKasir.getSelectedItem() == null) return;
        
        MenuKopi menu = (MenuKopi) cmbMenuKasir.getSelectedItem();
        
        if(txtQty.getText().isEmpty()) {
             JOptionPane.showMessageDialog(this, "Masukkan jumlah pesanan!");
             return;
        }
        
        int qty = 0;
        try {
            qty = Integer.parseInt(txtQty.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Qty harus angka!"); return;
        }

        if (qty > menu.getStok()) {
            JOptionPane.showMessageDialog(this, "Stok tidak cukup! Sisa: " + menu.getStok());
            return;
        }

        double subtotal = menu.getHarga() * qty;
        modelKeranjang.addRow(new Object[]{ menu.getIdMenu(), menu.getNamaMenu(), menu.getHarga(), qty, subtotal });
        hitungGrandTotal();
        txtQty.setText("");
    }//GEN-LAST:event_btnTambahItemActionPerformed

    private void btnCheckoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckoutActionPerformed
        if (modelKeranjang.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Keranjang masih kosong!"); return;
        }
        
        if (txtBayar.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Masukkan uang bayar!"); return;
        }
        
        double uangBayar = 0;
        try {
            uangBayar = Double.parseDouble(txtBayar.getText());
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Input Uang Salah!"); return;
        }

        if (uangBayar < grandTotal) {
            JOptionPane.showMessageDialog(this, "Uang kurang!"); return;
        }
        
        double kembalian = uangBayar - grandTotal;
        StringBuilder struk = new StringBuilder();
        struk.append("========== KEDAI KOPI CAK BUDIBUD ==========\n");
        
        // Loop Keranjang & Simpan Database
        for(int i=0; i<modelKeranjang.getRowCount(); i++) {
            int id = Integer.parseInt(modelKeranjang.getValueAt(i, 0).toString());
            String nama = modelKeranjang.getValueAt(i, 1).toString();
            int qty = Integer.parseInt(modelKeranjang.getValueAt(i, 3).toString());
            
            // 1. Kurangi Stok
            MenuKopi mk = new MenuKopi();
            mk.setIdMenu(id);
            mk.kurangiStok(qty);
            
            // 2. Simpan Log Transaksi
            String sqlLog = "INSERT INTO tbl_transaksi (tanggal, nama_menu, qty, total_harga, nama_user) VALUES (CURRENT_DATE, '" 
                    + nama + "', " + qty + ", " + modelKeranjang.getValueAt(i, 4) + ", 'Admin')";
            DBHelper.insertQueryGetId(sqlLog);
            
            struk.append(nama + " x" + qty + "\n");
        }
        
        struk.append("--------------------------------\n");
        struk.append("Total: Rp " + kurensi.format(grandTotal) + "\n");
        struk.append("Bayar: Rp " + kurensi.format(uangBayar) + "\n");
        struk.append("Kembali: Rp " + kurensi.format(kembalian) + "\n");
        struk.append("================================");
        
        JOptionPane.showMessageDialog(this, struk.toString(), "Struk Pembayaran", JOptionPane.INFORMATION_MESSAGE);
        
        modelKeranjang.setRowCount(0); 
        txtTotal.setText("0"); 
        txtBayar.setText("");
        refreshSemuaData();
    }//GEN-LAST:event_btnCheckoutActionPerformed

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void txtQtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQtyActionPerformed

    private void cmbMenuKasirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMenuKasirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbMenuKasirActionPerformed

    private void tblMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMenuMouseClicked
        int row = tblMenu.getSelectedRow();
        if(row >= 0){
            int id = Integer.parseInt(tblMenu.getValueAt(row, 0).toString());
            MenuKopi mk = new MenuKopi().getById(id);

            txtId.setText(String.valueOf(mk.getIdMenu()));
            txtNama.setText(mk.getNamaMenu());
            
            // Loop ComboBox untuk set item yang sesuai
            for (int i = 0; i < cmbKategori.getItemCount(); i++) {
                Object item = cmbKategori.getItemAt(i);
                if (item instanceof Kategori) {
                    Kategori k = (Kategori) item;
                    if (k.getIdKategori() == mk.getKategori().getIdKategori()) {
                        cmbKategori.setSelectedIndex(i);
                        break;
                    }
                }
            }
            
            txtHarga.setText(String.valueOf(mk.getHarga()));
            txtStok.setText(String.valueOf(mk.getStok()));
        }
    }                                    

    private void btnTambahBaruActionPerformed() {                                              
        kosongkanFormMenu();
    }//GEN-LAST:event_tblMenuMouseClicked

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        int row = tblMenu.getSelectedRow();
        if(row >= 0){
            int id = Integer.parseInt(tblMenu.getValueAt(row, 0).toString());
            MenuKopi mk = new MenuKopi();
            mk.setIdMenu(id);
            mk.delete();
            kosongkanFormMenu();
            refreshSemuaData();
            JOptionPane.showMessageDialog(this, "Data Dihapus!");
        } else {
            JOptionPane.showMessageDialog(this, "Pilih data di tabel dulu!");
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        MenuKopi mk = new MenuKopi();
        mk.setIdMenu(Integer.parseInt(txtId.getText()));
        mk.setNamaMenu(txtNama.getText());
        
        // PERBAIKAN: Cast ke Object Kategori, bukan toString()
        if (cmbKategori.getSelectedItem() instanceof Kategori) {
            mk.setKategori((Kategori) cmbKategori.getSelectedItem());
        } else {
             JOptionPane.showMessageDialog(this, "Pilih Kategori yang valid!"); return;
        }

        try {
            mk.setHarga(Double.parseDouble(txtHarga.getText()));
            mk.setStok(Integer.parseInt(txtStok.getText()));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Harga dan Stok harus angka!");
            return;
        }

        mk.save();
        txtId.setText(Integer.toString(mk.getIdMenu()));
        refreshSemuaData();
        JOptionPane.showMessageDialog(this, "Data Tersimpan!");
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnSimpanKatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanKatActionPerformed
        Kategori k = new Kategori();
        k.setIdKategori(Integer.parseInt(txtIdKat.getText()));
        k.setNamaKategori(txtNamaKat.getText());
        k.save();
        refreshSemuaData();
        kosongkanFormKategori();
        JOptionPane.showMessageDialog(this, "Kategori Tersimpan!");
    }//GEN-LAST:event_btnSimpanKatActionPerformed

    private void btnHapusKatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusKatActionPerformed
        int row = tblKategori.getSelectedRow();
        if(row >= 0) {
            int id = Integer.parseInt(tblKategori.getValueAt(row, 0).toString());
            Kategori k = new Kategori();
            k.setIdKategori(id);
            k.delete();
            refreshSemuaData();
            kosongkanFormKategori();
            JOptionPane.showMessageDialog(this, "Kategori Dihapus!");
        }
    }//GEN-LAST:event_btnHapusKatActionPerformed

    private void btnTambahKatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahKatActionPerformed
        kosongkanFormKategori();
    }//GEN-LAST:event_btnTambahKatActionPerformed

    private void btnSimpanUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanUserActionPerformed
        User u = new User();
        u.setIdUser(Integer.parseInt(txtIdUser.getText()));
        u.setUsername(txtUsername.getText());
        u.setPassword(txtPass.getText());
        u.setRole(cmbRole.getSelectedItem().toString());
        u.save();
        loadDataUser(); 
        kosongkanFormUser();
        JOptionPane.showMessageDialog(this, "User Tersimpan!");
    }//GEN-LAST:event_btnSimpanUserActionPerformed

    private void btnHapusUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusUserActionPerformed
        int row = tblUser.getSelectedRow();
        if (row >= 0) {
            int id = Integer.parseInt(tblUser.getValueAt(row, 0).toString());
            User u = new User();
            u.setIdUser(id);
            u.delete();
            loadDataUser(); 
            kosongkanFormUser();
            JOptionPane.showMessageDialog(this, "User Dihapus!");
        }
    }//GEN-LAST:event_btnHapusUserActionPerformed

    private void btnTambahUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahUserActionPerformed
        kosongkanFormUser();
    }//GEN-LAST:event_btnTambahUserActionPerformed

    private void txtIdUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdUserActionPerformed

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void txtPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPassActionPerformed

    private void cmbRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbRoleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbRoleActionPerformed

    private void txtIdKatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdKatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdKatActionPerformed

    private void txtNamaKatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaKatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaKatActionPerformed

    private void tblKategoriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKategoriMouseClicked
        int row = tblKategori.getSelectedRow();
        if(row >= 0){
            txtIdKat.setText(tblKategori.getValueAt(row, 0).toString());
            txtNamaKat.setText(tblKategori.getValueAt(row, 1).toString());
        }
    }//GEN-LAST:event_tblKategoriMouseClicked

    private void tblUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUserMouseClicked
        int row = tblUser.getSelectedRow();
        if(row >= 0){
            txtIdUser.setText(tblUser.getValueAt(row, 0).toString());
            txtUsername.setText(tblUser.getValueAt(row, 1).toString());
            cmbRole.setSelectedItem(tblUser.getValueAt(row, 2).toString());
        }
    }//GEN-LAST:event_tblUserMouseClicked

    private void btnTambahBaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahBaruActionPerformed
        kosongkanFormMenu();
    }//GEN-LAST:event_btnTambahBaruActionPerformed
    
    private void btnHitungActionPerformed(java.awt.event.ActionEvent evt) {} 

    public static void main(String args[]) {
        try { UIManager.setLookAndFeel( new FlatLightLaf() ); } catch( Exception ex ) {}
        java.awt.EventQueue.invokeLater(() -> new FrmKedaiKopi().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane JScrollPane;
    private javax.swing.JButton btnCheckout;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnHapusItem;
    private javax.swing.JButton btnHapusKat;
    private javax.swing.JButton btnHapusUser;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnSimpanKat;
    private javax.swing.JButton btnSimpanUser;
    private javax.swing.JButton btnTambahBaru;
    private javax.swing.JButton btnTambahItem;
    private javax.swing.JButton btnTambahKat;
    private javax.swing.JButton btnTambahUser;
    private javax.swing.JComboBox<String> cmbKategori;
    private javax.swing.JComboBox<String> cmbMenuKasir;
    private javax.swing.JComboBox<String> cmbRole;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblKategori;
    private javax.swing.JTable tblKeranjang;
    private javax.swing.JTable tblMenu;
    private javax.swing.JTable tblUser;
    private javax.swing.JTextField txtBayar;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtIdKat;
    private javax.swing.JTextField txtIdUser;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNamaKat;
    private javax.swing.JTextField txtPass;
    private javax.swing.JTextField txtQty;
    private javax.swing.JTextField txtStok;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
