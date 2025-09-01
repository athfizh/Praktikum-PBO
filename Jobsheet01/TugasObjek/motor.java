package TugasObjek;

public class motor {
    String merek,warna;
    private int kapasitasMesin, kecepatan;
    private boolean statusMotor = false;

    public void setMerek(String newValue){
        merek = newValue;
    }

    public void tambahKecepatan(int increment){
        kecepatan = kecepatan + increment;
    }

    public void setKapasitasMesin(int newValue){
        kapasitasMesin = newValue;
    }

    void hidupkan() {
        statusMotor = true;
    }

    void matikan() {
        statusMotor = false;
    }   

    public void cetakStatus(){
        System.out.println("Merek: " + merek);
        System.out.println("Kecepatan: " + kecepatan);
        System.out.println("Kapasitas Mesin: " + kapasitasMesin);
        String statusText = (statusMotor) ? "Nyala" : "Mati";
        System.out.println("Status Motor: " + statusText);
        
    }
}