package athaullahafizh.relasiclass.tugas;

public class Perpustakaan {
    private String nama;
    private String alamat;
    private Petugas petugas;
    private Buku[] daftarBuku;
    private Anggota[] daftarAnggota;
    
    public Perpustakaan() {
        this.daftarBuku = new Buku[10];
        this.daftarAnggota = new Anggota[10];
    }
    
    public Perpustakaan(String nama, String alamat, Petugas petugas) {
        this.nama = nama;
        this.alamat = alamat;
        this.petugas = petugas;
        this.daftarBuku = new Buku[10];
        this.daftarAnggota = new Anggota[10];
    }
    
    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public String getNama() {
        return nama;
    }
    
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
    public String getAlamat() {
        return alamat;
    }
    
    public void setPetugas(Petugas petugas) {
        this.petugas = petugas;
    }
    
    public Petugas getPetugas() {
        return petugas;
    }
    
    public void setDaftarBuku(Buku[] daftarBuku) {
        this.daftarBuku = daftarBuku;
    }
    
    public Buku[] getDaftarBuku() {
        return daftarBuku;
    }
    
    public void setDaftarAnggota(Anggota[] daftarAnggota) {
        this.daftarAnggota = daftarAnggota;
    }
    
    public Anggota[] getDaftarAnggota() {
        return daftarAnggota;
    }
    
    public void tambahBuku(Buku buku, int index) {
        this.daftarBuku[index] = buku;
    }
    
    public void tambahAnggota(Anggota anggota, int index) {
        this.daftarAnggota[index] = anggota;
    }
    
    public String info() {
        String info = "";
        info += "Nama Perpustakaan: " + nama + "\n";
        info += "Alamat: " + alamat + "\n";
        info += petugas.info();
        info += "\nDaftar Buku:\n";
        for (Buku buku : daftarBuku) {
            if (buku != null) {
                info += buku.info() + "\n";
            }
        }
        info += "Daftar Anggota:\n";
        for (Anggota anggota : daftarAnggota) {
            if (anggota != null) {
                info += anggota.info() + "\n";
            }
        }
        return info;
    }
}