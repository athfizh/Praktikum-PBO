package HewanOOP3;

class Hewan {
    String nama;
    int umur;

    public Hewan(String nama, int umur) {
        this.nama = nama;
        this.umur = umur;
    }
    
    public void berjalan() {
        System.out.println(this.nama + " sedang berjalan...");
    }
}