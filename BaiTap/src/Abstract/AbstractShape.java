package Abstract;

public abstract class AbstractShape implements Shape {

    @Override
    public double distance(Shape other) {
        Point a = this.getCenter();
        Point b = other.getCenter();
        return Math.hypot(a.getX() - b.getX(), a.getY() - b.getY());
    }

    protected static void checkRatio(double k) {
        if (k <= 0) throw new IllegalArgumentException("Hệ số zoom phải > 0");
    }

    public int compareByArea(Shape other) {
        return Double.compare(this.area(), other.area());
    }
}
