package KendaraanOOP;

class Truk extends Kendaraan {
    private double kapasitasMuatan; // dalam ton

    public Truk(String merk, int tahunProduksi, double kapasitasMuatan) {
        super(merk, tahunProduksi);
        this.kapasitasMuatan = kapasitasMuatan;
    }

    @Override
    void jalankan() {
        System.out.println("Truk " + merk + " berjalan dengan muatan...");
    }

    @Override
    void info() {
        super.info();
        System.out.println("Kapasitas Muatan: " + kapasitasMuatan + " ton");
    }
}