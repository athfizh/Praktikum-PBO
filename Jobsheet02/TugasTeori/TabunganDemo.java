package TugasTeori;

public class TabunganDemo {
    public static void main(String[] args) {
        Tabungan tab1 = new Tabungan("2441070", "Hafizh", 1000000);

        tab1.CekSaldo();
        tab1.SimpanUang(100000);
        tab1.AmbilUang(50000);
        tab1.CekSaldo();
    }
}