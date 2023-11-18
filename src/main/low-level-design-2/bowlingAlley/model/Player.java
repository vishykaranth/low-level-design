package bowlingAlley.model;

/**
 *
 * @created 23/05/2021
 */
public class Player {
    private final String playerId;
    private final String name;

    public Player(String playerId, String name) {
        this.playerId = playerId;
        this.name = name;
    }

    @Override
    public String toString() {
        return "bowling.Player{" +
                "playerId='" + playerId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getPlayerId() {
        return playerId;
    }

    public String getName() {
        return name;
    }
}
