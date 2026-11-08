package Extends;

class Diem2D {
    // protected: lớp con (Diem3D) truy cập được
    protected double x;
    protected double y;

    public Diem2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() { return x; }
    public double getY() { return y; }

    // Khoảng cách giữa 2 điểm
    public double khoangCach(Diem2D p) {
        double dx = x - p.x;
        double dy = y - p.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    // Điểm đối xứng qua gốc tọa độ
    public Diem2D doiXung() {
        return new Diem2D(-x, -y);
    }

    // Tịnh tiến theo độ lệch dx, dy
    public void tinhTien(double dx, double dy) {
        x += dx;
        y += dy;
    }

    @Override
    public String toString() {
        return String.format("Diem2D(%.2f, %.2f)", x, y);
    }
}
