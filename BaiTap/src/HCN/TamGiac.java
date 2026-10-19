package HCN;

public class TamGiac {
    Diem A, B, C;

    public TamGiac(Diem A, Diem B, Diem C) {
        this.A = A;
        this.B = B;
        this.C = C;
    }

    public double canh(Diem A, Diem B) {
        double dx = A.x - B.x;
        double dy = A.y - B.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public double chuVi() {
        return canh(A, B) + canh(B, C) + canh(C, A);
    }

    public double dienTich() {
        double a = canh(B, C);
        double b = canh(A, C);
        double c = canh(A, B);

        double p = chuVi() / 2;

        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
