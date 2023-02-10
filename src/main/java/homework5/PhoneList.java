package sem1.homework5;

import java.util.HashMap;
import java.util.Map;

public class PhoneList {
    private HashMap<String, String> phoneList = new HashMap<>();
    private String[] contactToAdd;

    private boolean checkLine(String line) {
        try {
            String[] array = line.split(", ");
            if (array.length < 2) {
                throw new Exception();
            }
            if (!(array[0].matches("^\\+\\d*$"))) {
                throw new Exception();
            }
            contactToAdd = array;
            return true;
        } catch (Exception e) {
            System.out.println("Ошибка ввода! Попробуйте еще раз\n");
        }
        return false;
    }

    public void addContact(String line) {
        if (checkLine(line)) {
            phoneList.put(contactToAdd[0], contactToAdd[1]);
            System.out.println("Контакт успешно добавлен\n");
        }
    }

    public void showContact(String line) {
        if (!phoneList.isEmpty()) {
            for (Map.Entry<String, String> item : phoneList.entrySet()) {
                if (item.getValue().equals(line)) {
                    System.out.printf("ФИО - %s, номер - %s\n", item.getValue(), item.getKey());
                } else {
                    System.out.println("Такого контакта в книге нет\n");
                }
            }
        } else {
            System.out.println("Телефонная книга пуста!\n");
        }
    }

    public void deleteContactByName(String line) {
        if (!phoneList.isEmpty()) {
            for (int i = 0; i < phoneList.size(); i++) {
                phoneList.entrySet().removeIf(entry -> entry.getValue().contains(line));
            }
            System.out.println("Контакт успешно удален\n");
        } else {
            System.out.println("Телефонная книга пуста!\n");
        }
    }

    public void deleteContactByNumber(String line) {
        if (!phoneList.isEmpty()) {
            phoneList.entrySet().removeIf(entry -> entry.getKey().contains(line));
            System.out.println("Контакт успешно удален\n");
        } else {
            System.out.println("Телефонная книга пуста!\n");
        }
    }

    public void showMap() {
        System.out.println(phoneList);
    }
}
