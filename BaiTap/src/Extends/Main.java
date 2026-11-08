package Extends;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Danh sách gồm cả điểm 2D và 3D
        List<Diem2D> ds = new ArrayList<>();
        ds.add(new Diem2D(1, 2));
        ds.add(new Diem3D(1, 2, 3));
        ds.add(new Diem2D(4, 6));
        ds.add(new Diem3D(4, 6, 8));
        ds.add(new Diem2D(-3, 5));
        ds.add(new Diem3D(-2, 0, 7));

        // 2. Tổng khoảng cách (giữa các điểm liên tiếp cùng loại)
        Diem2D truoc2D = null;
        Diem3D truoc3D = null;
        double tong2D = 0, tong3D = 0;

        for (Diem2D p : ds) {
            if (p instanceof Diem3D) {
                Diem3D q = (Diem3D) p;
                if (truoc3D != null) tong3D += truoc3D.khoangCach(q);
                truoc3D = q;
            } else {
                if (truoc2D != null) tong2D += truoc2D.khoangCach(p);
                truoc2D = p;
            }
        }
        System.out.printf("Tong khoang cach cac diem 2D: %.4f%n", tong2D);
        System.out.printf("Tong khoang cach cac diem 3D: %.4f%n", tong3D);

        // 3. Thêm các điểm đối xứng vào danh sách (duyệt trên bản sao)
        for (Diem2D p : new ArrayList<>(ds)) {
            ds.add(p.doiXung()); // đa hình: 3D tự gọi doiXung của 3D
        }

        // Hiển thị danh sách
        System.out.println("\nDanh sach diem:");
        for (int i = 0; i < ds.size(); i++) {
            System.out.println((i + 1) + ". " + ds.get(i));
        }

        // Demo tịnh tiến
        Diem3D d = new Diem3D(1, 1, 1);
        d.tinhTien(2, 3, 4);
        System.out.println("\nSau tinh tien (2,3,4): " + d);
    }
}
