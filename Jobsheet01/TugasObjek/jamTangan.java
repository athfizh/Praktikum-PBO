package TugasObjek;

public class jamTangan{
    String merek, warna, tipeJamtangan;
    private boolean tahanAir = false;
    
    public void setMerek(String newValue){
        merek = newValue;
    }

    public void setWarna(String newValue){
        warna = newValue;
    }

    public void tahanAir(){
        tahanAir = true;
    }

    public void tidakTahanAir(){
        tahanAir = false;
    }

    public void setTipe(String newValue){
        tipeJamtangan = newValue;
    }

    public void cetakStatus(){
        System.out.println("Merek: " + merek);
        System.out.println("Warna: " + warna);
        String statusText = (tahanAir) ? "YA" : "Tidak";
        System.out.println("Tahan Air: " + statusText );
        System.out.println("Tipe Jam Tangan: " + tipeJamtangan);
    }
}