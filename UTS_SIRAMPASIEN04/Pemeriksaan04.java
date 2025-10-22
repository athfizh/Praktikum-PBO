import java.util.Date;

public class Pemeriksaan04 {
    private int id04;
    private Date tanggalPemeriksaan04;
    private String keluhan04;
    private String diagnosa04;
    private String tindakan04;
    private String obat04;
    private Dokter04 dokter04;

    public Pemeriksaan04(int id04, Date tanggalPemeriksaan04, String keluhan04, String diagnosa04, String tindakan04, String obat04, Dokter04 dokter04) {
        this.id04 = id04;
        this.tanggalPemeriksaan04 = tanggalPemeriksaan04;
        this.keluhan04 = keluhan04;
        this.diagnosa04 = diagnosa04;
        this.tindakan04 = tindakan04;
        this.obat04 = obat04;
        this.dokter04 = dokter04;
    }

    public Date getTanggalPemeriksaan04() { return tanggalPemeriksaan04; }
    public String getKeluhan04() { return keluhan04; }
    public String getDiagnosa04() { return diagnosa04; }
    public String getTindakan04() { return tindakan04; }
    public String getObat04() { return obat04; }
    public Dokter04 getDokter04() { return dokter04; }
}