package ledger.command;


import ledger.balance.BalanceManager;
import ledger.loan.LoanManager;
import ledger.payment.PaymentManager;

public class CommandFactory {

    public CommandExecution getInstance(String command, String[] inputSplit) {
        CommandExecution commandExecution;
        switch (command) {
            case "LOAN":
                commandExecution = new LoanManager(inputSplit);
                break;
            case "PAYMENT":
                commandExecution = new PaymentManager(inputSplit);
                break;
            case "BALANCE":
                commandExecution = new BalanceManager(inputSplit);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + command);
        }
        return commandExecution;
    }
}
