package open_closed.shape;

public class AreaApp {

    public static void main(String[] args) {
        Shape[] shapes = {new Circle(10), new Rectangle(10, 20)};
        System.out.println(area(shapes));
    }


    public static double area(Shape[] shapes) {
        double area = 0;
        for (Shape shape : shapes) {
            area += shape.area();
        }

        return area;
    }
}
