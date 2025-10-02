import java.util.ArrayList;
import java.util.List;

public class Rak {
    private String nomorRak;
    private List<Buku> daftarBuku;

    Rak(String nomorRak) {
        this.nomorRak = nomorRak;
        this.daftarBuku = new ArrayList<>();
    }

    public void tambahBuku(Buku buku) {
        this.daftarBuku.add(buku);
        System.out.println("Buku '" + buku.getJudul() + "' berhasil ditambahkan ke rak " + this.nomorRak);
    }

    public void tampilkanIsiRak() {
        System.out.println("\n===== Daftar Buku di Rak " + this.nomorRak + " =====");
        for (Buku buku : this.daftarBuku) {
            System.out.println("- " + buku.getJudul());
        }
        System.out.println("=================================\n");
    }
}