package com.banking.system;

import java.util.HashMap;
import java.util.Map;

public class BankSystem {
    private Map<String, Client> clients = new HashMap<>();

    // Metodo para registrar un nuevo cliente.
    public void registerClient(String name, String lastName, String dni, String email) {
        if (clients.containsKey(dni)) {
            System.out.println("Error: Ya existe un cliente con este DNI.");
            return;
        }
        Client client = new Client(name, lastName, dni, email);
        clients.put(dni, client);
        System.out.println("Cliente registrado exitosamente.");
    }

    // Metodo para abrir una nueva cuenta bancaria.
    public void openBankAccount(String dni, BankAccount.AccountType accountType) {
        Client client = clients.get(dni);
        if (client == null) {
            System.out.println("Error: Cliente no encontrado.");
            return;
        }
        String accountNumber = "ACC" + System.currentTimeMillis();
        BankAccount account = new BankAccount(accountNumber, accountType);
        client.addAccount(account);
        System.out.println("Cuenta bancaria creada exitosamente.");
    }

    // Metodo para depositar dinero en una cuenta.
    public void deposit(String dni, String accountNumber, double amount) {
        BankAccount account = getAccountByDniAndAccountNumber(dni, accountNumber);
        if (account != null) {
            account.deposit(amount);
            System.out.println("Depósito exitoso. Nuevo saldo: " + account.getBalance());
        }
    }

    // Metodo para retirar dinero de una cuenta.
    public void withdraw(String dni, String accountNumber, double amount) {
        BankAccount account = getAccountByDniAndAccountNumber(dni, accountNumber);
        if (account != null && account.withdraw(amount)) {
            System.out.println("Retiro exitoso. Nuevo saldo: " + account.getBalance());
        }
    }

    // Metodo para consultar el saldo de una cuenta.
    public void checkBalance(String dni, String accountNumber) {
        BankAccount account = getAccountByDniAndAccountNumber(dni, accountNumber);
        if (account != null) {
            System.out.println("El saldo de la cuenta " + accountNumber + " es: " + account.getBalance());
        }
    }

    // Metodo opcional para listar todos los clientes y sus cuentas.
    public void listClients() {
        for (Client client : clients.values()) {
            System.out.println(client);
            client.getAccounts().forEach(System.out::println);
        }
    }

    // Metodo auxiliar para obtener una cuenta usando dni
    private BankAccount getAccountByDniAndAccountNumber(String dni, String accountNumber) {
        Client client = clients.get(dni);
        if (client == null) {
            System.out.println("Error: Cliente no encontrado.");
            return null;
        }
        return client.getAccounts().stream()
                .filter(acc -> acc.getAccountNumber().equals(accountNumber))
                .findFirst()
                .orElse(null);
    }
}