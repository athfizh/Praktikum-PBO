public class Orang04 {
    private String nama04;
    private boolean jenisKelamin04;
    private String alamat04;
    private String noTelp04;

    public Orang04(String nama04, boolean jenisKelamin04, String alamat04, String noTelp04) {
        this.nama04 = nama04;
        this.jenisKelamin04 = jenisKelamin04;
        this.alamat04 = alamat04;
        this.noTelp04 = noTelp04;
    }

    public void setNama04(String nama04) { this.nama04 = nama04; }
    public void setAlamat04(String alamat04) { this.alamat04 = alamat04; }
    public void setNoTelp04(String noTelp04) { this.noTelp04 = noTelp04; }

    public String getNama04() { return nama04; }
    public String getAlamat04() { return alamat04; }
    public String getNoTelp04() { return noTelp04; }
    public String getJenisKelaminString04() {
        return jenisKelamin04 ? "Laki-laki" : "Perempuan";
    }

    public void tampilkanInfo() {
        System.out.println("Nama            : " + getNama04());
        System.out.println("Jenis Kelamin   : " + getJenisKelaminString04());
        System.out.println("Alamat          : " + getAlamat04());
        System.out.println("No. Telepon     : " + getNoTelp04());
    }
}