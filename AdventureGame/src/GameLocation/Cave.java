package GameLocation;

import GameChar.Player;
import GameObstacle.Zombie;

public class Cave extends BattleLocation {

    public Cave(Player player) {
        super(player, "Cave", new Zombie(), "Food", 3);
    }


}
