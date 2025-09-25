package athaullahafizh.relasiclass.tugas;

public class Petugas {
    private String nip;
    private String nama;
    
    public Petugas() {
    }
    
    public Petugas(String nip, String nama) {
        this.nip = nip;
        this.nama = nama;
    }
    
    public void setNip(String nip) {
        this.nip = nip;
    }
    
    public String getNip() {
        return nip;
    }
    
    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public String getNama() {
        return nama;
    }
    
    public String info() {
        String info = "";
        info += "NIP: " + nip + "\n";
        info += "Nama Petugas: " + nama + "\n";
        return info;
    }
}