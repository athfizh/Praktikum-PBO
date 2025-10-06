package HewanOOP3;

class Anjing extends Mamalia {
    private String jenisAnjing;

    public Anjing(String nama, int umur, String jenisAnjing) {
        super(nama, umur);
        this.jenisAnjing = jenisAnjing;
    }

    public void menggonggong() {
        System.out.println(this.nama + " menggonggong: Guk! Guk!");
    }
}