package GameChar;

public abstract class PlayerType {

    private final int id;
    private String name;
    private int damage;
    private int health;
    private int money;

    public PlayerType(int id, String name, int damage, int health, int money) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.money = money;
    }

    public abstract void fillHealth();

    public void buyItem(int price) {
        this.money -= price;
        System.out.println("Money --> -" + price);
    }

    public void decreaseHealth(int health) {
        this.health -= health;
        if (this.health < 0)
            this.health = 0;
        System.out.println("Health --> -" + health);
    }

    public void increaseMoney(int amount) {
        this.money += amount;
        System.out.println("Money --> +" + amount);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        if (damage < 0) {
            this.damage = 0;
            return;
        }

        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0) {
            this.health = 0;
            return;
        }

        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        if (money < 0) {
            this.money = 0;
            return;
        }

        this.money = money;
    }

    public int getId() {
        return id;
    }
}
