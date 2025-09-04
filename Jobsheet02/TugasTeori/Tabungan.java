package TugasTeori;

public class Tabungan {
    private String Norek;
    private String NamaPemilik;
    private double Saldo;

    public Tabungan(String Norek, String NamaPemilik, double Saldo) {
        this.Norek = Norek;
        this.NamaPemilik = NamaPemilik;
        this.Saldo = Saldo;
    }

    public void CekSaldo() {
        System.out.println("No. Rekening : " + Norek);
        System.out.println("Nama Pemilik : " + NamaPemilik);
        System.out.println("Saldo tabungan Anda sejumlah Rp." + Saldo);
        System.out.println();
    }

    public void SimpanUang(double Jumlah) {
        Saldo += Jumlah;
        System.out.println("No. Rekening : " + Norek);
        System.out.println("Nama Pemilik : " + NamaPemilik);
        System.out.println("Anda menyimpan uang sejumlah Rp." + Jumlah);
        System.out.println("Saldo tabungan Anda sejumlah Rp." + Saldo);
        System.out.println();
    }

    public void AmbilUang(double Jumlah) {
        if (Jumlah > Saldo) {
            System.out.println("Saldo tidak mencukupi!");
        } else {
            Saldo -= Jumlah;
            System.out.println("No. Rekening : " + Norek);
            System.out.println("Nama Pemilik : " + NamaPemilik);
            System.out.println("Anda mengambil uang sejumlah Rp." + Jumlah);
            System.out.println("Saldo tabungan Anda sejumlah Rp." + Saldo);
            System.out.println();
        }
    }
}