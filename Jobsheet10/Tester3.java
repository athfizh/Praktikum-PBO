public class Tester3 {
    public static void main(String[] args) {
        PermanentEmployee pEmp = new PermanentEmployee("Dedik", 500);
        InternshipEmployee iEmp = new InternshipEmployee("Sunarto", 5);
        ElectricityBill eBill = new ElectricityBill(5, "R-1");
        
        // Array heterogen berbasis Super Class
        Employee e[] = { pEmp, iEmp };
        
        // Array heterogen berbasis Interface
        Payable p[] = { pEmp, eBill };
        
        // Baris ini akan error jika diaktifkan
        // Employee e2[] = { pEmp, iEmp, eBill }; 
    }
}