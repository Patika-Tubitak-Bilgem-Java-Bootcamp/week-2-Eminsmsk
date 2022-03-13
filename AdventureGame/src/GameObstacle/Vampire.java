package GameObstacle;

import GameInventory.Money;

public class Vampire extends Enemy {

    public Vampire() {
        super(2, "Vampire", 4, 14, new Money(7));
    }

    @Override
    public Enemy createEnemy() {
        return new Vampire();
    }

}
