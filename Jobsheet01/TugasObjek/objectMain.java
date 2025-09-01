package TugasObjek;

public class objectMain {
    public static void main(String[] args) {
        HP hp1 = new HP();
        hpGaming hp2 = new hpGaming();
        motor mtr1 = new motor();
        motorTrail mtr2 = new motorTrail();
        laptop lptp1 = new laptop();
        jamTangan jtangan1 = new jamTangan();

        System.out.println("HP Super Class");
        hp1.setMerek("Samsung");
        hp1.setSistemOperasi("Android");
        hp1.hidupkan();
        hp1.isiDaya(60);
        hp1.cetakStatus();

        System.out.println(); 
        System.out.println("HP Sub Class");
        hp2.setMerek("ASUS ROG");
        hp2.setSistemOperasi("Android");
        hp2.hidupkan();
        hp2.isiDaya(100);
        hp2.nyalakanMode();
        hp2.cetakStatus();

        System.out.println();
        System.out.println("Motor Super Class");
        mtr1.setMerek("Honda Vario");
        mtr1.tambahKecepatan(60);
        mtr1.setKapasitasMesin(125);
        mtr1.hidupkan();
        mtr1.cetakStatus();

        System.out.println();
        System.out.println("Motor Sub Class");
        mtr2.setMerek("CRF");
        mtr2.tambahKecepatan(120);
        mtr2.setKapasitasMesin(150);
        mtr2.tipeBan("Ban Offroad");
        mtr2.hidupkan();
        mtr2.cetakStatus();

        System.out.println();
        System.out.println("Laptop");
        lptp1.setMerek("Lenovo");
        lptp1.setWarna("Hitam");
        lptp1.hidupkan();
        lptp1.isiDaya(100);
        lptp1.setUkuranLayar(14);
        lptp1.cetakStatus();

        System.out.println();
        System.out.println("Jam Tangan");
        jtangan1.setMerek("Rolex");
        jtangan1.setWarna("Hitam");
        jtangan1.tahanAir();
        jtangan1.setTipe("Analog");
        jtangan1.cetakStatus();
    }
}