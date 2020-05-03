/*
                                         secret room (piles of gold)
vault(3 walking skel, 25% secret room)   parlor (treasure chest)                            dining (dust, empty box)
                                         library (spiders)          front room(piano)       kitchen (bats)
                                                                    foyer(dead scorpion)
 */
import java.util.Scanner;
import java.util.Random;

public class Zork {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Zork!");
        String direction = "";

        do {
            promptMove();
            direction = input.nextLine();
        } while (!direction.equals("u"));

        foyer();
    }

    public static void promptMove() {
        System.out.println("Enter one of the keys to move:\n" +
                "up: 'u'\n" +
                "down: 'd'\n" +
                "left: 'l'\n" +
                "right: 'r'");
    }

    public static String getMove() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    public static void foyer() {
        System.out.println("You are in the foyer.");
        System.out.println("There's a dead scorpion in the room.");
        String direction = "";
        boolean validMove = false;

        do {
            promptMove();
            direction = getMove();

            switch (direction) {
                case "u":
                    validMove = true;
                    frontRoom();
                    break;
                case "d":
                    Random random = new Random();
                    int ghostChance = random.nextInt(4);
                    boolean followedByGhost = ghostChance == 1;
                    System.out.println("You are leaving the house.");
                    if (followedByGhost) {
                        System.out.println("A ghost will haunt you forever.");
                    }
                    System.exit(1);
                default:
                    System.out.println("There's nothing there.");
                    System.out.println("You are still in the foyer.");
            }
        } while (!validMove);
    };

    public static void frontRoom() {
        System.out.println("You are in the front room.");
        System.out.println("There's a piano in the room.");
        boolean validMove = false;
        String direction = "";

        do {
            promptMove();
            direction = getMove();

            switch (direction) {
                case "r":
                    validMove = true;
                    kitchen();
                    break;
                case "d":
                    validMove = true;
                    foyer();
                    break;
                case "l":
                    validMove = true;
                    library();
                    break;
                default:
                    System.out.println("There's nothing there.");
                    System.out.println("You are still in the front room.");
            }
        } while (!validMove);
    }

    public static void library() {
        System.out.println("You are in the library.");
        System.out.println("There are spiders in the room.");
        String direction = "";
        boolean validMove = false;

        do {
            promptMove();
            direction = getMove();

            switch (direction) {
                case "u":
                    validMove = true;
                    parlor();
                    break;
                case "r":
                    validMove = true;
                    frontRoom();
                    break;
                default:
                    System.out.println("There's nothing there.");
                    System.out.println("You are still in the library.");
            }
        } while (!validMove);
    };
    public static void kitchen() {
        System.out.println("You are in the kitchen.");
        System.out.println("There are bats in the room.");
        String direction = "";
        boolean validMove = false;

        do {
            promptMove();
            direction = getMove();

            switch (direction) {
                case "u":
                    validMove = true;
                    diningRoom();
                    break;
                case "l":
                    validMove = true;
                    frontRoom();
                    break;
                default:
                    System.out.println("There's nothing there.");
                    System.out.println("You are still in the kitchen.");
            }
        } while (!validMove);
    };

    public static void diningRoom() {
        System.out.println("You are in the dining room.");
        System.out.println("There is dust and an empty box in the room.");
        String direction = "";
        boolean validMove = false;

        do {
            promptMove();
            direction = getMove();

            switch (direction) {
                case "d":
                    validMove = true;
                    kitchen();
                    break;
                default:
                    System.out.println("There's nothing there.");
                    System.out.println("You are still in the dining room.");
            }
        } while (!validMove);
    };

    public static void parlor() {
        System.out.println("You are in the parlor.");
        System.out.println("There is a treasure chest in the room.");
        String direction = "";
        boolean validMove = false;

        do {
            promptMove();
            direction = getMove();

            switch (direction) {
                case "d":
                    validMove = true;
                    library();
                    break;
                case "l":
                    validMove = true;
                    vault();
                    break;
                default:
                    System.out.println("There's nothing there.");
                    System.out.println("You are still in the parlor.");
            }
        } while (!validMove);
    };

    public static void vault() {
        System.out.println("You are in the vault.");
        System.out.println("There are three walking skeletons in the room.");
        String direction = "";
        boolean validMove = false;
        boolean inUpperVault = false;
        Random random = new Random();
        int chance = random.nextInt(4);

        do {
            promptMove();
            direction = getMove();

            switch (direction) {
                case "r":
                    if (chance == 1 && inUpperVault) {
                        boolean foundRoom = false;
                        do {
                            promptMove();
                            direction = getMove();

                            switch (direction) {
                                case "r":
                                    secretRoom();
                                    foundRoom = true;
                                    break;
                                case "d":
                                    System.out.println("You are back to ");
                            }

                        } while (!foundRoom);
                    }
                    if (!inUpperVault) {
                        parlor();
                        break;
                    }
                case "u":
                    if (!inUpperVault) {
                        inUpperVault = true;
                        System.out.println("You are in another part of the vault.");
                    } else {
                        System.out.println("There's nothing there.");
                        System.out.println("You are still in the vault.");
                    }
                    break;
                case "d":
                    if (inUpperVault) {
                        inUpperVault = false;
                        System.out.println("You are back to where you were.");
                    } else {
                        System.out.println("There's nothing there.");
                        System.out.println("You are still in the vault.");
                    }
                    break;
                default:
                    System.out.println("There's nothing there.");
                    System.out.println("You are still in the vault.");
            }
        } while (!validMove);
    };

    public static void secretRoom() {
        System.out.println("You are in the secret vault.");
        System.out.println("You found piles of gold!");
        String direction = "";
        boolean validMove = false;

        do {
            promptMove();
            direction = getMove();

            switch (direction) {
                case "l":
                    validMove = true;
                    vault();
                    break;
                default:
                    System.out.println("There's nothing there.");
                    System.out.println("You are still in the secret room.");
            }
        } while (!validMove);
    }
}
