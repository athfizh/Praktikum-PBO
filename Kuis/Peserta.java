public class Peserta extends User {
    private int jumlahKursus;

    public Peserta(String nama, String email) {
        super(nama, email); 
        this.jumlahKursus = 0;
    }

    public void daftarKursus() {
        jumlahKursus++;
        System.out.println(getNama() + " mendaftar kursus baru!");
        System.out.println("Total kursus: " + jumlahKursus);
    }
    
    public void lihatProgress() {
        System.out.println("Progress belajar: " + (jumlahKursus * 10) + "%");
    }
}