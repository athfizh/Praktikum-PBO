public class Main {
    public static void main(String[] args) {
        // 1. Inisialisasi Sistem
        SistemInformasiTataTertib sistem = new SistemInformasiTataTertib();

        // 2. Membuat objek Anggota Kampus (Mahasiswa & Dosen)
        Mahasiswa mhs1 = new Mahasiswa("Budi Santoso", "M0501", "235150201111001", "Teknik Informatika");
        Mahasiswa mhs2 = new Mahasiswa("Ani Lestari", "M0502", "235150401111002", "Sistem Informasi");
        Dosen dosen1 = new Dosen("Dr. Retno Wulandari", "D0101", "198503102008122001", "Ilmu Komputer");

        // 3. Membuat objek Tata Tertib
        TataTertib aturan1 = new TataTertib("Dilarang merokok di area kampus", "Peringatan lisan");
        TataTertib aturan2 = new TataTertib("Terlambat mengumpulkan tugas", "Pengurangan nilai");
        TataTertib aturan3 = new TataTertib("Parkir tidak pada tempatnya", "Denda administrasi");

        // 4. Simulasi pencatatan pelanggaran
        System.out.println("========= MENCATAT PELANGGARAN =========");
        Pelanggaran p1 = new Pelanggaran(mhs1, aturan1, "2025-10-01");
        sistem.catatPelanggaran(p1);
        
        Pelanggaran p2 = new Pelanggaran(mhs2, aturan2, "2025-10-02");
        sistem.catatPelanggaran(p2);
        
        Pelanggaran p3 = new Pelanggaran(mhs1, aturan3, "2025-10-03");
        sistem.catatPelanggaran(p3);

        // 5. Menerapkan sanksi secara langsung (contoh pemanggilan metode)
        System.out.println("\n========= MENERAPKAN SANKSI LANGSUNG =========");
        aturan1.terapkanSanksi(mhs1);
        
        // 6. Menampilkan riwayat pelanggaran untuk setiap anggota kampus
        System.out.println("\n========= MELIHAT RIWAYAT PELANGGARAN =========");
        sistem.lihatRiwayatPelanggaran(mhs1);
        sistem.lihatRiwayatPelanggaran(mhs2);
        sistem.lihatRiwayatPelanggaran(dosen1); // Dosen ini tidak punya pelanggaran
    }
}