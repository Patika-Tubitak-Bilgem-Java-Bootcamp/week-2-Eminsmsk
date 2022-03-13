package GameChar;

public class Knight extends PlayerType {
    public Knight() {
        super(3, "Knight", 8, 24, 5);
    }

    @Override
    public void fillHealth() {
        this.setHealth(24);
    }


}
