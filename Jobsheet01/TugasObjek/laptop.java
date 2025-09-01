package TugasObjek;

public class laptop {
    String merek, warna;
    private int ukuranLayar, kapasitasBaterai;
    private boolean statusLaptop = false;

    public void setMerek(String newValue){
        merek = newValue;
    }
    
    public void setWarna(String newValue){
        warna = newValue;
    }
    void hidupkan() {
        statusLaptop = true;
    }

    void matikan() {
        statusLaptop = false;
    }       

    public void isiDaya(int increment){
        kapasitasBaterai = kapasitasBaterai + increment;
    }
    public void setUkuranLayar(int newValue){
        ukuranLayar = newValue;
    }

    public void cetakStatus(){
        System.out.println("Merek: " + merek);
        System.out.println("Warna: " + warna);
        System.out.println("Ukuran Layar: " + ukuranLayar + "inch");
        String statusText = (statusLaptop) ? "Nyala" : "Mati";
        System.out.println("Status Laptop: " + statusText);
        System.out.println("Baterai: " +kapasitasBaterai+"%");
    }
}