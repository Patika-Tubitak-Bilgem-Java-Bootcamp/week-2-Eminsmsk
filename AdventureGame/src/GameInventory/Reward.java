package GameInventory;

import GameChar.Player;

public interface Reward {
    void claim(Player player);

    String getName();
}
