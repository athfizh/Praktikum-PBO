public class TestLingkaran {
    public static void main(String[] args) {
        Lingkaran lingkaran1 = new Lingkaran();
        lingkaran1.phi = 3.14;
        lingkaran1.r = 7.0;
        
        System.out.println("Phi: " + lingkaran1.phi);
        System.out.println("Jari-jari: " + lingkaran1.r);
        System.out.println("Luas Lingkaran: " + lingkaran1.hitungLuas());
        System.out.println("Keliling Lingkaran: " + lingkaran1.hitungKeliling());
    }
}