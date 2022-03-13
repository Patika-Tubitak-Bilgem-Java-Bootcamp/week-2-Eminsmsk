package GameChar;

public class Samurai extends PlayerType {

    public Samurai() {
        super(1, "Samurai", 5, 21, 15);
    }

    @Override
    public void fillHealth() {
        this.setHealth(21);
    }
}
