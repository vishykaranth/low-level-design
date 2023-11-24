package open_closed.calculations;

public class Addition implements Operation
{
    private double firstOperand;
    private double secondOperand;
    private double result = 0.0;

    public Addition(double firstOperand, double secondOperand) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
    }

    @Override
    public void performOperation() {
        result = firstOperand + secondOperand;
    }

    @Override
    public double getResult() {
        return result;
    }
}