public class TestTugasBarang {
    public static void main(String[] args) {
        TugasBarang barang1 = new TugasBarang();
        System.out.print("\n--- Contoh Barang Pertama ---");
        barang1.kode = "BRG001";
        barang1.namaBarang = "Smartphone";
        barang1.hargaDasar = 2000000;
        barang1.diskon = 0.15f;
        barang1.tampilData();

        System.out.println("\n--- Contoh Barang Kedua ---");
        TugasBarang barang2 = new TugasBarang();
        barang2.kode = "BRG002";
        barang2.namaBarang = "Headphone";
        barang2.hargaDasar = 500000;
        barang2.diskon = 0.2f;
        barang2.tampilData();
        
        System.out.println("\n--- Contoh Barang Ketiga ---");
        TugasBarang barang3 = new TugasBarang();
        barang3.kode = "BRG003";
        barang3.namaBarang = "Mouse Gaming";
        barang3.hargaDasar = 150000;
        barang3.diskon = 0.1f;
        barang3.tampilData();
    }
}