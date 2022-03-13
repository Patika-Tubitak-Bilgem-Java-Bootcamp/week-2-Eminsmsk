package GameObstacle;

import GameInventory.Armor;
import GameInventory.Money;
import GameInventory.Reward;
import GameInventory.Weapon;

public class Snake extends Enemy {

    public Snake() {
        super(4, "Snake", (int) (Math.random() * 4) + 3, 12, null);
        this.setReward(randomReward());
    }

    @Override
    public Enemy createEnemy() {
        return new Snake();
    }

    public int randomAmount() {
        int rand = (int) (Math.random() * 10) + 1;

        if (rand == 1 || rand == 2)
            return 10;
        else if (rand >= 3 && rand <= 5)
            return 5;
        else
            return 1;
    }

    public Reward randomReward() {
        int rand = (int) (Math.random() * 100) + 1;

        if (rand >= 1 && rand <= 15)
            return new Weapon(0, "Weapon", 0, 0);
        else if (rand >= 16 && rand <= 30)
            return new Armor(0, "Armor", 0, 0);
        else if (rand >= 31 && rand <= 55)
            return new Money(randomAmount());

        return null;
    }
}
