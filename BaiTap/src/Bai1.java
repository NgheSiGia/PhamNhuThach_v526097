import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap so phan tu n: ");
        int n = sc.nextInt();

        int[] a = new int[n];
        int tong = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Nhap a[" + i + "]: ");
            a[i] = sc.nextInt();
            tong += a[i];
        }

        System.out.println("Tong cac phan tu: " + tong);

       sc.close();
    }
}