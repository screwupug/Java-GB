package homework5;


public class Task1Main {
    public static void main(String[] args) {
        ConsoleHandler handler = new ConsoleHandler();
        while (!handler.isStopped) {
            handler.start();
        }

    }
}
