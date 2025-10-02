import java.util.ArrayList;
import java.util.List;

public class Member {
    private String memberId;
    private String nama;
    private List<Buku> bukuPinjaman;

    Member(String memberId, String nama) {
        this.memberId = memberId;
        this.nama = nama;
        this.bukuPinjaman = new ArrayList<>();
    }
    
    String getNama(){
        return this.nama;
    }

    public void pinjamBuku(Buku buku) {
        this.bukuPinjaman.add(buku);
        System.out.println("Member '" + this.nama + "' berhasil meminjam buku '" + buku.getJudul() + "'.");
    }

    public void tampilkanBukuPinjaman() {
        System.out.println("\n===== Buku yang Dipinjam oleh " + this.nama + " =====");
        for (Buku buku : this.bukuPinjaman) {
            System.out.println("- " + buku.getJudul());
        }
        System.out.println("==========================================\n");
    }
}