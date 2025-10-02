public class Pustakawan extends Staf {
    private double gajiPokok;
    private double tunjanganJabatan;

    Pustakawan(String stafId, String nama, double gajiPokok, double tunjanganJabatan) {
        super(stafId, nama);
        this.gajiPokok = gajiPokok;
        this.tunjanganJabatan = tunjanganJabatan;
    }

    @Override
    public void hitungGaji() {
        super.hitungGaji();
        double totalGaji = this.gajiPokok + this.tunjanganJabatan;
        System.out.println("Total Gaji: Rp. " + totalGaji);
    }
}