package MotorEncapsulation;

public class Motor {
    private int kecepatan = 0;
    private boolean kontakOn = false;
    private final int maxKecepatan = 100;

    public void nyalakanMesin() {
        kontakOn = true;
    }

    public void matikanMesin() {
        kontakOn = false;
        kecepatan = 0;
    }

    public void tambahKecepatan() {
        if (kontakOn == true) {
            if (kecepatan < maxKecepatan) {
                kecepatan += 5;
                if (kecepatan > maxKecepatan) {
                    kecepatan = maxKecepatan;
                }
            } else {
                System.out.println("Kecepatan sudah mencapai batas maksimal " + maxKecepatan + "! \n");
            }
        } else {
            System.out.println("Kecepatan tidak bisa bertambah karena Mesin Off! \n");
        }
    }

    public void kurangiKecepatan() {
        if (kontakOn == true && kecepatan > 0) {
            kecepatan -= 5;
        } else {
            System.out.println("Kecepatan tidak bisa berkurang karena Mesin Off! \n");
        }
    }
    
    void printStatus() {
        if (kontakOn == true) {
            System.out.println("Kontak On");
        } else {
            System.out.println("Kontak Off");
        }
        System.out.println("Kecepatan " + kecepatan + "\n");
    }
}