package TugasObjek;

public class hpGaming extends HP{
    private boolean modeGaming = false;
    
    public void nyalakanMode (){
        modeGaming = true;
    }

    public void matikanMode(){
        modeGaming = false;
    }

    public void cetakStatus(){
        super.cetakStatus();
        String statusText = (modeGaming) ? "Nyala" : "Mati";
        System.out.println("Mode Gaming: " + statusText);
    }
}