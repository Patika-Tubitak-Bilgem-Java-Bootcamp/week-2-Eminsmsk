package GameLocation;

import GameChar.Player;
import GameObstacle.Snake;

public class Mine extends BattleLocation {

    public Mine(Player player) {
        super(player, "Mine", new Snake(), null, 5);
    }

}
