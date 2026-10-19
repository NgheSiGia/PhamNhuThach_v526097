package HCN;

public class Main {
    public static void main(String[] args) {

        TamGiac tg1 = new TamGiac(
                new Diem(0, 0),
                new Diem(3, 0),
                new Diem(0, 4)
        );

        TamGiac tg2 = new TamGiac(
                new Diem(0, 0),
                new Diem(4, 0),
                new Diem(2, 3)
        );

        ChuNhat cn1 = new ChuNhat(5, 3);
        ChuNhat cn2 = new ChuNhat(8, 4);

        HinhTron ht1 = new HinhTron(new Diem(0, 0), 3);
        HinhTron ht2 = new HinhTron(new Diem(2, 2), 5);

        System.out.println("Tam giac 1:");
        System.out.printf("Chu vi: %.2f%n", tg1.chuVi());
        System.out.printf("Dien tich: %.2f%n", tg1.dienTich());

        System.out.println("\nTam giac 2:");
        System.out.printf("Chu vi: %.2f%n", tg2.chuVi());
        System.out.printf("Dien tich: %.2f%n", tg2.dienTich());

        System.out.println("\nChu nhat 1:");
        System.out.printf("Chu vi: %.2f%n", cn1.chuVi());
        System.out.printf("Dien tich: %.2f%n", cn1.dienTich());

        System.out.println("\nChu nhat 2:");
        System.out.printf("Chu vi: %.2f%n", cn2.chuVi());
        System.out.printf("Dien tich: %.2f%n", cn2.dienTich());

        System.out.println("\nHinh tron 1:");
        System.out.printf("Chu vi: %.2f%n", ht1.chuVi());
        System.out.printf("Dien tich: %.2f%n", ht1.dienTich());

        System.out.println("\nHinh tron 2:");
        System.out.printf("Chu vi: %.2f%n", ht2.chuVi());
        System.out.printf("Dien tich: %.2f%n", ht2.dienTich());
    }
}