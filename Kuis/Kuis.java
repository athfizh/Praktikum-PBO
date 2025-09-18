public class Kuis extends Konten {
    private int jumlahSoal;
    private int skorMaksimal;

    public Kuis(String judul, int durasi, int jumlahSoal, int skorMaksimal) {
        super(judul, durasi);
        this.jumlahSoal = jumlahSoal;
        this.skorMaksimal = skorMaksimal;
    }

    @Override
    public void tampilkan() {
        System.out.println("MEMULAI KUIS");
        System.out.println("Judul: " + getJudul());
        System.out.println("Durasi: " + getDurasi() + " menit");
        System.out.println("Jumlah soal: " + jumlahSoal);
        System.out.println("Skor maksimal: " + skorMaksimal);
        System.out.println("Kuis dimulai...");
    }
    
    public void hitungSkor() {
        int skor = (int)(Math.random() * skorMaksimal);
        System.out.println("Skor Anda: " + skor + "/" + skorMaksimal);
    }
}