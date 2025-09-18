public class Kursus {
    private String namaKursus;
    private Instruktur instruktur;
    private double harga;

    public Kursus(String namaKursus, Instruktur instruktur, double harga) {
        this.namaKursus = namaKursus;
        this.instruktur = instruktur;
        this.harga = harga;
    }

    public String getNamaKursus() {
        return namaKursus;
    }
    
    public double getHarga() {
        return harga;
    }
    
    public void tampilkanInfoKursus() {
        System.out.println("=== INFO KURSUS ===");
        System.out.println("Nama Kursus: " + namaKursus);
        System.out.println("Instruktur: " + instruktur.getNama());
        System.out.println("Harga: Rp " + harga);
    }
}