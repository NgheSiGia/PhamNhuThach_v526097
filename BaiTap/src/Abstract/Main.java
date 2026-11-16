package Abstract;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    private static final Random RND = new Random();

    private static double rnd(double min, double max) {
        return min + RND.nextDouble() * (max - min);
    }

    private static Point randomPoint() {
        return new Point(rnd(-10, 10), rnd(-10, 10));
    }

    private static Shape randomShape() {
        switch (RND.nextInt(5)) {
            case 0:  return randomPoint();
            case 1:  return new Line(randomPoint(), randomPoint());
            case 2:  return new Circle(randomPoint(), rnd(1, 6));
            case 3:
                while (true) {               // lặp đến khi 3 điểm không thẳng hàng
                    try {
                        return new Triangle(randomPoint(), randomPoint(), randomPoint());
                    } catch (IllegalArgumentException e) { /* thử lại */ }
                }
            default: return new Rectangle(randomPoint(), rnd(1, 8), rnd(1, 8));
        }
    }

    private static List<Shape> createShapes(int n) {
        List<Shape> list = new ArrayList<>();
        for (int i = 0; i < n; i++) list.add(randomShape());
        return list;
    }

    // ===== Hiển thị =====
    private static void display(List<Shape> shapes) {
        for (int i = 0; i < shapes.size(); i++) {
            Shape s = shapes.get(i);
            System.out.printf("%2d. %s%n    area=%.2f | perimeter=%.2f%n",
                    i + 1, s, s.area(), s.perimeter());
        }
    }

    private static double totalArea(List<Shape> shapes) {
        double sum = 0;
        for (Shape s : shapes) sum += s.area();
        return sum;
    }

    private static double totalPerimeter(List<Shape> shapes) {
        double sum = 0;
        for (Shape s : shapes) sum += s.perimeter();
        return sum;
    }

    private static Shape maxArea(List<Shape> shapes) {
        Shape best = shapes.get(0);
        for (Shape s : shapes) if (s.area() > best.area()) best = s;
        return best;
    }

    private static Shape minArea(List<Shape> shapes) {
        Shape best = shapes.get(0);
        for (Shape s : shapes) if (s.area() < best.area()) best = s;
        return best;
    }

    // ===== Biến đổi =====
    private static void zoomAll(List<Shape> shapes, double ratio) {
        for (Shape s : shapes) s.zoom(ratio);
    }

    public static void main(String[] args) {
        int n = 8;
        List<Shape> shapes = createShapes(n);

        System.out.println("===== DANH SÁCH " + n + " HÌNH NGẪU NHIÊN =====");
        display(shapes);

        System.out.println("\n===== THỐNG KÊ =====");
        System.out.printf("Tổng diện tích: %.2f%n", totalArea(shapes));
        System.out.printf("Tổng chu vi   : %.2f%n", totalPerimeter(shapes));
        Shape max = maxArea(shapes), min = minArea(shapes);
        System.out.printf("Diện tích lớn nhất: %.2f -> %s%n", max.area(), max);
        System.out.printf("Diện tích nhỏ nhất: %.2f -> %s%n", min.area(), min);

        double ratio = 1.5;
        System.out.println("\n===== PHÓNG TO TẤT CẢ VỚI RATIO = " + ratio + " =====");
        zoomAll(shapes, ratio);
        display(shapes);
        System.out.printf("Tổng diện tích sau zoom: %.2f%n", totalArea(shapes));
        System.out.printf("Tổng chu vi sau zoom   : %.2f%n", totalPerimeter(shapes));
    }
}
