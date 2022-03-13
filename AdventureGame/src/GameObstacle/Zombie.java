package GameObstacle;

import GameInventory.Money;

public class Zombie extends Enemy {

    public Zombie() {
        super(1, "Zombie", 3, 10, new Money(4));
    }

    @Override
    public Enemy createEnemy() {
        return new Zombie();
    }

}
