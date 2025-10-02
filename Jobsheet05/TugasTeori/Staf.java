public class Staf {
    private String stafId;
    private String nama;

    Staf(String stafId, String nama) {
        this.stafId = stafId;
        this.nama = nama;
    }

    String getNama() {
        return this.nama;
    }

    public void melayani(Member member) {
        System.out.println("Staf " + this.nama + " sedang melayani member " + member.getNama());
    }

    public void hitungGaji() {
        System.out.println("Menghitung gaji untuk " + this.nama + "...");
    }
}