public class Pembayaran {
    private Peserta peserta;
    private Kursus kursus;
    private boolean statusBayar;

    public Pembayaran(Peserta peserta, Kursus kursus) {
        this.peserta = peserta;
        this.kursus = kursus;
        this.statusBayar = false;
    }

    public void bayar() {
        System.out.println("Memproses pembayaran...");
        System.out.println("Peserta: " + peserta.getNama());
        System.out.println("Kursus: " + kursus.getNamaKursus());
        System.out.println("Jumlah: Rp " + kursus.getHarga());
        
        statusBayar = true;
        System.out.println("Pembayaran berhasil!");

        peserta.daftarKursus();
    }
    
    public boolean getStatusBayar() {
        return statusBayar;
    }
}