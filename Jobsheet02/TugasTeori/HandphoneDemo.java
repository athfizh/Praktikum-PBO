package TugasTeori;

public class HandphoneDemo {
    public static void main(String[] args) {
        Handphone hp1 = new Handphone();
        hp1.TampilSemuaStatus();
        System.out.println();
        
        hp1.SetStatusAktif(1);       
        hp1.SetStatusPanggilan(2);  
        hp1.SetStatusSMS(1);        

        hp1.TampilSemuaStatus();
    }
}