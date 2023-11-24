package calculator;

public class DecoratorCalculatorAdd10 implements Calculator {
    Calculator calculator;
    public DecoratorCalculatorAdd10(Calculator calculator){
        this.calculator = calculator;
    }
    @Override
    public int add(int a, int b) {
        int result = calculator.add(a, b) + 10;
        return result;
    }
}
