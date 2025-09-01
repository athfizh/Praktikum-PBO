package TugasObjek;

public class HP {
    String merek, sistemOperasi;
    private int kapasitasBaterai;
    private boolean statusHp = false;
    
    public void setMerek (String newValue){
        merek = newValue;
    }
    public void setSistemOperasi (String newValue){
        sistemOperasi = newValue;
    }

    void hidupkan() {
        statusHp = true;
    }

    void matikan() {
        statusHp = false;
    }   
    public void isiDaya(int increment){
        kapasitasBaterai = kapasitasBaterai + increment;
    }

    public void cetakStatus(){
        System.out.println("Merek: " + merek);
        System.out.println("Sistem Operasi: " + sistemOperasi);
        String statusText = (statusHp) ? "Nyala" : "Mati";
        System.out.println("Status HP: " + statusText);
        System.out.println("Baterai: " + kapasitasBaterai +"%");
    }
}