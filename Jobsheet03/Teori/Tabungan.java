package Teori;

public class Tabungan {
    private String norek;
    private String namaPemilik;
    private double saldo;

    public Tabungan(String norek, String namaPemilik, double saldo) {
        this.norek = norek;
        this.namaPemilik = namaPemilik;
        this.saldo = saldo;
    };

    private double hitungBunga(double bunga) {
        return this.saldo * bunga;
    }

    private double biayaTransfer(double jumlah) {
        return 2500;
    }

    void cekSaldo() {
        System.out.println("Tabungan Anda : " + this.saldo);
    }

    void simpanUang(double jumlah) {
        this.saldo += jumlah;
        System.out.println("Saldo bertambah Rp." + jumlah);
        System.out.println("Saldo Akhir Rp." + this.saldo);
    }

    void ambilUang(double jumlah) {
        this.saldo -= jumlah;
        System.out.println("Saldo berkurang Rp." + jumlah);
        System.out.println("Saldo Akhir Rp." + this.saldo);
    }

    void penyesuaianSaldo() {
        System.out.println("Saldo awal Rp." + this.saldo);
        System.out.println("Saldo bertambah Rp." + hitungBunga(0.5));
        this.saldo += hitungBunga(0.5);
        System.out.println("Saldo Akhir Rp." + this.saldo);
    }

    void kirimUang(double jumlah) {
        System.out.println("Saldo awal Rp." + this.saldo);
        System.out.println("Jumlah Transfer Rp." + jumlah);
        System.out.println("Biaya Transfer Rp." + biayaTransfer(jumlah));
        this.saldo = this.saldo - jumlah - biayaTransfer(jumlah);
        System.out.println("Saldo Akhir Rp." + this.saldo);
    }
}