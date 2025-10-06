package HewanOOP3;

public class Main {
    public static void main(String[] args) {
        Anjing anjing = new Anjing("Doggy", 3, "Golden Retriever");
        anjing.berjalan();   // Metode dari kelas Hewan
        anjing.menyusui(); // Metode dari kelas Mamalia
        anjing.menggonggong(); // Metode dari kelas Anjing itu sendiri
    }
}