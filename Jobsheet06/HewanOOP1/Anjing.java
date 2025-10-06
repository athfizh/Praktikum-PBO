package HewanOOP1;

class Anjing extends Hewan {
    public Anjing(String nama) {
        super(nama);
    }

    void menggonggong() {
        System.out.println("Guk... Guk!");
    }
    
    // Jawaban Tugas: Override metode bersuara()
    @Override
    void bersuara() {
        System.out.println("Guk!");
    }
}
