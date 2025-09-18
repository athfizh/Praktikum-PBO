public class Instruktur extends User {
    private String keahlian;

    public Instruktur(String nama, String email, String keahlian) {
        super(nama, email); 
        this.keahlian = keahlian;
    }
    
    public String getKeahlian() {
        return keahlian;
    }

    public void buatKursus(String namaKursus) {
        System.out.println("Instruktur " + getNama() + " membuat kursus: " + namaKursus);
    }
    
    public void tampilkanInfo() {
        super.tampilkanInfo(); 
        System.out.println("Keahlian: " + keahlian);
    }
}