package homework6;

import java.util.ArrayList;
import java.util.List;

// Класс для обработки команд админа
public class AdminHandlers {
    Admin admin;
    List<Admin> adminList = new ArrayList<>();

    public boolean createNewAdmin(String loginPassword, DataBase base) {
        if (adminList.size() < 1) {
            String[] data = loginPassword.split(", ");
            if (data.length == 2) {
                admin = new Admin(data[0], data[1], base);
                adminList.add(admin);
                return true;
            } else {
                System.out.println("Ошибка ввода");
            }
        }
        return false;
    }

    // Проверка логина и пароля
    public boolean checkAdmin(String line) {
        String[] loginPassword = line.split(", ");
        if (loginPassword.length == 2) {
            return adminList.get(0).getLogin().equals(loginPassword[0]) &&
                    adminList.get(0).getPassword().equals(loginPassword[1]);
        }
        return false;
    }

    public boolean addNoteBook(String line) {
        String[] specs = line.split(", ");
        if (specs.length == 10) {
            admin.addGood(new NoteBook
                    (
                            specs[0], specs[1],
                            specs[2], specs[3],
                            Integer.parseInt(specs[4]),  Integer.parseInt(specs[5]),
                            Double.parseDouble(specs[6]), Integer.parseInt(specs[7]),
                            Integer.parseInt(specs[8]), Long.parseLong(specs[9]))
            );
            return true;
        }
        return false;
    }

    public boolean deleteNoteBook(String line) {
        try {
            long uniqueNumber = Long.parseLong(line);
            return admin.deleteGood(uniqueNumber);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return false;
        }
    }
}
