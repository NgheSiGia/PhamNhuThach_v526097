import java.util.Scanner;
import java.util.Arrays;

public class Bai2 {

    public static int[] tinhTong(int[] a, int[] b) {
        int n = Math.max(a.length, b.length);
        int[] c = new int[n];

        for (int i = 0; i < n; i++) {
            if (i < a.length) {
                c[i] += a[i];
            }

            if (i < b.length) {
                c[i] += b[i];
            }
        }

        return c;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap so phan tu mang a: ");
        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("a[" + i + "] = ");
            a[i] = sc.nextInt();
        }

        System.out.print("Nhap so phan tu mang b: ");
        int m = sc.nextInt();
        int[] b = new int[m];

        for (int i = 0; i < m; i++) {
            System.out.print("b[" + i + "] = ");
            b[i] = sc.nextInt();
        }

        int[] c = tinhTong(a, b);

        System.out.println("Mang tong: " + Arrays.toString(c));

        sc.close();
    }
}