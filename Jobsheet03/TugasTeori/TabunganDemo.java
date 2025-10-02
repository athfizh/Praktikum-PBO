package Teori;

public class TabunganDemo {
    public static void main(String[] args) {
        Tabungan tbn1 = new Tabungan("AH", "Athaulla Hafizh", 100000);
        tbn1.cekSaldo();
        System.out.println("------------------------");
        tbn1.simpanUang(50000);
        System.out.println("------------------------");
        tbn1.ambilUang(50000);
        System.out.println("------------------------");
        tbn1.kirimUang(10000);
        System.out.println("------------------------");
        tbn1.penyesuaianSaldo();
    }
}