package org.itstep.bankomat.model;

public class NationalBankAccount extends BankAccount{
    private Integer id;
    private String fullname;

    public NationalBankAccount(String fullname, Integer balance, String accountNumber, String pinCode) {
        super(balance, accountNumber, pinCode);
        this.fullname = fullname;
    }

    public String getFullname() {
        return fullname;
    }

    @Override
    public String toString() {
        return "NationalBankAccount{" +
                "fullname='" + fullname + '\'' +
                '}';
    }
}
