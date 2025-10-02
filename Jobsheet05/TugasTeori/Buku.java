public class Buku {
    private String judul;
    private String penulis;
    private String isbn;

    Buku(String judul, String penulis, String isbn) {
        this.judul = judul;
        this.penulis = penulis;
        this.isbn = isbn;
    }

    String getJudul() {
        return this.judul;
    }

    public void tampilkanInfo() {
        System.out.println("Judul   : " + this.judul);
        System.out.println("Penulis : " + this.penulis);
        System.out.println("ISBN    : " + this.isbn);
        System.out.println("---------------------------------");
    }
}