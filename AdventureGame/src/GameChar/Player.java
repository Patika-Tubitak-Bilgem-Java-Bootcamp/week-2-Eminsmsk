package GameChar;

import GameInventory.Armor;
import GameInventory.Inventory;
import GameInventory.Weapon;
import GameObstacle.Enemy;
import Logic.Game;

public class Player {
    private PlayerType character;
    private Inventory inventory;
    private String name;

    public Player(String name) {
        this.inventory = new Inventory();
        this.name = name;
    }

    public void selectCharacter() {
        PlayerType[] types = {new Samurai(), new Archer(), new Knight()};

        System.out.println("---------------------------------------------------------------------------------------");
        for (PlayerType type : types) {
            System.out.println(type.getId() + ". Character: " + type.getName() +
                    "\t Damage: " + type.getDamage() +
                    "\t Health: " + type.getHealth() +
                    "\t Money: " + type.getMoney());
        }
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.print("Please choose a character: ");
        int choice = Game.scan.nextInt();
        while (choice < 1 || choice > (types.length)) {
            System.out.print("Please enter a valid choice: ");
            choice = Game.scan.nextInt();
        }
        this.character = types[choice - 1];
        System.out.println("Your character is "+ this.character.getName());
    }

    public void printInfo() {
        System.out.print("Weapon: " + this.inventory.getWeapon().getName()
                + ", Armor: " + this.inventory.getArmor().getName()
                + ", Damage: " + this.getDamage()
                + ", Health: " + this.character.getHealth()
                + ", Money: " + this.character.getMoney());

        if (this.inventory.getArmor().getBlock() > 0)
            System.out.println(", Armor: " + this.inventory.getArmor().getBlock());
        else
            System.out.println();
    }

    private int getDamage() {
        return this.character.getDamage() + this.inventory.getWeapon().getDamage();
    }

    public void buyWeapon(Weapon weapon) {
        if (weapon.getPrice() <= this.character.getMoney()) {
            this.character.buyItem(weapon.getPrice());
            System.out.println(weapon.getName() + " is purchased.");
            this.inventory.setWeapon(weapon);
            this.printInfo();
        } else {
            System.out.println("You don't have enough money!");
        }
    }

    public void buyArmor(Armor armor) {
        if (armor.getPrice() <= this.character.getMoney()) {
            this.character.buyItem(armor.getPrice());
            System.out.println(armor.getName() + " is purchased");
            this.inventory.setArmor(armor);
            this.printInfo();
        } else {
            System.out.println("You don't have enough money!");
        }
    }

    public void attack(Enemy enemy) {
        if (this.getCharacter().getHealth() > 0) {
            System.out.println(this.character.getName() + " " + this.name + " with " + this.inventory.getWeapon().getName() + " is attacking!");
            enemy.setHealth(enemy.getHealth() - this.getDamage());
            enemy.printInfo();
            System.out.println();
        }
    }

    public PlayerType getCharacter() {
        return character;
    }

    public void setCharacter(PlayerType character) {
        this.character = character;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

