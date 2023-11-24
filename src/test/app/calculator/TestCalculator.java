package calculator;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class TestCalculator {
    @Test
    public void testAdd(){
        Calculator calculator = new SimpleCalculator();
        assertThat(calculator.add(10, 20), is(30));
    }

    @Test
    public void testDecoratorAdd10(){
        Calculator calculator = new SimpleCalculator();
        Calculator decoratorCalculatorAdd10 = new DecoratorCalculatorAdd10(calculator);
        assertThat(decoratorCalculatorAdd10.add(10, 20), is(40));
    }
}
