package TugasTeori;

public class Handphone {
    boolean statusAktif;
    String statusPanggilan;
    String statusSMS;

    public Handphone() {
        this.statusAktif = false;
        this.statusPanggilan = "Menunggu";
        this.statusSMS = "Menunggu";
    }

    public void SetStatusAktif(int status) {
        if (status == 0) {
            statusAktif = false;
        } else if (status == 1) {
            statusAktif = true;
        }
    }

    public void SetStatusPanggilan(int status) {
        if (status == 0) {
            statusPanggilan = "Menunggu";
        } else if (status == 1) {
            statusPanggilan = "Menerima Panggilan";
        } else if (status == 2) {
            statusPanggilan = "Melakukan Panggilan";
        }
    }

    public void SetStatusSMS(int status) {
        if (status == 0) {
            statusSMS = "Menunggu";
        } else if (status == 1) {
            statusSMS = "Menerima SMS";
        } else if (status == 2) {
            statusSMS = "Mengirim SMS";
        }
    }

    public void TampilSemuaStatus() {
        System.out.println("Status Aktif: " + (statusAktif ? "On" : "Off"));
        System.out.println("Status Panggilan: " + statusPanggilan);
        System.out.println("Status SMS: " + statusSMS);
    }
}