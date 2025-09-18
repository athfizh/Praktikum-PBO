public class Video extends Konten {
    private String kualitas;
    
    public Video(String judul, int durasi, String kualitas) {
        super(judul, durasi);
        this.kualitas = kualitas;
    }

    @Override
    public void tampilkan() {
        System.out.println("MEMUTAR VIDEO");
        System.out.println("Judul: " + getJudul());
        System.out.println("Durasi: " + getDurasi() + " menit");
        System.out.println("Kualitas: " + kualitas);
        System.out.println("Video sedang diputar...");
    }
}