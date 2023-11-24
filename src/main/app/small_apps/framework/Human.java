package small_apps.framework;

public class Human {
    private Move move;

    public Human(Move m){
        this.move = m;
    }

    public void doMove(){
        this.move.action();
    }
}
