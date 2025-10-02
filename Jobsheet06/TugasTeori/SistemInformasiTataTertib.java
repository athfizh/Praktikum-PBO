import java.util.ArrayList;
import java.util.List;

public class SistemInformasiTataTertib {
    private List<Pelanggaran> daftarPelanggaran;

    public SistemInformasiTataTertib() {
        this.daftarPelanggaran = new ArrayList<>();
    }

    public void catatPelanggaran(Pelanggaran pelanggaran) {
        this.daftarPelanggaran.add(pelanggaran);
        System.out.println(">> Pelanggaran berhasil dicatat.");
    }

    public void lihatRiwayatPelanggaran(AnggotaKampus anggota) {
        System.out.println("\n--- RIWAYAT PELANGGARAN UNTUK: " + anggota.getNama().toUpperCase() + " (" + anggota.getId() + ") ---");
        boolean adaPelanggaran = false;
        int nomor = 1;

        for (Pelanggaran p : daftarPelanggaran) {
            // Memeriksa apakah ID pelanggar sama dengan ID anggota yang dicari
            if (p.getPelanggar().getId().equals(anggota.getId())) {
                System.out.println(nomor + ". Tanggal    : " + p.getTanggal());
                System.out.println("   Pelanggaran: " + p.getPeraturanDilanggar().getPeraturan());
                System.out.println("   Sanksi     : " + p.getPeraturanDilanggar().getSanksi());
                adaPelanggaran = true;
                nomor++;
            }
        }

        if (!adaPelanggaran) {
            System.out.println("Tidak ditemukan riwayat pelanggaran.");
        }
        System.out.println("------------------------------------------------------");
    }
}