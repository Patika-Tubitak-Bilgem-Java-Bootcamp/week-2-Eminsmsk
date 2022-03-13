package GameLocation;

import GameChar.Player;
import GameInventory.Armor;
import GameInventory.Weapon;
import Logic.Game;

public class ToolStore extends NormalLocation {

    public ToolStore(Player player) {
        super(player, "Tool Store");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Welcome to Tool Store");
        System.out.println("1 - Weapons");
        System.out.println("2 - Armors");
        System.out.println("3 - Exit");
        System.out.print("Your choice: ");
        int selection = Game.scan.nextInt();

        while (selection < 1 || selection > 3) {
            System.out.print("Invalid choice!");
            selection = Game.scan.nextInt();
        }

        switch (selection) {
            case 1:
                printWeapons();
                break;
            case 2:
                printArmors();
                break;
            default:
                return true;
        }

        return true;
    }

    private void printArmors() {
        System.out.println();
        this.getPlayer().printInfo();
        System.out.println();
        System.out.println("------ Armors ------");
        System.out.println("0 - Back");
        for (Armor a : Armor.getArmors()) {
            a.printInfo();
        }

        System.out.print("Choose armor: ");
        int selectArmor = Game.scan.nextInt();

        if (selectArmor != 0) {
            System.out.println();
            while (selectArmor < 1 || selectArmor > Weapon.getWeapons().length) {
                System.out.print("Invalid input value, please choose an armor again: ");
                selectArmor = Game.scan.nextInt();
            }

            Armor selectedArmor = Armor.getArmorById(selectArmor);
            if (selectedArmor != null) {
                this.getPlayer().buyArmor(selectedArmor);
            }
        }
    }

    private void printWeapons() {
        System.out.println();
        this.getPlayer().printInfo();
        System.out.println();
        System.out.println("------ Weapon ------");
        System.out.println("0 - Back");
        for (Weapon weapon : Weapon.getWeapons()) {
            weapon.printInfo();
        }

        System.out.print("Choose weapon: ");
        int selectWeapon = Game.scan.nextInt();

        if (selectWeapon != 0) {
            System.out.println();
            while (selectWeapon < 1 || selectWeapon > Weapon.getWeapons().length) {
                System.out.print("Invalid input value, please choose a weapon again: ");
                selectWeapon = Game.scan.nextInt();
            }

            Weapon selectedWeapon = Weapon.getWeaponById(selectWeapon);
            if (selectedWeapon != null) {
                this.getPlayer().buyWeapon(selectedWeapon);
            }
        }
    }
}
