package homework6;

public class Admin {
    private String login;
    private String password;
    private DataBase base;

    public Admin(String login, String password, DataBase base) {
        this.login = login;
        this.password = password;
        this.base = base;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void addGood(NoteBook noteBook){
        base.addToBase(noteBook);
    }

    public boolean deleteGood(long uniqueNumber) {
       return base.deleteFromBase(uniqueNumber);
    }

    public void showAllGoods() {
        base.showBaseForAdmin();
    }
}
