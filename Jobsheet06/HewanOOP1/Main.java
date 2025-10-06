package HewanOOP1;

public class Main {
    public static void main(String[] args) {
        Hewan kucing = new Kucing("Milo");
        System.out.print("Suara Kucing: ");
        kucing.bersuara(); 

        System.out.println("--------------------");

        Hewan anjing = new Anjing("Doggy");
        System.out.print("Suara Anjing: ");
        anjing.bersuara(); // Output: Guk! (hasil override)
    }
}