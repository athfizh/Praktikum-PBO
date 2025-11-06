public class Tester1 {
    public static void main(String[] args) {
        PermanentEmployee pEmp = new PermanentEmployee("Dedik", 500);
        InternshipEmployee iEmp = new InternshipEmployee("Sunarto", 5);
        // Menggunakan "R-1" agar sesuai logika getBasePrice()
        ElectricityBill eBill = new ElectricityBill(5, "R-1"); 
        Employee e;
        Payable p;

        e = pEmp;
        e = iEmp;

        p = pEmp;
        p = eBill;
    }
}