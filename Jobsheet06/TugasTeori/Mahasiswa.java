public class Mahasiswa extends AnggotaKampus {
    private String nim;
    private String programStudi;

    public Mahasiswa(String nama, String id, String nim, String programStudi) {
        // Memanggil constructor dari superclass (AnggotaKampus)
        super(nama, id);
        this.nim = nim;
        this.programStudi = programStudi;
    }

    public String getNim() {
        return nim;
    }

    public String getProgramStudi() {
        return programStudi;
    }
}