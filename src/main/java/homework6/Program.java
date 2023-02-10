package homework6;

import java.util.Scanner;

// Основной класс интерфейса
public class Program {
    DataBase base = new DataBase();
    AdminHandlers adminHandlers = new AdminHandlers();
    UserHandlers userHandlers = new UserHandlers(base);
    Scanner scanner = new Scanner(System.in);
    String answer;

    // старт программы
    public void start() {
        System.out.println(Strings.MAIN_MENU);
        answer = scanner.nextLine();
        switch (answer) {
            case "1":
                if (adminHandlers.adminList.isEmpty()) {
                    tryToCreateAdmin();
                } else {
                    tryToLogIn();
                }
                break;
            case "2":
                userMenu();
                break;
            case "3":
                break;
            default:
                start();

        }
    }

    // вход в админку
    private void tryToLogIn() {
        System.out.print(Strings.LOG_IN);
        answer = scanner.nextLine();
        if (adminHandlers.checkAdmin(answer)) {
            System.out.println(Strings.LOGGED_IN_SUCCESSFULLY);
            System.out.println();
            adminMenu();
        } else {
            System.out.println(Strings.LOGGED_IN_UNSUCCESSFULLY);
            System.out.println();
            start();
        }
    }

    // создание нового объекта класса админ (админ может быть только один)
    private void tryToCreateAdmin() {
        System.out.println(Strings.THERE_IS_NO_ADMIN);
        answer = scanner.nextLine();
        switch (answer) {
            case "1":
                System.out.print(Strings.CREATE_NEW_ADMIN);
                answer = scanner.nextLine();
                if (adminHandlers.createNewAdmin(answer, base)) {
                    System.out.println(Strings.ADMIN_CREATION_SUCCESS);
                    System.out.println();
                    adminMenu();
                } else {
                    start();
                }
                break;
            case "2":
                start();
                break;
            default:
                tryToCreateAdmin();
        }
    }

    // обработчик меню админа
    private void adminMenu() {
        System.out.println(Strings.MAIN_ADMIN_MENU);
        answer = scanner.nextLine();
        switch (answer) {
            case "1":
                addNoteBook();
                break;
            case "2":
                deleteNotebook();
                break;
            case "3":
                adminHandlers.admin.showAllGoods();
                adminMenu();
                break;
            case "4":
                start();
                break;
            case "5":
                break;
            default:
                adminMenu();
        }
    }

    private void addNoteBook() {
        System.out.println(Strings.ADD_NOTEBOOK);
        answer = scanner.nextLine();
        if (adminHandlers.addNoteBook(answer)) {
            System.out.println(Strings.SUCCESSFULLY_ADDED);
            adminMenu();
        } else {
            System.out.println(Strings.UNSUCCESSFULLY_ADDED);
            adminMenu();
        }
    }

    private void deleteNotebook() {
        System.out.print(Strings.DELETE_NOTEBOOK);
        answer = scanner.nextLine();
        if (adminHandlers.deleteNoteBook(answer)) {
            System.out.println(Strings.SUCCESSFULLY_DELETED);
            adminMenu();
        } else {
            System.out.println(Strings.UNSUCCESSFULLY_DELETED);
            adminMenu();
        }
    }

    // обработчик меню пользователя
    private void userMenu() {
        System.out.println(Strings.MAIN_USER_MENU);
        answer = scanner.nextLine();
        switch (answer) {
            case "1":
                userHandlers.showAllGoods();
                userMenu();
                break;
            case "2":
                colorChoice();
                userMenu();
                break;
            case "3":
                cpuChoice();
                userMenu();
                break;
            case "4":
                ramChoice();
                userMenu();
                break;
            case "5":
                hddChoice();
                userMenu();
                break;
            case "6":
                diagonalChoice();
                userMenu();
                break;
            case "7":
                priceChoice();
                userMenu();
                break;
            case "8":
                brandChoice();
                userMenu();
                break;
            case "9":
                modelChoice();
                userMenu();
                break;
            case "10":
                start();
                break;
            case "11":
                break;
            default:
                userMenu();
        }
    }

    private void modelChoice() {
        System.out.print(Strings.SEARCH_BY_MODEL);
        answer = scanner.nextLine();
        userHandlers.searchByModel(answer);
    }

    private void brandChoice() {
        System.out.print(Strings.SEARCH_BY_BRAND);
        answer = scanner.nextLine();
        userHandlers.searchByBrand(answer);
    }

    private void priceChoice() {
        System.out.print(Strings.SEARCH_BY_PRICE);
        answer = scanner.nextLine();
        userHandlers.searchByPrice(answer);
    }

    private void diagonalChoice() {
        System.out.print(Strings.SEARCH_BY_DIAGONAL);
        answer = scanner.nextLine();
        userHandlers.searchByDiagonal(answer);
    }

    private void hddChoice() {
        System.out.print(Strings.SEARCH_BY_HDD);
        answer = scanner.nextLine();
        userHandlers.searchByHddCapacity(answer);
    }

    private void ramChoice() {
        System.out.print(Strings.SEARCH_BY_RAM);
        answer = scanner.nextLine();
        userHandlers.searchByRamCapacity(answer);
    }

    private void cpuChoice() {
        System.out.print(Strings.SEARCH_BY_CPU);
        answer = scanner.nextLine();
        userHandlers.searchByCPU(answer);
    }

    private void colorChoice() {
        System.out.print(Strings.SEARCH_BY_COLOR);
        answer = scanner.nextLine();
        userHandlers.searchByColor(answer);
    }

}
