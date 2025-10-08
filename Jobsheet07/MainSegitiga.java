public class MainSegitiga {
    public static void main(String[] args) {
        Segitiga segitiga = new Segitiga();

        System.out.println("===== MENGGUNAKAN OVERLOADING METHOD =====");
        
        // Memanggil method totalSudut dengan 1 parameter
        System.out.println("Total Sudut (jika 1 sudut diketahui): " + segitiga.totalSudut(60));
        
        // Memanggil method totalSudut dengan 2 parameter
        System.out.println("Total Sudut (jika 2 sudut diketahui): " + segitiga.totalSudut(60, 30));
        
        System.out.println("----------------------------------------");
        
        // Memanggil method keliling dengan 3 parameter
        System.out.println("Keliling (jika 3 sisi diketahui): " + segitiga.keliling(10, 12, 14));
        
        // Memanggil method keliling dengan 2 parameter
        // Hasilnya adalah double
        System.out.printf("Keliling (jika 2 sisi siku-siku diketahui): %.2f\n", segitiga.keliling(10, 12));
    }
}