public class LibraryDemo {
    public static void main(String[] args) {
        // Membuat objek Buku
        Buku buku1 = new Buku("Pemrograman Berorientasi Objek", "Dr. Sutrisno", "978-602-0-1");
        Buku buku2 = new Buku("Dasar-Dasar Jaringan Komputer", "Ahmad Fauzi", "978-602-0-2");

        // Menampilkan info buku
        System.out.println("===== Informasi Buku Awal =====");
        buku1.tampilkanInfo();

        // Agregasi: Menambahkan buku ke rak
        Rak rakA1 = new Rak("A1-Computer");
        rakA1.tambahBuku(buku1);
        rakA1.tambahBuku(buku2);
        rakA1.tampilkanIsiRak();
        
        // Relasi/Asosiasi: Member meminjam buku
        Member member1 = new Member("M001", "Budi");
        member1.pinjamBuku(buku1);
        member1.tampilkanBukuPinjaman();

        // Inheritance: Membuat objek dari subclass Staf
        Pustakawan pustakawan1 = new Pustakawan("S001", "Ani", 5000000, 1500000);
        PetugasSirkulasi petugas1 = new PetugasSirkulasi("S002", "Charlie", 50000, 40);
        
        // Polimorfisme dalam aksi
        System.out.println("===== Perhitungan Gaji Staf =====");
        pustakawan1.hitungGaji();
        System.out.println();
        petugas1.hitungGaji();
        
        // Relasi Staf dan Member
        System.out.println();
        pustakawan1.melayani(member1);
    }
}