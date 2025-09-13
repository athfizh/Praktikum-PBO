package TugasPraktikum;

public class EncapTest {
    public static void main(String[] args) {
        EncapDemo encap = new EncapDemo();

        encap.setName("James");

        encap.setAge(35);
        System.out.println("Name : " + encap.getName());
        System.out.println("Age (set 35): " + encap.getAge());

        encap.setAge(15);
        System.out.println("Age (set 15): " + encap.getAge());

        encap.setAge(25);
        System.out.println("Age (set 25): " + encap.getAge());

        encap.setAge(18);
        System.out.println("Age (set 18): " + encap.getAge());

        encap.setAge(30);
        System.out.println("Age (set 30): " + encap.getAge());
    }
}