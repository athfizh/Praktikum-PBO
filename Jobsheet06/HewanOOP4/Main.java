package HewanOOP4;

public class Main {
    public static void main(String[] args) {
        Anjing anjing = new Anjing("Doggy", 5, "Kasar");
        anjing.info(); // Memanggil metode info() yang telah di-override
        
        // Mengakses atribut private melalui metode public (getter)
        System.out.println("Jenis bulu anjing ini adalah " + anjing.getJenisBulu());
    }
}