package homework6;

import java.util.ArrayList;
import java.util.List;

public class DataBase {

    List<NoteBook> noteBooks = new ArrayList<>() {{
        add(new NoteBook("UX310u", "Asus", "серый", "Intel",
                13, 8, 1.2, 128, 40000, 1));
        add(new NoteBook("Pro 15", "Redmi", "металлик", "Ryzen",
                15, 16, 1.8, 512, 70000, 2));
        add(new NoteBook("Yoga 7 Pro", "Lenovo", "черный", "Intel",
                12, 12, 1.4, 256, 55000, 3));
        add(new NoteBook("Vaio", "Sony", "красный", "Intel",
                15.6, 4, 1.1, 320, 18990, 4));
        add(new NoteBook("MacBook Air M1 2020", "Apple", "золотой", "M1",
                13.3, 8, 1.29, 256, 71990, 5));
        add(new NoteBook("Surface Laptop 4", "Microsoft", "голубой", "Intel",
                15, 32, 1, 1024, 129000, 6));
        add(new NoteBook("Spectre x360", "HP", "голубой алюминий", "Intel",
                16, 16, 2, 1024, 122490, 7));
        add(new NoteBook("XPS 13 Plus", "Dell", "платина", "Intel",
                13.4, 8, 1.23, 512, 93990, 8));
        add(new NoteBook("Swift 3", "Acer", "серый", "Intel",
                13.5, 8, 1.25, 256, 57990, 9));
        add(new NoteBook("MacBook Pro 16", "Apple", "серый", "M2 Pro",
                16, 16, 1.3, 512, 179990, 10));
        add(new NoteBook("Zephyrus G14", "Rogue", "черный", "Ryzen",
                14, 16, 1.6, 1024, 144990, 11));
        add(new NoteBook("ThinkPad X1", "Lenovo", "карбон", "Intel",
                14, 16, 1.3, 512, 88990, 12));
    }};

    public void addToBase(NoteBook noteBook) {
        noteBooks.add(noteBook);
    }

    public boolean deleteFromBase(long uniqueNumber) {
        for (int i = 0; i < noteBooks.size(); i++) {
            if(noteBooks.get(i).getUniqueNumber() == uniqueNumber) {
                noteBooks.remove(noteBooks.get(i));
                return true;
            }
        }
        return false;
    }

    public void showBaseForUser() {
        for (NoteBook noteBook : noteBooks) {
            noteBook.printAllSpecsForUser();
        }
    }

    public void showBaseForAdmin() {
        for (NoteBook noteBook : noteBooks) {
            noteBook.printAllSpecsForAdmin();
        }
    }
}
