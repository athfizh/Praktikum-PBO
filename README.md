<div align="center">

```
 ██████╗ ██████╗  ██████╗ 
 ██╔══██╗██╔══██╗██╔═══██╗
 ██████╔╝██████╔╝██║   ██║
 ██╔═══╝ ██╔══██╗██║   ██║
 ██║     ██████╔╝╚██████╔╝
 ╚═╝     ╚═════╝  ╚═════╝ 

 Praktikum Pemrograman Berbasis Objek
```

# Praktikum PBO

### *Object-Oriented Programming Lab — Semester Repository*

<br/>

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![OOP](https://img.shields.io/badge/OOP-Paradigm-007396?style=for-the-badge&logo=java&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ_IDEA-000000?style=for-the-badge&logo=intellij-idea&logoColor=white)
![NetBeans](https://img.shields.io/badge/NetBeans-1B6AC6?style=for-the-badge&logo=apache-netbeans-ide&logoColor=white)

<br/>

> *"Object-oriented programming is an exceptionally bad idea which could only have originated in California."*
> — Edsger W. Dijkstra *(but we're learning it anyway)*

<br/>

[![GitHub commits](https://img.shields.io/github/commit-activity/m/athfizh/Praktikum-PBO?style=flat-square&color=ED8B00&label=Commits)](https://github.com/athfizh/Praktikum-PBO/commits)
[![GitHub repo size](https://img.shields.io/github/repo-size/athfizh/Praktikum-PBO?style=flat-square&color=34d399&label=Repo%20Size)](https://github.com/athfizh/Praktikum-PBO)
[![GitHub last commit](https://img.shields.io/github/last-commit/athfizh/Praktikum-PBO?style=flat-square&color=f472b6&label=Last%20Update)](https://github.com/athfizh/Praktikum-PBO)
![Language](https://img.shields.io/badge/Language-Java%20100%25-ED8B00?style=flat-square&logo=openjdk)

</div>

---

## 👤 Identitas Mahasiswa

<table>
  <tr>
    <td><b>Nama</b></td>
    <td>Athaulla Hafizh</td>
  </tr>
  <tr>
    <td><b>Presensi / NIM</b></td>
    <td>04 / 244107020030</td>
  </tr>
  <tr>
    <td><b>Kelas</b></td>
    <td><a>TI-2A</a></td>
  </tr>
  <tr>
    <td><b>Mata Kuliah</b></td>
    <td>Pemrograman Berbasis Objek (PBO)</td>
  </tr>
  <tr>
    <td><b>Program Studi</b></td>
    <td>D-IV Teknik Informatika</td>
  </tr>
  <tr>
    <td><b>Jurusan</b></td>
    <td>Teknologi Informasi — Politeknik Negeri Malang</td>
  </tr>
</table>

---

## 📂 Struktur Repository

```
Praktikum-PBO/
│
├── 📁 Jobsheet01/          # Pengenalan Java & Dasar OOP
├── 📁 Jobsheet02/          # Class, Object & Constructor
├── 📁 Jobsheet03/          # Encapsulation & Access Modifier
├── 📁 Jobsheet05/          # Inheritance (Pewarisan)
├── 📁 Jobsheet06/          # Polymorphism
├── 📁 Jobsheet07/          # Abstract Class & Interface
├── 📁 Jobsheet09/          # Exception Handling
├── 📁 Jobsheet10/          # Collection & Generic (Java)
├── 📁 Jobsheet11/          # GUI — Kalkulator (Tugas Kelompok)
├── 📁 Jobsheet13/          # Materi & Project Akhir
│
├── 📁 Kalkulator/          # 🧮 Aplikasi Kalkulator (Tugas Kelompok)
├── 📁 Kuis/                # Tugas Kuis
├── 📁 UTS_SIRAMPASIEN04/   # 🏥 Project UTS — Sistem Rawat Pasien
│
└── 📄 .gitignore
```

---

## 📋 Rekap Jobsheet Praktikum

| No | Jobsheet | Topik Utama | Konsep OOP | Status |
|----|----------|-------------|------------|--------|
| 1 | `Jobsheet01` | Pengenalan Java & Struktur Program | Class, Method, Main | ✅ |
| 2 | `Jobsheet02` | Class & Object | Constructor, Attribute | ✅ |
| 3 | `Jobsheet03` | Encapsulation | Getter, Setter, Access Modifier | ✅ |
| 5 | `Jobsheet05` | Inheritance | `extends`, `super` | ✅ |
| 6 | `Jobsheet06` | Polymorphism | Override, Overloading | ✅ |
| 7 | `Jobsheet07` | Abstract & Interface | `abstract`, `implements` | ✅ |
| 9 | `Jobsheet09` | Exception Handling | `try`, `catch`, `finally` | ✅ |
| 10 | `Jobsheet10` | Collection & JavaScript Integration | `ArrayList`, Generic | ✅ |
| 11 | `Jobsheet11` | GUI & Kalkulator | Java Swing / JavaFX | ✅ |
| 13 | `Jobsheet13` | Review & Project | Full OOP | ✅ |

---

## 🧠 Konsep OOP yang Dipelajari

<div align="center">

```
┌──────────────────────────────────────────────────────────────┐
│              4 PILAR PEMROGRAMAN BERBASIS OBJEK              │
├──────────────────┬───────────────────────────────────────────┤
│  🔒 Encapsulation │ Menyembunyikan data dengan getter/setter  │
│  🧬 Inheritance   │ Pewarisan sifat dari class parent         │
│  🎭 Polymorphism  │ Satu interface, banyak implementasi       │
│  🎨 Abstraction   │ Menyembunyikan detail implementasi        │
└──────────────────┴───────────────────────────────────────────┘
```

</div>

### 🔒 Encapsulation
```java
public class Mahasiswa {
    private String nama;    // Data tersembunyi
    private int nim;

    public String getNama() { return nama; }         // Getter
    public void setNama(String nama) { this.nama = nama; } // Setter
}
```

### 🧬 Inheritance
```java
public class Dosen extends Orang {  // Mewarisi class Orang
    private String mataKuliah;

    @Override
    public void perkenalan() {
        super.perkenalan();  // Memanggil method parent
        System.out.println("Mengajar: " + mataKuliah);
    }
}
```

### 🎭 Polymorphism
```java
Orang[] data = new Orang[2];
data[0] = new Mahasiswa("Athaulla", "12345");
data[1] = new Dosen("Pak Budi", "PBO");

for (Orang o : data) {
    o.perkenalan();  // Setiap objek punya perilaku berbeda
}
```

### 🎨 Abstract Class & Interface
```java
public abstract class Kendaraan {
    public abstract void bergerak();  // Wajib diimplementasikan
    public void berhenti() { System.out.println("Berhenti!"); }
}

public interface Bisa Terbang {
    void terbang();
}
```

---

## 🏥 PROJECT UTS — Sistem Rawat Pasien (SIRAMPASIEN04)

<div align="center">

```
 ██████╗ ██╗██████╗  █████╗ ███╗   ███╗██████╗  █████╗ ███████╗██╗███████╗███╗   ██╗
██╔════╝ ██║██╔══██╗██╔══██╗████╗ ████║██╔══██╗██╔══██╗██╔════╝██║██╔════╝████╗  ██║
╚█████╗  ██║██████╔╝███████║██╔████╔██║██████╔╝███████║███████╗██║█████╗  ██╔██╗ ██║
 ╚═══██╗ ██║██╔══██╗██╔══██║██║╚██╔╝██║██╔═══╝ ██╔══██║╚════██║██║██╔══╝  ██║╚██╗██║
██████╔╝ ██║██║  ██║██║  ██║██║ ╚═╝ ██║██║     ██║  ██║███████║██║███████╗██║ ╚████║
╚═════╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═╝╚═╝     ╚═╝╚═╝     ╚═╝  ╚═╝╚══════╝╚═╝╚══════╝╚═╝  ╚═══╝
```

### 🏥 Aplikasi Manajemen Rawat Pasien Berbasis Java

</div>

> Project UTS berupa aplikasi **Sistem Rawat Pasien** yang dibangun dengan **Java** menggunakan prinsip-prinsip OOP secara menyeluruh — dari manajemen data pasien, dokter, hingga rekam medis.

### ✨ Fitur Aplikasi

```
┌────────────────────────────────────────────────────────┐
│               FITUR SIRAMPASIEN04                      │
├────────────────────────────────────────────────────────┤
│  🧑‍⚕️  Manajemen Pasien    │  Tambah, edit, hapus data   │
│  👨‍⚕️  Manajemen Dokter    │  Data dokter & spesialis    │
│  📋  Rekam Medis          │  Riwayat diagnosis & obat   │
│  🏥  Rawat Inap/Jalan     │  Pengelolaan jenis rawat    │
│  💊  Data Obat & Resep    │  Manajemen obat pasien      │
│  🖥️  GUI Interaktif        │  Antarmuka Java Swing       │
└────────────────────────────────────────────────────────┘
```

### 🏗️ Desain Class (OOP Architecture)

```
         ┌──────────┐
         │  Orang   │  ← Abstract Class
         └────┬─────┘
       ┌──────┴──────┐
  ┌────┴───┐    ┌────┴────┐
  │ Pasien │    │  Dokter │
  └────────┘    └─────────┘
       │              │
  ┌────┴────────────┐
  │   RekamMedis   │  ← Relasi komposisi
  └────────────────┘
```

---

## 🧮 TUGAS KELOMPOK — Aplikasi Kalkulator

> Proyek kolaborasi kelompok membangun **Aplikasi Kalkulator** berbasis Java dengan GUI (Graphical User Interface) menggunakan **Java Swing**.

### Fitur Kalkulator:
- ✔️ Operasi dasar: tambah, kurang, kali, bagi
- ✔️ Antarmuka grafis (GUI) dengan Java Swing
- ✔️ Validasi input dan penanganan error
- ✔️ Menerapkan konsep OOP (class, method, encapsulation)

```java
public class Kalkulator {
    private double hasil;

    public double tambah(double a, double b)  { return a + b; }
    public double kurang(double a, double b)  { return a - b; }
    public double kali(double a, double b)    { return a * b; }
    public double bagi(double a, double b)  {
        if (b == 0) throw new ArithmeticException("Tidak bisa dibagi nol!");
        return a / b;
    }
}
```

---

## 🚀 Cara Menjalankan Project

### Prasyarat
```bash
# Pastikan Java sudah terinstall
java -version
# Java 8 atau lebih baru (direkomendasikan Java 11/17)

# Compile file Java
javac NamaFile.java

# Jalankan program
java NamaFile
```

### Di IntelliJ IDEA / NetBeans
```
1. File → Open → Pilih folder Jobsheet yang diinginkan
2. Klik kanan pada file Main.java
3. Pilih "Run 'Main'"
4. Lihat output di konsol
```

---

## 🎯 Capaian Pembelajaran

- [x] Memahami paradigma **Object-Oriented Programming (OOP)**
- [x] Mengimplementasikan **Class & Object** di Java
- [x] Menerapkan **Encapsulation** dengan getter dan setter
- [x] Membangun hierarki class dengan **Inheritance**
- [x] Mengimplementasikan **Polymorphism** (override & overload)
- [x] Merancang **Abstract Class** dan **Interface**
- [x] Menangani error dengan **Exception Handling**
- [x] Menggunakan **Collection Framework** (ArrayList, HashMap)
- [x] Membangun aplikasi **GUI** dengan Java Swing
- [x] Mengembangkan aplikasi OOP lengkap dalam **Project UTS**

---

## 📊 Statistik Bahasa

<div align="center">

```
Java  ████████████████████████████████████████  100%
```

*100% Java — Murni dan Konsisten ☕*

</div>

---

## 📬 Kontak

<div align="center">

**Athaulla Hafizh**

[![GitHub](https://img.shields.io/badge/GitHub-athfizh-181717?style=for-the-badge&logo=github&logoColor=white)](https://github.com/athfizh)

</div>

---

<div align="center">

<sub>☕ Repository ini merupakan dokumentasi perjalanan belajar <b>Pemrograman Berbasis Objek</b></sub>

<br/>

</div>
