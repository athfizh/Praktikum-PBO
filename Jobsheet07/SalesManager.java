public class SalesManager extends Manajer {
    // Atribut tambahan khusus untuk SalesManager
    private String departemen;

    public SalesManager(String nama, String departemen, int gaji) {
        super(nama, gaji); // Memanggil konstruktor kelas Manajer
        this.departemen = departemen;
    }

    // Override metode cetakStatus() untuk menampilkan departemen
    @Override
    public void cetakStatus() {
        System.out.println("Nama: " + this.nama);
        System.out.println("Departemen: " + this.departemen);
        System.out.println("Gaji: " + this.gaji);
    }
}