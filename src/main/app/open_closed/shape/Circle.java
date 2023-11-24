package open_closed.shape;

public class Circle implements Shape {

    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return radius * radius * Math.PI;
    }
}
