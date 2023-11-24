package open_closed.calculations;


import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SimpleCalculatorTest {

    @Test
    public void testAddition(){
        Calculator calculator = new SimpleCalculator();
        Operation operation = new Addition(10, 20);
        calculator.calculate(operation);
        assertThat(operation.getResult(), is(30.0));
    }

    @Test
    public void testSubstraction(){
        Calculator calculator = new SimpleCalculator();
        Operation operation = new Substraction(30, 20);
        calculator.calculate(operation);
        assertThat(operation.getResult(), is(10.0));
    }

    //Extension
    @Test
    public void testMultiplication(){
        Calculator calculator = new SimpleCalculator();
        Operation operation = new Multiplication(30, 20);
        calculator.calculate(operation);
        assertThat(operation.getResult(), is(600.0));
    }

}