package KendaraanOOP;

abstract class Kendaraan {
    protected String merk;
    protected int tahunProduksi;

    public Kendaraan(String merk, int tahunProduksi) {
        this.merk = merk;
        this.tahunProduksi = tahunProduksi;
    }

    abstract void jalankan(); // Abstract method, tanpa implementasi

    void info() {
        System.out.println("Merk: " + merk);
        System.out.println("Tahun produksi: " + tahunProduksi);
    }
}