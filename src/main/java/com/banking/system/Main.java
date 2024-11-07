package com.banking.system;

import java.util.Scanner;

// Clase main para gestionar la interfaz de usuario.
public class Main {
    // Metodo principal que ejecuta el sistema bancario.
    public static void main(String[] args) {
        BankSystem bankSystem = new BankSystem();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        // Bucle principal del menu.
        while (!exit) {
            System.out.println("\n--- Menú del Sistema Bancario ---");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Abrir cuenta bancaria");
            System.out.println("3. Depositar dinero");
            System.out.println("4. Retirar dinero");
            System.out.println("5. Consultar saldo");
            System.out.println("6. Listar clientes y cuentas");
            System.out.println("7. Salir");
            System.out.print("Selecciona una opción: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            // Procesa la opcion seleccionada por el usuario.
            switch (choice) {
                case 1:
                    // Registro de nuevo cliente.
                    System.out.print("Nombre: ");
                    String name = scanner.nextLine();
                    System.out.print("Apellido: ");
                    String lastName = scanner.nextLine();
                    System.out.print("DNI: ");
                    String dni = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    bankSystem.registerClient(name, lastName, dni, email);
                    break;
                case 2:
                    // Apertura de nueva cuenta bancaria.
                    System.out.print("DNI del cliente: ");
                    dni = scanner.nextLine();
                    System.out.print("Tipo de cuenta (1. AHORROS, 2. CORRIENTE): ");
                    int typeChoice = scanner.nextInt();
                    BankAccount.AccountType accountType = (typeChoice == 1) ? BankAccount.AccountType.AHORROS : BankAccount.AccountType.CORRIENTE;
                    bankSystem.openBankAccount(dni, accountType);
                    break;
                case 3:
                    // Deposito en cuenta bancaria.
                    System.out.print("DNI del cliente: ");
                    dni = scanner.nextLine();
                    System.out.print("Número de cuenta: ");
                    String accountNumber = scanner.nextLine();
                    System.out.print("Monto a depositar: ");
                    double depositAmount = scanner.nextDouble();
                    bankSystem.deposit(dni, accountNumber, depositAmount);
                    break;
                case 4:
                    // Retiro de cuenta bancaria.
                    System.out.print("DNI del cliente: ");
                    dni = scanner.nextLine();
                    System.out.print("Número de cuenta: ");
                    accountNumber = scanner.nextLine();
                    System.out.print("Monto a retirar: ");
                    double withdrawAmount = scanner.nextDouble();
                    bankSystem.withdraw(dni, accountNumber, withdrawAmount);
                    break;
                case 5:
                    //Consulta de saldo.
                    System.out.print("DNI del cliente: ");
                    dni = scanner.nextLine();
                    System.out.print("Número de cuenta: ");
                    accountNumber = scanner.nextLine();
                    bankSystem.checkBalance(dni, accountNumber);
                    break;
                case 6:
                    // Listado de clientes y cuentas.
                    bankSystem.listClients();
                    break;
                case 7:
                    // Salir del sistema bancario.
                    System.out.println("Saliendo del sistema bancario.");
                    exit = true;
                    break;
                default:
                    // Mensaje de opcion no valida.
                    System.out.println("Opción no válida.");
            }
        }
        scanner.close();
    }
}