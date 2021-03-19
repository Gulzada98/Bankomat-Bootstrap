package org.itstep.bankomat.model;

public class CityBankAccount extends BankAccount {
    private Long id;
    private String name;
    private String surmane;

    public CityBankAccount(String name, String surmane, Integer balance, String accountNumber, String pinCode) {
        super(balance, accountNumber, pinCode);
        this.name = name;
        this.surmane = surmane;
    }

    public String getName() {
        return name;
    }

    public String getSurmane() {
        return surmane;
    }

    @Override
    public String toString() {
        return "CityBankAccount{" +
                "name='" + name + '\'' +
                ", surmane='" + surmane + '\'' +
                ", " + super.toString() +
                '}';
    }
}
