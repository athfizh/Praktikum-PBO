package athaullahafizh.relasiclass.tugas;

public class Buku {
    private String isbn;
    private String judul;
    private String pengarang;
    private int harga;
    
    public Buku() {
    }
    
    public Buku(String isbn, String judul, String pengarang, int harga) {
        this.isbn = isbn;
        this.judul = judul;
        this.pengarang = pengarang;
        this.harga = harga;
    }
    
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    public String getIsbn() {
        return isbn;
    }
    
    public void setJudul(String judul) {
        this.judul = judul;
    }
    
    public String getJudul() {
        return judul;
    }
    
    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }
    
    public String getPengarang() {
        return pengarang;
    }
    
    public void setHarga(int harga) {
        this.harga = harga;
    }
    
    public int getHarga() {
        return harga;
    }
    
    public String info() {
        String info = "";
        info += "ISBN: " + isbn + "\n";
        info += "Judul: " + judul + "\n";
        info += "Pengarang: " + pengarang + "\n";
        info += "Harga: " + harga + "\n";
        return info;
    }
}