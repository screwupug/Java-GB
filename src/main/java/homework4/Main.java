package homework4;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        linesSaver();
        reverseList();
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

    /*
    Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.
     */
    public static LinkedList<Integer> generateList() {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println(list);
        return list;
    }

    public static void reverseList() {
        LinkedList<Integer> list = generateList();
        /*
        Это самый простой метод, который пришел мне в голову
        Конечно, можно было бы воспользоваться особенностью двусвязного списка -
        он хранит ссылки на предыдущий и следующий элементы. Однако для этого
        необходимо создать отдельный класс и немало методов
         */
        for (int i = 0; i < list.size(); i++) {
            list.add(i, list.pollLast());
        }
        System.out.println(list);
    }
}
