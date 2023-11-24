package open_closed.calculations;

public class Multiplication implements Operation {
    private final double firstOperand;
    private final double secondOperand;
    private double result;

    public Multiplication(double firstOperand, double secondOperand) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
    }

    @Override
    public void performOperation() {
        result = firstOperand * secondOperand;
    }

    @Override
    public double getResult() {
        return result;
    }
}
