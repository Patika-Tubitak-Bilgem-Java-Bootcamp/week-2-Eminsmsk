package GameInventory;

import GameChar.Player;

public class Weapon implements Reward {
    private int id;
    private String name;
    private int damage;
    private int price;

    public Weapon(int id, String name, int damage, int price) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.price = price;
    }

    public static Weapon[] getWeapons() {
        Weapon[] weaponList = new Weapon[3];
        weaponList[0] = new Weapon(1, "Pistol", 2, 25);
        weaponList[1] = new Weapon(2, "Sword", 3, 35);
        weaponList[2] = new Weapon(3, "Rifle", 7, 45);
        return weaponList;
    }


    public static Weapon getWeaponById(int id) {
        for (Weapon w : Weapon.getWeapons()) {
            if (w.getId() == id)
                return w;
        }
        return null;
    }

    public void printInfo() {
        System.out.println(this.getId() + " - " + this.getName() + " <Price : " + this.getPrice() + ", Damage : " + this.getDamage() + ">");
    }

    public Weapon getRandomWeapon() {
        int rand = (int) (Math.random() * 10) + 1;

        if (rand == 1 || rand == 2)
            return Weapon.getWeapons()[2];
        else if (rand >= 3 && rand <= 5)
            return Weapon.getWeapons()[1];
        else
            return Weapon.getWeapons()[0];
    }

    @Override
    public void claim(Player player) {
        player.getInventory().setWeapon(getRandomWeapon());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
