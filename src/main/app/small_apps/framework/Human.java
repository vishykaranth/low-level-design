package small_apps.framework;

public class Human implements Animal{
    private Move move;

    public Human(Move m){
        this.move = m;
    }

    public void doMove(){
        System.out.print( "Human :: ");
        this.move.action();
    }
}
