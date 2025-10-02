package Teori;

public class PinjamanDemo {
    public static void main(String[] args) {
        System.out.println("SELAMAT DATANG DI SISTEM PINJOL FASTCASH");
        System.out.println("===============================================");
        System.out.println();
        
        PinjamanKilat pjKilat1 = new PinjamanKilat("FC001", "Budi Santoso", 500_000);
        PinjamanKilat pjKilat2 = new PinjamanKilat("FC002", "Siti Aminah", 3_000_000);
        
        System.out.println("PENGAJUAN PINJAMAN #1:");
        pjKilat1.detailPeminjaman();
        System.out.println();
        
        System.out.println("PENGAJUAN PINJAMAN #2:");
        pjKilat2.detailPeminjaman();
        System.out.println();
        
        System.out.println("PROSES REVISI PENGAJUAN PINJAMAN #2:");
        System.out.println("Nasabah mengajukan pinjaman dengan jumlah yang lebih kecil...");
        pjKilat2.ubahJumlahPinjaman(500_000);
        pjKilat2.detailPeminjaman();
        
        System.out.println();
        System.out.println("===============================================");
        System.out.println("Terima kasih telah menggunakan FASTCASH!");
    }
}