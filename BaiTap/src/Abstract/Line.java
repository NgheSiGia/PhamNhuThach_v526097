package Abstract;

public class Line extends AbstractShape {
    private Point p1, p2;

    public Line(Point p1, Point p2) {
        if (p1 == null || p2 == null) throw new IllegalArgumentException("Điểm không được null");
        this.p1 = new Point(p1);
        this.p2 = new Point(p2);
    }
    public Line(double x1, double y1, double x2, double y2) {
        this(new Point(x1, y1), new Point(x2, y2));
    }

    public Point getP1() { return p1; }
    public Point getP2() { return p2; }
    public void setP1(Point p1) { this.p1 = new Point(p1); }
    public void setP2(Point p2) { this.p2 = new Point(p2); }

    public double length() { return p1.distance(p2); }

    @Override public double area() { return 0; }
    @Override public double perimeter() { return length(); }
    @Override public Point getCenter() {
        return new Point((p1.getX() + p2.getX()) / 2, (p1.getY() + p2.getY()) / 2);
    }

    @Override public void move(double dx, double dy) { p1.move(dx, dy); p2.move(dx, dy); }

    @Override public void rotate(double angleDegree) {
        Point c = getCenter();
        p1.rotateAround(c, angleDegree);
        p2.rotateAround(c, angleDegree);
    }

    @Override public void zoom(double k) {
        checkRatio(k);
        Point c = getCenter();
        p1.zoomAround(c, k);
        p2.zoomAround(c, k);
    }

    @Override public String toString() {
        return "Line[" + p1 + " -> " + p2 + ", length=" + String.format("%.2f", length()) + "]";
    }
}