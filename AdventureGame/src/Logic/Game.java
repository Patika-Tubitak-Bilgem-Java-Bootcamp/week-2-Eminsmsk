package Logic;

import GameChar.Player;
import GameLocation.*;

import java.util.Scanner;

public class Game {
    public Player player;
    public static Scanner scan = new Scanner(System.in);

    public void start() {
        System.out.println("Welcome to the Adventure Game!");
        System.out.print("Enter your name: ");
        this.player = new Player(scan.nextLine());
        System.out.println("Hi! " + this.player.getName());

        System.out.println("Firstly, choose a game character...");
        player.selectCharacter();
        System.out.println();

        while (true) {
            Location location = null;
            System.out.println("Locations");
            System.out.println("0 - Exit");
            System.out.println("1 - Safe House");
            System.out.println("2 - Tool Store");
            System.out.println("3 - Cave");
            System.out.println("4 - Forest");
            System.out.println("5 - River");
            System.out.println("6 - Mine");
            System.out.print("Choose a location: ");
            int selectedLocation = Game.scan.nextInt();
            switch (selectedLocation) {
                case 0:
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    if (this.player.getInventory().getAwards().contains("Food")) {
                        System.out.println("\nThis location is cleaned! You cannot enter this place again\n");
                        continue;
                    } else {
                        location = new Cave(player);
                        break;
                    }
                case 4:
                    if (this.player.getInventory().getAwards().contains("Wood")) {
                        System.out.println("\nThis location is cleaned! You cannot enter this place again\n");
                        continue;
                    } else {
                        location = new Forest(player);
                        break;
                    }
                case 5:
                    if (this.player.getInventory().getAwards().contains("Water")) {
                        System.out.println("\nThis location is cleaned! You cannot enter this place again\n");
                        continue;
                    } else {
                        location = new River(player);
                        break;
                    }
                case 6:
                    location = new Mine(player);
                    break;
                default:
                    location = new SafeHouse(player);
            }

            if (location == null) {
                System.out.println();
                System.out.println("It seems you gave up...");
                break;
            }

            System.out.println();
            if (!location.onLocation()) {
                System.out.println("GAME OVER!");
                break;
            }
            System.out.println();
        }
    }
}
