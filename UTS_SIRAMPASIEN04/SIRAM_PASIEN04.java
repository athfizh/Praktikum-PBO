import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class SIRAM_PASIEN04 {

    private static List<Pasien04> daftarPasien04 = new ArrayList<>();
    private static List<Dokter04> daftarDokter04 = new ArrayList<>();
    private static Scanner scanner04 = new Scanner(System.in);
    private static int idPasienCounter04 = 1;
    private static int idDokterCounter04 = 1;
    private static int idPemeriksaanCounter04 = 1;
    
    public static void tambahPasien() {
        System.out.println("\n--- Formulir Tambah Pasien ---");
        try {
            System.out.print("Masukkan Nama: ");
            String nama = scanner04.nextLine();
            System.out.print("Masukkan Jenis Kelamin (L/P): ");
            boolean jenisKelamin = scanner04.nextLine().equalsIgnoreCase("L");
            System.out.print("Masukkan Alamat: ");
            String alamat = scanner04.nextLine();
            System.out.print("Masukkan No. Telepon: ");
            String noTelp = scanner04.nextLine();

            Pasien04 pasienBaru = new Pasien04(idPasienCounter04++, nama, jenisKelamin, alamat, noTelp);
            daftarPasien04.add(pasienBaru);
            System.out.println("Data pasien berhasil ditambahkan!");
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }

    public static void updateDataPasien() {
        tampilkanDaftarPasien();
        if (daftarPasien04.isEmpty()) return;

        System.out.print("\nMasukkan ID Pasien yang akan diupdate: ");
        try {
            int id = Integer.parseInt(scanner04.nextLine());
            Pasien04 pasienDitemukan = null;
            for (Pasien04 p : daftarPasien04) {
                if (p.getId04() == id) {
                    pasienDitemukan = p;
                    break;
                }
            }

            if (pasienDitemukan != null) {
                System.out.println("Mengupdate data untuk: " + pasienDitemukan.getNama04());
                System.out.print("Masukkan Alamat Baru (kosongkan jika tidak ada perubahan): ");
                String alamat = scanner04.nextLine();
                if (!alamat.isEmpty()) pasienDitemukan.setAlamat04(alamat);

                System.out.print("Masukkan No. Telepon Baru (kosongkan jika tidak ada perubahan): ");
                String noTelp = scanner04.nextLine();
                if (!noTelp.isEmpty()) pasienDitemukan.setNoTelp04(noTelp);

                System.out.println("Data pasien berhasil diupdate!");
            } else {
                System.out.println("Pasien dengan ID " + id + " tidak ditemukan.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Input ID harus berupa angka.");
        }
    }

    public static void tampilkanDaftarPasien() {
        System.out.println("\n--- Daftar Pasien Terdaftar ---");
        if (daftarPasien04.isEmpty()) {
            System.out.println("Data pasien masih kosong.");
        } else {
            for (Pasien04 p : daftarPasien04) {
                p.tampilkanInfo();
                System.out.println("---------------------------------");
            }
        }
    }

    public static void tambahDokter() {
        System.out.println("\n--- Formulir Tambah Dokter ---");
        try {
            System.out.print("Masukkan Nama Dokter: ");
            String nama = scanner04.nextLine();
            System.out.print("Masukkan Jenis Kelamin (L/P): ");
            boolean jenisKelamin = scanner04.nextLine().equalsIgnoreCase("L");
            System.out.print("Masukkan Alamat: ");
            String alamat = scanner04.nextLine();
            System.out.print("Masukkan No. Telepon: ");
            String noTelp = scanner04.nextLine();
            System.out.print("Masukkan Spesialisasi: ");
            String spesialisasi = scanner04.nextLine();

            Dokter04 dokterBaru = new Dokter04(idDokterCounter04++, nama, jenisKelamin, alamat, noTelp, spesialisasi);
            daftarDokter04.add(dokterBaru);
            System.out.println("Data dokter berhasil ditambahkan!");
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }
    
    public static void updateDataDokter() {
        tampilkanDaftarDokter();
        if (daftarDokter04.isEmpty()) return;

        System.out.print("\nMasukkan ID Dokter yang akan diupdate: ");
        try {
            int id = Integer.parseInt(scanner04.nextLine());
            Dokter04 dokterDitemukan = null;
            for (Dokter04 d : daftarDokter04) {
                if (d.getId04() == id) {
                    dokterDitemukan = d;
                    break;
                }
            }

            if (dokterDitemukan != null) {
                System.out.println("Mengupdate data untuk: Dr. " + dokterDitemukan.getNama04());
                System.out.print("Masukkan Spesialisasi Baru (kosongkan jika tidak berubah): ");
                String spesialisasi = scanner04.nextLine();
                if (!spesialisasi.isEmpty()) dokterDitemukan.setSpesialisasi04(spesialisasi);
                
                System.out.println("Data dokter berhasil diupdate!");
            } else {
                System.out.println("Dokter dengan ID " + id + " tidak ditemukan.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Input ID harus berupa angka.");
        }
    }

    public static void tampilkanDaftarDokter() {
        System.out.println("\n--- Daftar Dokter Tersedia ---");
        if (daftarDokter04.isEmpty()) {
            System.out.println("Data dokter masih kosong.");
        } else {
            for (Dokter04 d : daftarDokter04) {
                d.tampilkanInfo();
                System.out.println("---------------------------------");
            }
        }
    }

    public static void tambahRiwayatPemeriksaan() {
        tampilkanDaftarPasien();
        if (daftarPasien04.isEmpty()) return;

        System.out.print("\nMasukkan ID Pasien untuk menambah riwayat: ");
        try {
            int idPasien = Integer.parseInt(scanner04.nextLine());
            Pasien04 pasien = daftarPasien04.stream().filter(p -> p.getId04() == idPasien).findFirst().orElse(null);

            if (pasien == null) {
                System.out.println("Pasien tidak ditemukan.");
                return;
            }

            tampilkanDaftarDokter();
            if (daftarDokter04.isEmpty()) {
                System.out.println("Tidak ada dokter. Tambah data dokter dulu.");
                return;
            }
            
            System.out.print("Pilih ID Dokter yang memeriksa: ");
            int idDokter = Integer.parseInt(scanner04.nextLine());
            Dokter04 dokter = daftarDokter04.stream().filter(d -> d.getId04() == idDokter).findFirst().orElse(null);

            if (dokter == null) {
                System.out.println("Dokter tidak ditemukan.");
                return;
            }
            
            System.out.println("\n--- Formulir Pemeriksaan untuk " + pasien.getNama04() + " ---");
            System.out.print("Masukkan Tanggal (dd/MM/yyyy): ");
            Date tanggal = new SimpleDateFormat("dd/MM/yyyy").parse(scanner04.nextLine());
            System.out.print("Masukkan Keluhan: ");
            String keluhan = scanner04.nextLine();
            System.out.print("Masukkan Diagnosa: ");
            String diagnosa = scanner04.nextLine();
            System.out.print("Masukkan Tindakan: ");
            String tindakan = scanner04.nextLine();
            System.out.print("Masukkan Obat: ");
            String obat = scanner04.nextLine();

            Pemeriksaan04 pemeriksaan = new Pemeriksaan04(idPemeriksaanCounter04++, tanggal, keluhan, diagnosa, tindakan, obat, dokter);
            pasien.getRekamMedik04().tambahPemeriksaan04(pemeriksaan);
            System.out.println("Riwayat pemeriksaan berhasil ditambahkan!");
        } catch (NumberFormatException | ParseException e) {
            System.out.println("Input tidak valid. Pastikan ID angka dan tanggal berformat dd/MM/yyyy.");
        }
    }

    public static void tampilkanRiwayatPemeriksaanPasien() {
        tampilkanDaftarPasien();
        if (daftarPasien04.isEmpty()) return;
        
        System.out.print("\nMasukkan ID Pasien untuk melihat riwayat: ");
        try {
            int idPasien = Integer.parseInt(scanner04.nextLine());
            Pasien04 pasien = daftarPasien04.stream().filter(p -> p.getId04() == idPasien).findFirst().orElse(null);

            if (pasien != null) {
                System.out.println("\n--- Riwayat Rekam Medik: " + pasien.getNama04() + " ---");
                List<Pemeriksaan04> riwayat = pasien.getRekamMedik04().getDaftarPemeriksaan04();
                if (riwayat.isEmpty()) {
                    System.out.println("Belum ada riwayat pemeriksaan.");
                } else {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
                    for (Pemeriksaan04 p : riwayat) {
                        System.out.println("Tanggal         : " + sdf.format(p.getTanggalPemeriksaan04()));
                        System.out.println("Keluhan         : " + p.getKeluhan04());
                        System.out.println("Diagnosa        : " + p.getDiagnosa04());
                        System.out.println("Tindakan        : " + p.getTindakan04());
                        System.out.println("Obat            : " + p.getObat04());
                        System.out.println("Diperiksa oleh  : Dr. " + p.getDokter04().getNama04());
                        System.out.println("---------------------------------------------");
                    }
                }
            } else {
                System.out.println("Pasien tidak ditemukan.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Input ID harus berupa angka.");
        }
    }
    
    public static void main(String[] args) {
        int pilihan = 0;
        do {
            System.out.println("\n=======================================================");
            System.out.println("   Sistem Informasi Rekam Medik Pasien (SIRAM)");
            System.out.println("=======================================================");
            System.out.println("1. Tambah Pasien");
            System.out.println("2. Update Data Pasien");
            System.out.println("3. Tampilkan Daftar Pasien");
            System.out.println("4. Tambah Dokter");
            System.out.println("5. Update Data Dokter");
            System.out.println("6. Tampilkan Daftar Dokter");
            System.out.println("7. Tambah Riwayat Pemeriksaan (Rekam Medik) Pasien");
            System.out.println("8. Tampilkan Riwayat Pemeriksaan (Rekam Medik) Pasien");
            System.out.println("9. Selesai");
            System.out.print("Pilih Menu Nomer? ");

            try {
                pilihan = Integer.parseInt(scanner04.nextLine());
                switch (pilihan) {
                    case 1: tambahPasien(); break;
                    case 2: updateDataPasien(); break;
                    case 3: tampilkanDaftarPasien(); break;
                    case 4: tambahDokter(); break;
                    case 5: updateDataDokter(); break;
                    case 6: tampilkanDaftarDokter(); break;
                    case 7: tambahRiwayatPemeriksaan(); break;
                    case 8: tampilkanRiwayatPemeriksaanPasien(); break;
                    case 9: System.out.println("Terima kasih!"); break;
                    default: System.out.println("Pilihan tidak valid!"); break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka!");
            }
        } while (pilihan != 9);
        scanner04.close();
    }
}