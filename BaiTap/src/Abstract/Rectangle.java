package Abstract;

public class Rectangle extends AbstractShape {
    private final Point[] v = new Point[4];

    public Rectangle(Point topLeft, double width, double height) {
        if (width <= 0 || height <= 0) throw new IllegalArgumentException("Chiều rộng/cao phải > 0");
        double x = topLeft.getX(), y = topLeft.getY();
        v[0] = new Point(x, y);
        v[1] = new Point(x + width, y);
        v[2] = new Point(x + width, y + height);
        v[3] = new Point(x, y + height);
    }
    public Rectangle(double x, double y, double width, double height) {
        this(new Point(x, y), width, height);
    }

    public Point[] getVertices() { return v; }
    public double getWidth()  { return v[0].distance(v[1]); }
    public double getHeight() { return v[1].distance(v[2]); }

    public void setSize(double width, double height) {
        if (width <= 0 || height <= 0) throw new IllegalArgumentException("Chiều rộng/cao phải > 0");
        zoomAxes(width / getWidth(), height / getHeight());
    }

    private void zoomAxes(double kw, double kh) {
        Point c = getCenter();
        // vector đơn vị theo cạnh AB và BC
        double wx = (v[1].getX() - v[0].getX()) / getWidth();
        double wy = (v[1].getY() - v[0].getY()) / getWidth();
        double hx = (v[2].getX() - v[1].getX()) / getHeight();
        double hy = (v[2].getY() - v[1].getY()) / getHeight();
        double w = getWidth() * kw / 2, h = getHeight() * kh / 2;
        double cx = c.getX(), cy = c.getY();
        v[0] = new Point(cx - wx * w - hx * h, cy - wy * w - hy * h);
        v[1] = new Point(cx + wx * w - hx * h, cy + wy * w - hy * h);
        v[2] = new Point(cx + wx * w + hx * h, cy + wy * w + hy * h);
        v[3] = new Point(cx - wx * w + hx * h, cy - wy * w + hy * h);
    }

    @Override public double area() { return getWidth() * getHeight(); }
    @Override public double perimeter() { return 2 * (getWidth() + getHeight()); }

    @Override public Point getCenter() {
        return new Point((v[0].getX() + v[2].getX()) / 2, (v[0].getY() + v[2].getY()) / 2);
    }

    @Override public void move(double dx, double dy) { for (Point p : v) p.move(dx, dy); }

    @Override public void rotate(double angleDegree) {
        Point c = getCenter();
        for (Point p : v) p.rotateAround(c, angleDegree);
    }

    @Override public void zoom(double k) {
        checkRatio(k);
        Point c = getCenter();
        for (Point p : v) p.zoomAround(c, k);
    }

    @Override public String toString() {
        return String.format("Rectangle[w=%.2f, h=%.2f, A=%s, B=%s, C=%s, D=%s]",
                getWidth(), getHeight(), v[0], v[1], v[2], v[3]);
    }
}
