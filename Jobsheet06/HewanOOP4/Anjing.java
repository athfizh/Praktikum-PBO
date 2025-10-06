package HewanOOP4;

class Anjing extends Hewan {
    private String jenisBulu; // Atribut bersifat private

    public Anjing(String nama, int umur, String jenisBulu) {
        super(nama, umur);
        this.jenisBulu = jenisBulu;
    }

    // Metode public untuk mengakses atribut private
    public String getJenisBulu() {
        return this.jenisBulu;
    }

    @Override
    public void info() {
        super.info(); // Memanggil metode info() dari superclass
        System.out.println("Jenis Bulu: " + this.jenisBulu);
    }
}