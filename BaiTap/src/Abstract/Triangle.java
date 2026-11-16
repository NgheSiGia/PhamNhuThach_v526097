package Abstract;

public class Triangle extends AbstractShape {
    private Point a, b, c;

    public Triangle(Point a, Point b, Point c) {
        if (!isValid(a, b, c)) throw new IllegalArgumentException("Ba điểm thẳng hàng, không tạo thành tam giác");
        this.a = new Point(a);
        this.b = new Point(b);
        this.c = new Point(c);
    }

    private static boolean isValid(Point a, Point b, Point c) {
        double cross = (b.getX() - a.getX()) * (c.getY() - a.getY())
                - (b.getY() - a.getY()) * (c.getX() - a.getX());
        return Math.abs(cross) > 1e-9;
    }

    public Point getA() { return a; }
    public Point getB() { return b; }
    public Point getC() { return c; }
    public void setPoints(Point a, Point b, Point c) {
        if (!isValid(a, b, c)) throw new IllegalArgumentException("Ba điểm thẳng hàng");
        this.a = new Point(a); this.b = new Point(b); this.c = new Point(c);
    }

    @Override public double area() {
        return Math.abs((b.getX() - a.getX()) * (c.getY() - a.getY())
                - (b.getY() - a.getY()) * (c.getX() - a.getX())) / 2;
    }
    @Override public double perimeter() { return a.distance(b) + b.distance(c) + c.distance(a); }

    /** Tâm = trọng tâm. */
    @Override public Point getCenter() {
        return new Point((a.getX() + b.getX() + c.getX()) / 3, (a.getY() + b.getY() + c.getY()) / 3);
    }

    @Override public void move(double dx, double dy) { a.move(dx, dy); b.move(dx, dy); c.move(dx, dy); }

    @Override public void rotate(double angleDegree) {
        Point g = getCenter();
        a.rotateAround(g, angleDegree);
        b.rotateAround(g, angleDegree);
        c.rotateAround(g, angleDegree);
    }

    @Override public void zoom(double k) {
        checkRatio(k);
        Point g = getCenter();
        a.zoomAround(g, k);
        b.zoomAround(g, k);
        c.zoomAround(g, k);
    }

    @Override public String toString() { return "Triangle[" + a + ", " + b + ", " + c + "]"; }
}