public class Dokter04 extends Orang04 {
    private int id04;
    private String spesialisasi04;

    public Dokter04(int id04, String nama04, boolean jenisKelamin04, String alamat04, String noTelp04, String spesialisasi04) {
        super(nama04, jenisKelamin04, alamat04, noTelp04);
        this.id04 = id04;
        this.spesialisasi04 = spesialisasi04;
    }

    public void setSpesialisasi04(String spesialisasi04) {
        this.spesialisasi04 = spesialisasi04;
    }

    public int getId04() { return id04; }
    public String getSpesialisasi04() { return spesialisasi04; }

    @Override
    public void tampilkanInfo() {
        System.out.println("ID Dokter       : " + getId04());
        super.tampilkanInfo();
        System.out.println("Spesialisasi    : " + getSpesialisasi04());
    }
}