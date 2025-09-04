public class TestPeminjaman {
    public static void main(String[] args) {
        Peminjaman pinjam1 = new Peminjaman();
        pinjam1.id = "P001";
        pinjam1.namaMember = "Ahmad";
        pinjam1.namaGame = "FIFA 2024";
        pinjam1.lamaSewa = 3;
        pinjam1.harga = 15000.0;
        
        pinjam1.tampilDataPeminjaman();
        System.out.println("Harga yang harus dibayar: Rp " + pinjam1.hitungHargaBayar(pinjam1.lamaSewa, pinjam1.harga));
    }
}