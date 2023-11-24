package open_closed.calculations;

public class CalculationApp {
    public static void main(String[] args) {
        Calculator calculator = new SimpleCalculator();
        Operation operation = new Addition(10, 20);
        calculator.calculate(operation);
        System.out.println(operation.getResult());
    }
}
