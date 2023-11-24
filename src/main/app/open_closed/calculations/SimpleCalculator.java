package open_closed.calculations;

import java.security.InvalidParameterException;

public class SimpleCalculator implements Calculator
{
    @Override
    public void calculate(Operation operation)
    {
        if(operation == null) {
            throw new InvalidParameterException("Some message");
        }

        operation.performOperation();
    }
}