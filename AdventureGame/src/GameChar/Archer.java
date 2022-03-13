package GameChar;

public class Archer extends PlayerType {

    public Archer() {
        super(2, "Archer", 7, 18, 20);
    }

    @Override
    public void fillHealth() {
        this.setHealth(18);
    }


}
