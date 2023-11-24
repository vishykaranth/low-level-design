package small_apps.framework;

public class Main {
    public static void main(String[] args) {
//        Human h = new Human(new Walk());
//        Human h = new Human(new Dance());
//        Human h = new Human(new Run());
//        Animal a = new Dog(new Run());
        Animal a = new Human(new Dance());
        a.doMove();
    }
}