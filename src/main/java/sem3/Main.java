package sem3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        fillAndPrintList();
    }

    public static void fillAndPrintList() {
        String[] planets = new String[]{
                "Меркурий", "Венера", "Земля",
                "Марс", "Юпитер", "Сатурн",
                "Уран", "Нептун"
        };
        Random rnd = new Random();
        ArrayList<String> list = new ArrayList<>();
        int listSize = rnd.nextInt(10, 26);
        for (int i = 0; i < listSize; i++) {
            list.add(planets[rnd.nextInt(planets.length)]);
        }

        Collections.sort(list);
        for (String item : list) {
            System.out.println(item);
        }

        HashMap<String, Integer> itemCount = new HashMap<>();
        for (String element : list) {
            itemCount.put(element, itemCount.getOrDefault(element, 0) + 1);
        }
        System.out.println(itemCount);


    }

}
