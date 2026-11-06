package org.example;

public class ContactManager {

    private int contactCount = 0;

    private String[] phoneNumbers;
    private String[] contactsNames;

    public ContactManager(int capacity) {
        phoneNumbers = new String[capacity];
        contactsNames = new String[capacity];
    }

    public void addContact(String phoneNumber, String name) {
        if (contactCount < phoneNumbers.length) {
            phoneNumbers[contactCount] = phoneNumber;
            contactsNames[contactCount] = name;
            contactCount++;
        } else {
            System.out.println("Невозможно добавить больше контактов!");
        }
    }

    public String formatPhoneNumber(String phoneNumber) {
        String regex = "[^0-9]";
        return phoneNumber.replaceAll(regex, "");
    }

    public void viewingAllContacts() {
        for (int i = 0; i < contactCount; i++) {
            System.out.println(i + 1 + ". Имя: " + contactsNames[i] + " - " + phoneNumbers[i]);
        }
    }

    public void searchByName(String name) {
        boolean isFound = false;
        System.out.println("Имя для поиска: " + name);
        for (int i = 0; i < contactCount; i++) {
            if (contactsNames[i].equals(name)) {
                System.out.println("Имя: " + contactsNames[i] + " - " + phoneNumbers[i]);
                isFound = true;
                break;
            }
        }
        if(!isFound) {
            System.out.println("Контакт с именем " + name + " не найден");
        }
    }

    public void deleteContact(String name) {
        boolean isDeleted = false;
        System.out.println("Имя для удаления контакта: " + name);
        for (int i = 0; i < contactCount; i++) {
            if (contactsNames[i].equals(name)) {
                isDeleted = true;
                for (int j = i; j < contactCount - 1; j++) {
                    contactsNames[j] = contactsNames[j + 1];
                    phoneNumbers[j] = phoneNumbers[j + 1];
                }
                break;
            }
        }
        if (isDeleted) {
            contactCount--;
        } else {
            System.out.println("Контакт с именем " + name + " не найден");
        }
    }
}
