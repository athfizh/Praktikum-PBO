public class MainProgram {
    public static void main(String[] args) {
        System.out.println("=== STARTUP EDUTECH ANDI & BUDI ===\n");

        Instruktur andi = new Instruktur("Andi", "andi@edutech.com", "Programming");
        Instruktur budi = new Instruktur("Budi", "budi@edutech.com", "Marketing");

        Peserta siti = new Peserta("Siti", "siti@email.com");

        System.out.println("=== INFO INSTRUKTUR ===");
        andi.tampilkanInfo();
        budi.tampilkanInfo();
        System.out.println();
        
        System.out.println("=== INFO PESERTA ===");
        siti.tampilkanInfo();
        System.out.println();

        Kursus kursusJava = new Kursus("Java untuk Pemula", andi, 300000);
        kursusJava.tampilkanInfoKursus();
        System.out.println();

        Video videoJava = new Video("Pengenalan Java", 45, "HD");
        Artikel artikelOOP = new Artikel("Konsep OOP", 20, 5);
        Kuis kuisJava = new Kuis("Quiz Java Dasar", 15, 10, 100);

        System.out.println("=== KONTEN KURSUS ===");
        videoJava.tampilkan();
        System.out.println();
        artikelOOP.tampilkan();
        System.out.println();
        kuisJava.tampilkan();
        kuisJava.hitungSkor();
        System.out.println();

        System.out.println("=== PROSES PEMBAYARAN ===");
        Pembayaran bayar = new Pembayaran(siti, kursusJava);
        bayar.bayar();
        System.out.println();

        System.out.println("=== PROGRESS BELAJAR ===");
        siti.lihatProgress();
        
        System.out.println("\n Program selesai!");
    }
}