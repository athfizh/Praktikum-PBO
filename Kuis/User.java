public class User {
    
    private String nama;
    private String email;
    
    public User(String nama, String email) {
        this.nama = nama;
        this.email = email;
    }

    public String getNama() {
        return nama;
    }
    
    public String getEmail() {
        return email;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void tampilkanInfo() {
        System.out.println("Nama: " + nama);
        System.out.println("Email: " + email);
    }
}