package com.banking.system;

import java.util.ArrayList;
import java.util.List;

// Clase principal que representa a un cliente del sistema bancario.
public class Client {
    // Atributos encapsulados de la clase Client.
    private String name;
    private String lastName;
    private final String dni;
    private final String email;
    private List<BankAccount> accounts;

    // Constructor para crear un cliente con los atributos proporcionados.
    public Client(String name, String lastName, String dni, String email) {
        if (name.isEmpty() || lastName.isEmpty()) throw new IllegalArgumentException("Nombre y apellido no pueden estar vacíos.");
        if (!dni.matches("\\d{8}")) throw new IllegalArgumentException("DNI debe tener 8 dígitos.");
        if (!email.contains("@")) throw new IllegalArgumentException("Email debe ser válido.");

        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
        this.email = email;
        this.accounts = new ArrayList<>();
    }

    // Metodo para agregar una cuenta bancaria al cliente.
    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }

    // Metodos para obtener y establecer el nombre del cliente.
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Metodos para obtener y establecer el apellido del cliente.
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Metodos para obtener  el dni del cliente.
    public String getDni() {
        return dni;
    }

    // Metodos para obtener  el email del cliente.
    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Cliente {nombre=" + name + " " + lastName + ", DNI=" + dni + ", email=" + email + '}';
    }
}