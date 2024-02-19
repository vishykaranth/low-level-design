package com.banking;


import java.util.LinkedHashMap;

/**
 * Private Variables:<br>
 * {@link #accounts}: List&lt;Long, Account&gt;
 */
public class Bank implements BankInterface {
    private LinkedHashMap<Long, Account> accounts;

    public Bank() {
        // complete the function
        accounts = new LinkedHashMap<Long, Account>();
    }

    private Account getAccount(Long accountNumber) {
        // complete the function
        return null;
    }

    public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
        // complete the function
        return -1L;
    }

    public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
        // complete the function
        long account = System.currentTimeMillis();
        ConsumerAccount consumerAccount = new ConsumerAccount(person, account, pin, startingDeposit);
//        accounts.put(account, consumerAccount);
        return account;
    }

    public boolean authenticateUser(Long accountNumber, int pin) {
        com.banking.Account account = accounts.get(accountNumber);
        // complete the function
        return true;
    }

    public double getBalance(Long accountNumber) {
        // complete the function
        return -1;
    }

    public void credit(Long accountNumber, double amount) {
        // complete the function
    }

    public boolean debit(Long accountNumber, double amount) {
        // complete the function
        return true;
    }
}