package frontend;

import backend.*;

public class TestBackend {
    public static void main(String[] args) {
        
        // 1. Buat objek Anggota baru
        Anggota ang1 = new Anggota("Timur", "Jl. Surabaya 12", "1234567");
        Anggota ang2 = new Anggota("Barat", "Jl. Jakarta 45", "9876543");
        Anggota ang3 = new Anggota("Selatan", "Jl. Bandung 99", "5555555");

        // 2. Test Insert (Simpan data baru)
        ang1.save();
        ang2.save();
        ang3.save();

        // 3. Test Update (Ubah data)
        // Mengubah alamat anggota ke-2
        ang2.setAlamat("Jl. Jawa Timur No 1");
        ang2.save();

        // 4. Test Delete (Hapus data)
        // Menghapus anggota ke-3
        ang3.delete();

        // 5. Test Select All (Tampilkan semua data)
        System.out.println("--- MENAMPILKAN SEMUA DATA ---");
        for(Anggota a : new Anggota().getAll()){
            System.out.println("Nama: " + a.getNama() + ", Alamat: " + a.getAlamat() + ", Telepon: " + a.getTelepon());
        }

        // 6. Test Search (Cari data)
        System.out.println("\n--- PENCARIAN 'Timur' ---");
        for(Anggota a : new Anggota().search("Timur")){
            System.out.println("Nama: " + a.getNama() + ", Alamat: " + a.getAlamat() + ", Telepon: " + a.getTelepon());
        }
    }
}