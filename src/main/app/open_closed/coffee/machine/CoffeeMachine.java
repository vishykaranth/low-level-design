package open_closed.coffee.machine;

import open_closed.coffee.beans.Coffee;
import open_closed.coffee.CoffeeException;
import open_closed.coffee.CoffeeSelection;

public interface CoffeeMachine {
    Coffee brewCoffee(CoffeeSelection selection) throws CoffeeException;
}
