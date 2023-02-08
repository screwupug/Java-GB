package homework5;

import java.util.Scanner;

public class ConsoleHandler {
    private Scanner scanner = new Scanner(System.in);
    private PhoneList list = new PhoneList();
    private String command;
    private String input;
    public boolean isStopped = false;
    private String help = """
            _________________________________________________
            Телефонная книга
            Записывайте телефон начиная с "+"!
            Команды:
            1 - добавить контакт
            2 - удалить один из телефонов контакта
            3 - удалить контакт целиком
            4 - показать контакт
            5 - остановить программу
            6 - помощь
            _________________________________________________
            Выберете действие
            """;

    public void start() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.print(help);
        command = scanner.nextLine();
        selectOperation();
    }

    private void selectOperation() {
        switch (command) {
            case "1" -> addContact();
            case "2" -> deleteContactNumber();
            case "3" -> deleteContact();
            case "4" -> showContact();
            case "5" -> stopProgram();
            case "6" -> start();
            default -> {
            }
        }
    }

    private void addContact() {
        System.out.print("Введите номер и ФИО через запятую: ");
        input = scanner.nextLine();
        list.addContact(input);
    }

    private void deleteContactNumber() {
        System.out.print("Введите номер контакта: ");
        input = scanner.nextLine();
        list.deleteContactByNumber(input);
    }

    private void deleteContact() {
        System.out.print("Введите ФИО контакта: ");
        input = scanner.nextLine();
        list.deleteContactByName(input);
    }

    private void showContact() {
        System.out.print("Введите ФИО контакта: ");
        input = scanner.nextLine();
        list.showContact(input);
    }

    private void stopProgram() {
        isStopped = true;
        System.out.println("Остановлено успешно");
    }
}
