package in.codesoft.tasks;

import java.sql.*;

import com.hospital.db.DBConnection;

public class BankAccount {

    private String accountNumber;

    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    
    public boolean authenticate(int pin) {
        String sql = "SELECT * FROM bank_account WHERE account_number = ? AND pin = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, accountNumber);
            ps.setInt(2, pin);

            ResultSet rs = ps.executeQuery();
            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public String getAccountHolderName() {
        String sql = "SELECT account_holder_name FROM bank_account WHERE account_number = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, accountNumber);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getString("account_holder_name");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public double getBalance() {
        String sql = "SELECT balance FROM bank_account WHERE account_number = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, accountNumber);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getDouble("balance");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public boolean deposit(double amount) {
        if (amount <= 0) return false;

        String sql = "UPDATE bank_account SET balance = balance + ? WHERE account_number = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDouble(1, amount);
            ps.setString(2, accountNumber);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) return false;

        double currentBalance = getBalance();
        if (amount > currentBalance) return false;

        String sql = "UPDATE bank_account SET balance = balance - ? WHERE account_number = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDouble(1, amount);
            ps.setString(2, accountNumber);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}