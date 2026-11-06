package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ContactManager contactManager = new ContactManager(3);

        while (true) {
            System.out.println("1. Добавить контакт\n" +
                    "2. Просмотреть контакты\n" +
                    "3. Найти контакт\n" +
                    "4. Удалить контакт\n" +
                    "5. Выйти");
            int menuChoice;
            try {
                menuChoice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Некорректно введенная команда!");
                scanner.nextLine();
                continue;
            }
            scanner.nextLine();
            switch (menuChoice) {
                case 1:
                    System.out.println("Введите имя: ");
                    String name = scanner.nextLine();
                    if(name.isBlank()) {
                        System.out.println("Имя не должно быть пустым!");
                        continue;
                    }
                    System.out.println("Введите номер телефона: ");
                    String phoneNumber = scanner.nextLine();
                    if(phoneNumber.isBlank()) {
                        System.out.println("Телефон не должен быть пустым!");
                        continue;
                    }
                    phoneNumber = contactManager.formatPhoneNumber(phoneNumber);
                    if(phoneNumber.isBlank()) {
                        System.out.println("Телефон не должен быть пустым!");
                        continue;
                    }
                    contactManager.addContact(phoneNumber, name);
                    break;

                case 2:
                    contactManager.viewingAllContacts();
                    break;

                case 3:
                    System.out.println("Введите имя для поиска: ");
                    String searchName = scanner.nextLine();
                    if(searchName.isBlank()) {
                        System.out.println("Имя не должно быть пустым!");
                        continue;
                    }
                    contactManager.searchByName(searchName);
                    break;

                case 4:
                    System.out.println("Введите имя для удаления: ");
                    String nameToDelete = scanner.nextLine();
                    if(nameToDelete.isBlank()) {
                        System.out.println("Имя не должно быть пустым!");
                        continue;
                    }
                    contactManager.deleteContact(nameToDelete);
                    break;

                case 5:
                    scanner.close();
                    return;

                default:
                    System.out.println("Некорректно введенные данные, попробуйте еще раз!");
            }
        }
    }
}