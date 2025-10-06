package KendaraanOOP;

public class Main {
    public static void main(String[] args) {
        Mobil mobil = new Mobil("Toyota", 2022, 4);
        Motor motor = new Motor("Honda", 2023, 150);
        Truk truk = new Truk("Hino", 2020, 10.5); // Objek Truk baru
        
        mobil.info();
        mobil.jalankan();
        System.out.println("-----");
        
        motor.info();
        motor.jalankan();
        System.out.println("-----");
        
        // Menjalankan metode pada objek Truk
        truk.info();
        truk.jalankan();
    }
}