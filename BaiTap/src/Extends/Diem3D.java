package Extends;

class Diem3D extends Diem2D {
    private double z; // private: chỉ dùng trong lớp này, truy cập qua getter

    public Diem3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    public double getZ() { return z; }

    // Ghi đè: khoảng cách 3D (nếu p là 2D thì coi z = 0)
    @Override
    public double khoangCach(Diem2D p) {
        double pz = (p instanceof Diem3D) ? ((Diem3D) p).z : 0;
        double dx = x - p.x;
        double dy = y - p.y;
        double dz = z - pz;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    // Định nghĩa lại hàm đối xứng (kiểu trả về hiệp biến: Diem3D)
    @Override
    public Diem3D doiXung() {
        return new Diem3D(-x, -y, -z);
    }

    // Tịnh tiến 3 chiều (overload), tái sử dụng hàm của lớp cha
    public void tinhTien(double dx, double dy, double dz) {
        super.tinhTien(dx, dy);
        z += dz;
    }

    @Override
    public String toString() {
        return String.format("Diem3D(%.2f, %.2f, %.2f)", x, y, z);
    }
}
