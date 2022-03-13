package GameInventory;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private Weapon weapon;
    private Armor armor;
    private final List<String> awards;

    public Inventory() {
        this.weapon = new Weapon(0, "Punch", 0, 0);
        this.armor = new Armor(0, "Normal", 0, 0);
        this.awards = new ArrayList<String>();
    }

    public void addAward(String award) {
        this.awards.add(award);
    }

    public List<String> getAwards() {
        return this.awards;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        int newDamage = weapon.getDamage() - this.weapon.getDamage();
        if (newDamage > 0)
            System.out.println("Damage --> +" + newDamage);
        else if (newDamage < 0)
            System.out.println("Damage --> " + newDamage);

        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        int newBlock = armor.getBlock() - this.armor.getBlock();
        if (newBlock > 0)
            System.out.println("Armor --> +" + newBlock);
        else if (newBlock < 0)
            System.out.println("Armor --> " + newBlock);

        this.armor = armor;
    }
}
