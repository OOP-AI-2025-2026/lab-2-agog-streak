package ua.opnu;

public class BankAccount {

    String name;
    double balance;
    double transactionFee = 0;

    // Конструктор за замовчуванням
    public BankAccount() {
        this.name = "";
        this.balance = 0;
        this.transactionFee = 0;
    }

    // Конструктор з аргументами
    public BankAccount(String name, double balance) {
        this.name = name;
        this.balance = balance >= 0 ? balance : 0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) return false;

        double totalWithdrawal = amount + transactionFee;
        if (balance >= totalWithdrawal) {
            balance -= totalWithdrawal;
            return true;
        } else {
            return false;
        }
    }

    public boolean transfer(BankAccount receiver, double amount) {
        if (receiver == null || amount <= 0) return false;

        double totalWithdrawal = amount + transactionFee;
        if (balance >= totalWithdrawal) {
            balance -= totalWithdrawal;
            receiver.deposit(amount);
            return true;
        } else {
            return false;
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setTransactionFee(double fee) {
        if (fee >= 0) transactionFee = fee;
    }
}

