import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap cac so nguyen cach nhau boi dau cach: ");
        String s = sc.nextLine().trim();

        if (s.isEmpty()) {
            System.out.println("So phan tu: 0");
            System.out.println("Tong: 0");
            sc.close();
            return;
        }

        String[] a = s.split("\\s+");

        int tong = 0;

        for (int i = 0; i < a.length; i++) {
            tong += Integer.parseInt(a[i]);
        }

        System.out.println("So phan tu: " + a.length);
        System.out.println("Tong: " + tong);

        sc.close();
    }
}
