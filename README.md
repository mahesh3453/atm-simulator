# 🏦 ATM Simulator (JDBC + Oracle)

## 📌 Description
This is a Console-based ATM Simulator built using Java and JDBC.
The project connects to an Oracle Database and performs:

- PIN Authentication
- Deposit Money
- Withdraw Money
- Check Balance
- Database Persistence

## 🛠 Technologies Used
- Java
- JDBC
- Oracle Database
- PreparedStatement
- Exception Handling

## 🗄 Database Table Structure

```sql
CREATE TABLE bank_account (
    account_number VARCHAR2(20) PRIMARY KEY,
    account_holder_name VARCHAR2(100) NOT NULL,
    pin NUMBER(4) NOT NULL,
    balance NUMBER(12,2) NOT NULL
);
