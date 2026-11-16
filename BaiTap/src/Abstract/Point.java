package Abstract;

public class Point extends AbstractShape {
    private double x, y;

    public Point() { this(0, 0); }
    public Point(double x, double y) { this.x = x; this.y = y; }
    public Point(Point p) { this(p.x, p.y); }

    public double getX() { return x; }
    public double getY() { return y; }
    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }

    @Override public double area() { return 0; }
    @Override public double perimeter() { return 0; }
    @Override public Point getCenter() { return this; }

    @Override
    public void move(double dx, double dy) { x += dx; y += dy; }

    @Override
    public void rotate(double angleDegree) { rotateAround(new Point(0, 0), angleDegree); }

    public void rotateAround(Point c, double angleDegree) {
        double a = Math.toRadians(angleDegree);
        double dx = x - c.x, dy = y - c.y;
        x = c.x + dx * Math.cos(a) - dy * Math.sin(a);
        y = c.y + dx * Math.sin(a) + dy * Math.cos(a);
    }

    @Override
    public void zoom(double k) { zoomAround(new Point(0, 0), k); }

    public void zoomAround(Point c, double k) {
        x = c.x + (x - c.x) * k;
        y = c.y + (y - c.y) * k;
    }

    @Override
    public String toString() { return String.format("Point(%.2f, %.2f)", x, y); }
}
