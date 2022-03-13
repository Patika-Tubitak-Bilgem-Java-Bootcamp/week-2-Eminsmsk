package GameObstacle;

import GameInventory.Money;

public class Bear extends Enemy {

    public Bear() {
        super(3, "Bear", 7, 20, new Money(12));
    }

    @Override
    public Enemy createEnemy() {
        return new Bear();
    }
}
