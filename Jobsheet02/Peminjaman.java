public class Peminjaman {
    public String id;
    public String namaMember;
    public String namaGame;
    public int lamaSewa;
    public double harga;
    
    public void tampilDataPeminjaman() {
        System.out.println("ID Peminjaman: " + id);
        System.out.println("Nama Member: " + namaMember);
        System.out.println("Nama Game: " + namaGame);
        System.out.println("Lama Sewa: " + lamaSewa + " hari");
        System.out.println("Harga per hari: Rp " + harga);
        System.out.println("Total Harga: Rp " + hitungHargaBayar(lamaSewa, harga));
    }
    
    public double hitungHargaBayar(int lamaSewa, double harga) {
        return lamaSewa * harga;
    }
}