package Teori;

public class Pinjaman {
    private String noPinjaman;
    private String namaPeminjam;
    private double jmlPinjaman;
    private boolean statusPinjaman;

    Pinjaman(String noPinjaman, String namaPeminjam, double jmlPinjaman) {
        this.noPinjaman = noPinjaman;
        this.namaPeminjam = namaPeminjam;
        this.jmlPinjaman = jmlPinjaman;
    }

    double getJmlPinjaman() {
        return this.jmlPinjaman;
    };

    boolean getStatusPeminjaman() {
        return this.statusPinjaman;
    }

    void ubahJumlahPinjaman(double jmlPinjaman) {
        this.jmlPinjaman = jmlPinjaman;
    }

    void setStatusPeminjaman(boolean status) {
        this.statusPinjaman = status;
    }

    protected double hitungBunga(double bunga) {
        return bunga * this.jmlPinjaman;
    }

    void detailPeminjaman() {
        System.out.println("Nomor Pinjaman    : " + this.noPinjaman);
        System.out.println("Nama Peminjam     : " + this.namaPeminjam);
        System.out.println("Jumlah Pinjaman   : Rp." + this.jmlPinjaman);
    };
}

class PinjamanKilat extends Pinjaman {
    private static final double MAX_TRANSACTION = 1_000_000;
    private static final double BUNGA = 0.010;

    PinjamanKilat(String noPinjaman, String namaPeminjam, double jmlPinjaman) {
        super(noPinjaman, namaPeminjam, jmlPinjaman);
    }

    private String tampilStatusPeminjaman() {
        return getStatusPeminjaman() ? "DISETUJUI - Dana Segera Cair!" : "DITOLAK - Melebihi limit pinjaman maksimal Rp. " + MAX_TRANSACTION;
    }

    void detailPeminjaman() {
        System.out.println("=== Detail Pinjaman Kilat ===");
        super.detailPeminjaman();
        if (getJmlPinjaman() < MAX_TRANSACTION) {
            setStatusPeminjaman(true);
        } else {
            setStatusPeminjaman(false);
        }

        if (getStatusPeminjaman()) {
            System.out.println("Bunga             : " + (BUNGA * 100) + "%");
            System.out.println("Total Kembali     : Rp." + (getJmlPinjaman() + hitungBunga(BUNGA)));
        }
        System.out.println("Status            : " + tampilStatusPeminjaman());
    }
}