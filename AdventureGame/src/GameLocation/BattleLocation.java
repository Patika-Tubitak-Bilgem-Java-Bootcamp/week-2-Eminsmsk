package GameLocation;

import GameChar.Player;
import GameObstacle.Enemy;
import Logic.Game;

import java.util.Random;

public class BattleLocation extends Location {
    private Enemy enemy;
    private String award;
    private final int maxEnemy;

    public BattleLocation(Player player, String name, Enemy enemy, String award, int maxEnemy) {
        super(player, name);
        this.enemy = enemy;
        this.award = award;
        this.maxEnemy = maxEnemy;
    }

    @Override
    public boolean onLocation() {
        int enemyNumber = randomEnemyNumber();
        System.out.println("You are at the " + this.getName());
        System.out.println("Be Careful! There are " + enemyNumber + " " + this.enemy.getName() + " here!");
        System.out.print("<Fight (press 'F') or Leave (press any)>");
        Game.scan.nextLine();
        String selectCase = Game.scan.nextLine().toUpperCase();
        if (selectCase.equals("F")) {
            int result = combat(enemyNumber);
            if (result == 0)
                return false;
            else if (result == 1)
                return true;
            else {
                System.out.println("Congrats! " + this.getName() + " is cleaned from obstacles!");
                if (this.award != null) {
                    System.out.println("You win " + this.award);
                    this.getPlayer().getInventory().addAward(this.award);
                }

                System.out.println();
                System.out.print("Your prizes...");
                for (int i = 0; i < this.getPlayer().getInventory().getAwards().size(); i++) {
                    System.out.print(this.getPlayer().getInventory().getAwards().get(i) + " ");
                }
                System.out.println();
            }
        }
        return true;
    }

    public int combat(int enemyNumber) {
        int rand;
        for (int i = 1; i <= enemyNumber; i++) {
            getPlayer().printInfo();
            while (this.getPlayer().getCharacter().getHealth() > 0 && this.getEnemy().getHealth() > 0) {
                System.out.println();
                System.out.print("<Fight (press 'F') or Leave (press any)>");
                String selectCombat = Game.scan.nextLine().toUpperCase();
                if (selectCombat.equals("F")) {
                    rand = (int) (Math.random() * 2) + 1;
                    if (rand == 1) {
                        this.getPlayer().attack(enemy);
                        this.enemy.attack(this.getPlayer());
                    } else {
                        this.enemy.attack(this.getPlayer());
                        this.getPlayer().attack(enemy);
                    }
                } else {
                    break;
                }
            }

            if (this.getPlayer().getCharacter().getHealth() <= 0) {
                System.out.println();
                System.out.println("WASTED!!!");
                return 0;
            } else if (this.getEnemy().getHealth() <= 0) {
                System.out.println("Congrats! " + this.getName() + " is dead!");
                if (this.enemy.getReward() != null) {
                    if (this.enemy.getName().equals("Snake")) {
                        System.out.println("You are awarded " + this.enemy.getReward().getName());
                    }
                    this.enemy.getReward().claim(this.getPlayer());
                } else {
                    System.out.println("No awards here..");
                }

                if (i != enemyNumber) {
                    System.out.println(i + 1 + ". " + this.getEnemy().getName() + " approaching.");
                }
                this.setEnemy(this.getEnemy().createEnemy());
            } else {
                return 1;
            }

            System.out.println();
        }
        return 2;
    }

    public int randomEnemyNumber() {
        Random rand = new Random();
        return rand.nextInt(this.maxEnemy) + 1;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

}
