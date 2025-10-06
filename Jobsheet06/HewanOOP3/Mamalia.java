package HewanOOP3;

class Mamalia extends Hewan {
    public Mamalia(String nama, int umur) {
        super(nama, umur);
    }

    void menyusui() {
        System.out.println(this.nama + " menyusui anaknya...");
    }
}