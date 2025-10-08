public class Supervisor extends Manajer {

    public Supervisor(String nama, int gaji) {
        super(nama, gaji);
    }

    // Override metode untuk menaikkan gaji sesuai ketentuan Supervisor
    @Override
    public void naikkanGaji() {
        this.gaji += 1500000;
    }
}