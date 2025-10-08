public class Dosen extends Manusia {
    // Overriding method makan() dari superclass Manusia
    @Override
    public void makan() {
        System.out.println("Dosen makan agar kuat memberikan nilai.");
    }

    public void lembur() {
        System.out.println("Dosen sering lembur untuk menyelesaikan pekerjaan.");
    }
}