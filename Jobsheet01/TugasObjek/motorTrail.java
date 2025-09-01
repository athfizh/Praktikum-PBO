package TugasObjek;

public class motorTrail extends motor {
    private String tipeBan;

    public void tipeBan(String newValue){
        tipeBan = newValue;
    }

    public void cetakStatus(){
        super.cetakStatus();
        System.out.println("Tipe Ban: " + tipeBan);
    }
}