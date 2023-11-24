package small_apps.framework;

public class Dog implements Animal{
    private Move move;

    public Dog(Move move) {
        this.move = move;
    }

    public void doMove(){
        System.out.print( "Dog :: ");
        this.move.action();
    }
}
