public class Konten {
    private String judul;
    private int durasi; 

    public Konten(String judul, int durasi) {
        this.judul = judul;
        this.durasi = durasi;
    }

    public String getJudul() {
        return judul;
    }
    
    public int getDurasi() {
        return durasi;
    }

    public void tampilkan() {
        System.out.println("Menampilkan konten: " + judul);
        System.out.println("Durasi: " + durasi + " menit");
    }
}