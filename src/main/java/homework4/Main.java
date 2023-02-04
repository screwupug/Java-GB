package homework4;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        linesSaver();
    }

    /*
    Реализовать консольное приложение, которое:
    Принимает от пользователя и “запоминает” строки.
    Если введено print, выводит строки так, чтобы последняя введенная была первой в списке, а первая - последней.
    Если введено revert, удаляет предыдущую введенную строку из памяти.
     */
    public static void linesSaver() {
        String help = """
                Консольный список.
                Команды:
                print - вывод строк в обратном порядке
                revert - удаление последней введенной строки
                help - список команд
                stop - завершение программы
                """;
        System.out.println(help);
        List<String> list = new ArrayList<>();
        boolean isStopped = false;
        while (!isStopped) {
            System.out.print("Введите строку для добавления: ");
            String line = new Scanner(System.in).nextLine();
            switch (line.toLowerCase()) {
                case "print":
                    if (list.isEmpty()) {
                        System.out.println("Список пуст!\n");
                    } else {
                        System.out.println("---------------------------------------------");
                        for (int i = list.size() - 1; i >= 0; i--) {
                            System.out.printf("%d - %s\n", i, list.get(i));
                        }
                        System.out.println("---------------------------------------------\n");
                    }
                    break;
                case "revert":
                    if (list.isEmpty()) {
                        System.out.println("Список пуст!\n");
                    } else {
                        list.remove(list.size() - 1);
                        System.out.println("Предыдущая строка удалена\n");
                    }
                    break;
                case "stop":
                    isStopped = true;
                    break;
                case "help":
                    System.out.println("\n" + help);
                    break;
                default:
                    list.add(line);
                    System.out.println("Строка добавлена\n");
                    break;
            }
        }
    }
}
