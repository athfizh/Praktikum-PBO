public class PetugasSirkulasi extends Staf {
    private double upahPerJam;
    private int jamKerja;

    PetugasSirkulasi(String stafId, String nama, double upahPerJam, int jamKerja) {
        super(stafId, nama);
        this.upahPerJam = upahPerJam;
        this.jamKerja = jamKerja;
    }

    @Override
    public void hitungGaji() {
        super.hitungGaji();
        double totalGaji = this.upahPerJam * this.jamKerja;
        System.out.println("Total Gaji: Rp. " + totalGaji);
    }
}