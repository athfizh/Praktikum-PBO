public class Segitiga {
    private int sudut;

    // Menghitung besar sudut ketiga jika satu sudut diketahui (asumsi segitiga sama kaki)
    public int totalSudut(int sudutA) {
        sudut = 180 - (sudutA * 2);
        return sudut;
    }

    // Menghitung besar sudut ketiga jika dua sudut diketahui
    public int totalSudut(int sudutA, int sudutB) {
        sudut = 180 - (sudutA + sudutB);
        return sudut;
    }

    // Menghitung keliling jika ketiga sisi diketahui
    public int keliling(int sisiA, int sisiB, int sisiC) {
        return sisiA + sisiB + sisiC;
    }
    
    // Menghitung keliling segitiga siku-siku jika dua sisi (alas dan tinggi) diketahui
    public double keliling(int sisiA, int sisiB) {
        // Menggunakan Pythagoras untuk mencari sisi miring (hipotenusa)
        double sisiC = Math.sqrt(Math.pow(sisiA, 2) + Math.pow(sisiB, 2));
        return sisiA + sisiB + sisiC;
    }
}