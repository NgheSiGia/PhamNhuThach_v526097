package Abstract;

public interface Shape {
    double area();
    double perimeter();
    Point getCenter();
    double distance(Shape other);

    void move(double dx, double dy);
    void rotate(double angleDegree);
    void zoom(double k);
}
