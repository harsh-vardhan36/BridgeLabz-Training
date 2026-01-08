package com.petpal;

import java.util.Scanner;

public class PetPalApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Pet pet = null;

        System.out.println(" Welcome to PetPal ");

        // Adopt Pet
        System.out.println("Choose a pet: 'Using number'");
        System.out.println("1. Dog");
        System.out.println("2. Cat");
        System.out.println("3. Bird");
        int choice = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter pet name: ");
        String name = sc.nextLine();

        switch (choice) {
            case 1 -> pet = new Dog(name);
            case 2 -> pet = new Cat(name);
            case 3 -> pet = new Bird(name);
            default -> {
                System.out.println("Invalid choice!");
                System.exit(0);
            }
        }

        System.out.println("\n You adopted " + name + "!");
        pet.makeSound();

        // Menu Loop
        int option;
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Feed");
            System.out.println("2. Play");
            System.out.println("3. Sleep");
            System.out.println("4. Show Status");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            option = sc.nextInt();

            switch (option) {
                case 1 -> pet.feed();
                case 2 -> pet.play();
                case 3 -> pet.sleep();
                case 4 -> pet.showStatus();
                case 5 -> System.out.println(" Thanks for using PetPal!");
                default -> System.out.println("Invalid option!");
            }
        } while (option != 5);

        sc.close();
    }
}

