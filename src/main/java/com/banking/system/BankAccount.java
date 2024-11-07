package com.banking.system;

// Clase principal que representa una cuenta bancaria.
public class BankAccount {
    // Atributos encapsulados de la clase BankAccount.
    private final String accountNumber;
    private double balance;
    private final AccountType accountType;

    // Metodo para definir los tipos de cuenta
    public enum AccountType {
        AHORROS, CORRIENTE
    }

    // Constructor para crear una cuenta bancaria con los atributos proporcionados.
    public BankAccount(String accountNumber, AccountType accountType) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.accountType = accountType;
    }

    // Metodos para obtener el numero de cuenta.
    public String getAccountNumber() {
        return accountNumber;
    }

    // Metodos para obtener  el saldo de la cuenta.
    public double getBalance() {
        return balance;
    }

    // Metodos para obtener el tipo de cuenta.
    public AccountType getAccountType() {
        return accountType;
    }

    // Metodo para retirar dinero de la cuenta.
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Error: El monto debe ser positivo.");
            return false;
        }

        if (accountType == AccountType.AHORROS && balance - amount < 0) {
            System.out.println("Error: Tu operación no pudo ser procesada ya que no se puede contar con saldo negativo en cuentas de ahorro.");
            return false;
        } else if (accountType == AccountType.CORRIENTE && balance - amount < -500) {
            System.out.println("Error: Tu operación no pudo ser procesada ya que supera el límite de sobregiro de -500 en cuentas corrientes");
            return false;
        }
        balance -= amount;
        return true;
    }

    // Metodo para depositar dinero en la cuenta
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Error: El monto a depositar debe ser positivo.");
        }
    }

    // Metodos que devuelve una representacion en cadena de la cuenta bancaria.
    @Override
    public String toString() {
        return "CuentaBancaria {numeroCuenta='" + accountNumber + "', saldo=" + balance + ", tipoCuenta=" + accountType + '}';
    }
}