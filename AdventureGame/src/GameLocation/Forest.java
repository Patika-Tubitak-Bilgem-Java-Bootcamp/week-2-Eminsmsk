package GameLocation;

import GameChar.Player;
import GameObstacle.Vampire;

public class Forest extends BattleLocation {

    public Forest(Player player) {
        super(player, "Forest", new Vampire(), "Wood", 3);
    }

}
