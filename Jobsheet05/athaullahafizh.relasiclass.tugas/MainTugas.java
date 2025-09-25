package athaullahafizh.relasiclass.tugas;

public class MainTugas {
    public static void main(String[] args) {
        Petugas p = new Petugas("P001", "Budi Santoso");
        Perpustakaan perpus = new Perpustakaan("Perpustakaan Kota", "Jl. Merdeka No. 1", p);
        
        Buku b1 = new Buku("978-1234567890", "Pemrograman Java", "John Doe", 85000);
        Buku b2 = new Buku("978-0987654321", "Basis Data", "Jane Smith", 90000);
        
        Anggota a1 = new Anggota("A001", "Ahmad", "Jl. Sudirman No. 5");
        Anggota a2 = new Anggota("A002", "Siti", "Jl. Thamrin No. 10");
        
        perpus.tambahBuku(b1, 0);
        perpus.tambahBuku(b2, 1);
        perpus.tambahAnggota(a1, 0);
        perpus.tambahAnggota(a2, 1);
        
        System.out.println(perpus.info());
        System.out.println(perpus.getPetugas().getNama());
    }
}