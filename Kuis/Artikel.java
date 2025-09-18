public class Artikel extends Konten {
    private int jumlahHalaman;

    public Artikel(String judul, int durasi, int jumlahHalaman) {
        super(judul, durasi);
        this.jumlahHalaman = jumlahHalaman;
    }

    @Override
    public void tampilkan() {
        System.out.println("MEMBACA ARTIKEL");
        System.out.println("Judul: " + getJudul());
        System.out.println("Estimasi baca: " + getDurasi() + " menit");
        System.out.println("Jumlah halaman: " + jumlahHalaman);
        System.out.println("Artikel dibuka untuk dibaca...");
    }
}