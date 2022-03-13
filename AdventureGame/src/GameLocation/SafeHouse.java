package GameLocation;

import GameChar.Player;

public class SafeHouse extends NormalLocation {

    public SafeHouse(Player player) {
        super(player, "Safe House");
    }

    @Override
    public boolean onLocation() {
        if (this.getPlayer().getInventory().getAwards().size() == 3) {
            System.out.println("CONGRATULATIONS! " + this.getPlayer().getName() + " You won the game by cleaning 3 locations out there!");
            System.exit(0);
        }

        System.out.println("You are at safe house. No enemy here...");
        this.getPlayer().getCharacter().fillHealth();
        System.out.println("Your health got full");
        System.out.println("Health: " + this.getPlayer().getCharacter().getHealth());
        return true;
    }
}
