package small_apps.framework;

public class Main {
    public static void main(String[] args) {
        Human h = new Human(new Walk());
        h.doMove();
    }
}