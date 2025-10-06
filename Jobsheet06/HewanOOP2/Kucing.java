package HewanOOP2;

class Kucing extends Hewan {
    private String ras; // Atribut tambahan

    // Konstruktor dimodifikasi untuk menerima parameter ras
    public Kucing(String nama, int umur, String ras) {
        super(nama, umur); // Memanggil konstruktor Hewan dengan benar
        this.ras = ras;
        System.out.println("Konstruktor Kucing dipanggil");
    }

    public void info() {
        System.out.println("Nama: " + nama);
        System.out.println("Umur: " + umur + " tahun");
        System.out.println("Ras: " + ras);
    }
}