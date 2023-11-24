package open_closed.shape;

public class Rectangle implements Shape{

    private final double width;
    private final double breadth;

    public Rectangle(double width, double breadth){

        this.width = width;
        this.breadth = breadth;
    }
    @Override
    public double area() {
        return width * breadth;
    }
}
