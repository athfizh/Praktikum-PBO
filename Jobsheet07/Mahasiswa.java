public class Mahasiswa extends Manusia {
    // Overriding method makan() dari superclass Manusia
    @Override
    public void makan() {
        System.out.println("Mahasiswa makan mie instan di akhir bulan.");
    }

    public void tidur() {
        System.out.println("Mahasiswa butuh tidur setelah mengerjakan tugas.");
    }
}