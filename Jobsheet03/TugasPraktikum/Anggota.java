package TugasPraktikum;

public class Anggota {
    private String nomorKTP;
    private String nama;
    private int limitPinjaman;
    private int jumlahPinjaman;

    public Anggota(String nomorKTP, String nama, int limitPinjaman) {
        this.nomorKTP = nomorKTP;
        this.nama = nama;
        this.limitPinjaman = limitPinjaman;
        this.jumlahPinjaman = 0;
    }
    
    public String getNomorKTP() {
        return nomorKTP;
    }
    
    public String getNama() {
        return nama;
    }
    
    public int getLimitPinjaman() {
        return limitPinjaman;
    }
    
    public int getJumlahPinjaman() {
        return jumlahPinjaman;
    }

    public void pinjam(int jumlah) {
        if (jumlahPinjaman + jumlah > limitPinjaman) {
            System.out.println("Maaf, jumlah pinjaman melebihi limit.");
        } else {
            jumlahPinjaman += jumlah;
        }
    }
    
    public void angsur(int jumlah) {
        if (jumlahPinjaman == 0) {
            System.out.println("Tidak ada pinjaman untuk diangsur.");
            return;
        }
        
        double minimalAngsuran = 0.1 * jumlahPinjaman;
        
        if (jumlah < minimalAngsuran) {
            System.out.println("Maaf, angsuran harus 10% dari jumlah pinjaman");
        } else if (jumlah > jumlahPinjaman) {
            System.out.println("Maaf, angsuran melebihi jumlah pinjaman.");
        } else {
            jumlahPinjaman -= jumlah;
        }
    }
}