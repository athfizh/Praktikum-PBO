import java.util.ArrayList;
import java.util.List;

public class RekamMedik04 {
    private int id04;
    private Pasien04 pasien04;
    private List<Pemeriksaan04> daftarPemeriksaan04;

    public RekamMedik04(int id04, Pasien04 pasien04) {
        this.id04 = id04;
        this.pasien04 = pasien04;
        this.daftarPemeriksaan04 = new ArrayList<>();
    }

    public void tambahPemeriksaan04(Pemeriksaan04 pemeriksaan04) {
        this.daftarPemeriksaan04.add(pemeriksaan04);
    }

    public List<Pemeriksaan04> getDaftarPemeriksaan04() {
        return daftarPemeriksaan04;
    }
}