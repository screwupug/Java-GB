package homework5;

import java.util.*;

public class Task2Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList(
                "Иван Иванов", "Светлана Петрова", "Кристина Белова",
                "Анна Мусина", "Анна Крутова", "Иван Юрин",
                "Петр Лыков", "Павел Чернов", "Петр Чернышов",
                "Мария Федорова", "Марина Светлова", "Мария Савина",
                "Мария Рыкова", "Марина Лугова", "Анна Владимирова",
                "Иван Мечников", "Петр Петин", "Иван Ежов"
        ));
        sortArray(list);
    }

    public static void sortArray(List<String> list) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String item : list) {
            String[] buffer = item.split(" ");
            map.put(buffer[0], map.getOrDefault(buffer[0], 0) + 1);
        }
        map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(System.out::println);
    }
}
