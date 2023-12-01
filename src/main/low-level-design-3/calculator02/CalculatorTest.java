package calculator02;

public class CalculatorTest {
    public static void main(String[] args) {
        Invoker invoker = new Invoker();
        Calculator calculator = new Calculator();
        System.out.println("Calculator Display Initially: " + calculator.getShowVal());

        CommandFactory cmdFactory = new CommandFactory(calculator);

        Command command = cmdFactory.createCommand("+", 5);
        invoker.compute(command);
        System.out.println("Calculator Display after Command: " + calculator.getShowVal());

        command = cmdFactory.createCommand("-", 2);
        invoker.compute(command);
        System.out.println("Calculator Display after Command: " + calculator.getShowVal());

        command = cmdFactory.createCommand("*", 4);
        invoker.compute(command);
        System.out.println("Calculator Display after Command: " + calculator.getShowVal());

        command = cmdFactory.createCommand("/", 3);
        invoker.compute(command);
        System.out.println("Calculator Display after Command: " + calculator.getShowVal());

        command = cmdFactory.createCommand("pow", 2);
        invoker.compute(command);
        System.out.println("Calculator Display after Command: " + calculator.getShowVal());

        invoker.undo();
        System.out.println("Calculator Display after Undo: " + calculator.getShowVal());

        invoker.undo();
        System.out.println("Calculator Display after Undo: " + calculator.getShowVal());

        invoker.undo();
        System.out.println("Calculator Display after Undo: " + calculator.getShowVal());

        invoker.undo();
        System.out.println("Calculator Display after Undo: " + calculator.getShowVal());

        invoker.undo();
        System.out.println("Calculator Display after Undo: " + calculator.getShowVal());
    }
}