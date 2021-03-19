package org.itstep.bankomat.dao;

import org.itstep.bankomat.model.CityBankAccount;
import org.itstep.bankomat.model.NationalBankAccount;

import java.sql.*;

public class DbManager {

    private static Connection connection;

    private static final String URL = "jdbc:sqlite:C:/Users/Sten/Desktop/STEP/Java/HW/HW_Bankomat_Bootstrap/identifier.sqlite";

    private static final String GET_CBA_BY_ACCOUNT_NUMBER = "SELECT * FROM cityBankAccount where accountnumber = ?";
    private static final String GET_NBA_BY_ACCOUNT_NUMBER = "SELECT * FROM nationalBankAccount where accountnumber = ?";

    static {
        try {
            Class.forName("org.sqlite.JDBC"); // определяем драйвер
            connection = DriverManager.getConnection(URL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static CityBankAccount getCBAByAccountNumber(String accountNumber) throws SQLException {
        CityBankAccount cityBankAccount = null;

        PreparedStatement statement = connection.prepareStatement(GET_CBA_BY_ACCOUNT_NUMBER);
        statement.setString(1, accountNumber);
        ResultSet set = statement.executeQuery();

        if (set.next()) {
            cityBankAccount = new CityBankAccount(
                    set.getString(2),
                    set.getString(3),
                    set.getInt(4),
                    set.getString(5),
                    set.getString(6)
            );
        }

        set.close();
        statement.close();

        return cityBankAccount;
    }

    public static NationalBankAccount getNBAByAccountNumber(String accountNumber) throws SQLException {
        NationalBankAccount nationalBankAccount = null;

        PreparedStatement statement = connection.prepareStatement(GET_NBA_BY_ACCOUNT_NUMBER);
        statement.setString(1, accountNumber);
        ResultSet set = statement.executeQuery();

        if (set.next()) {
            nationalBankAccount = new NationalBankAccount(
                    set.getString(2),
                    set.getInt(3),
                    set.getString(4),
                    set.getString(5)
            );
        }

        set.close();
        statement.close();

        return nationalBankAccount;
    }
}
