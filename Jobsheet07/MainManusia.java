public class MainManusia {
    public static void main(String[] args) {
        // Membuat objek referensi dari superclass
        Manusia manusia;

        System.out.println("===== DYNAMIC METHOD DISPATCH =====");
        
        // Objek Dosen direferensikan oleh Manusia
        manusia = new Dosen();
        manusia.bernafas(); // Memanggil method dari superclass
        manusia.makan();    // Memanggil method yang sudah di-override oleh Dosen
        // manusia.lembur(); // Ini akan error karena method lembur() tidak ada di class Manusia
        
        System.out.println("-----------------------------------");
        
        // Objek Mahasiswa direferensikan oleh Manusia
        manusia = new Mahasiswa();
        manusia.bernafas(); // Memanggil method dari superclass
        manusia.makan();    // Memanggil method yang sudah di-override oleh Mahasiswa
        // manusia.tidur(); // Ini akan error karena method tidur() tidak ada di class Manusia
    }
}