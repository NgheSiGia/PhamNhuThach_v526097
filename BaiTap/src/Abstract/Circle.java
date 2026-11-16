package Abstract;

public class Circle extends AbstractShape {
    private Point center;
    private double radius;

    public Circle(Point center, double radius) {
        if (radius <= 0) throw new IllegalArgumentException("Bán kính phải > 0");
        this.center = new Point(center);
        this.radius = radius;
    }
    public Circle(double x, double y, double radius) { this(new Point(x, y), radius); }

    public Point getCenterPoint() { return center; }
    public double getRadius() { return radius; }
    public void setCenter(Point center) { this.center = new Point(center); }
    public void setRadius(double radius) {
        if (radius <= 0) throw new IllegalArgumentException("Bán kính phải > 0");
        this.radius = radius;
    }

    @Override public double area() { return Math.PI * radius * radius; }
    @Override public double perimeter() { return 2 * Math.PI * radius; }
    @Override public Point getCenter() { return center; }

    @Override public void move(double dx, double dy) { center.move(dx, dy); }

    @Override public void rotate(double angleDegree) { /* bất biến */ }

    @Override public void zoom(double k) {
        checkRatio(k);
        radius *= k;
    }

    @Override public String toString() {
        return String.format("Circle[center=%s, r=%.2f]", center, radius);
    }
}
