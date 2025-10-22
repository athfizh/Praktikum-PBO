public class Pasien04 extends Orang04 {
    private int id04;
    private RekamMedik04 rekamMedik04;

    public Pasien04(int id04, String nama04, boolean jenisKelamin04, String alamat04, String noTelp04) {
        super(nama04, jenisKelamin04, alamat04, noTelp04);
        this.id04 = id04;
        this.rekamMedik04 = new RekamMedik04(id04, this);
    }

    public int getId04() { return id04; }
    public RekamMedik04 getRekamMedik04() { return rekamMedik04; }

    @Override
    public void tampilkanInfo() {
        System.out.println("ID Pasien       : " + getId04());
        super.tampilkanInfo();
    }
}