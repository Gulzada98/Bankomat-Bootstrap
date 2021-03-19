package org.itstep.bankomat.model;

public abstract class BankAccount {
    private Integer balance;
    private String accountNumber;
    private String pinCode;

    public BankAccount(Integer balance, String accountNumber, String pinCode) {
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.pinCode = pinCode;
    }

    public Integer getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getPinCode() {
        return pinCode;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "balance=" + balance +
                ", accountNumber='" + accountNumber + '\'' +
                ", pinCode='" + pinCode + '\'' +
                '}';
    }
}
