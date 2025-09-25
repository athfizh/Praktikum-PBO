package athaullahafizh.relasiclass.tugas;

public class Anggota {
    private String id;
    private String nama;
    private String alamat;
    
    public Anggota() {
    }
    
    public Anggota(String id, String nama, String alamat) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getId() {
        return id;
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
    
    public String info() {
        String info = "";
        info += "ID Anggota: " + id + "\n";
        info += "Nama: " + nama + "\n";
        info += "Alamat: " + alamat + "\n";
        return info;
    }
}