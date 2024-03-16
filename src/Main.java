import java.util.*;

public class Main {

    private static final List<User> users = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    private static int userID = 1000;

    private static void addDemoData() {

        User user0 = new User("whitewolf", "GeraltofRivia", 220668);
        user0.setHomeland(new Marshland());
        user0.createArmy(new Ranger(), new Squire(), new Warlock(), new Medic(), new Dragon());
        user0.getArcher().setArmour(new Chainmail());
        user0.getHealer().setArtefact(new Amulet());
        user0.setGoldcoins(215);
        user0.setXP(32);
        users.add(user0);

        User user1 = new User("vimosh", "VIMOSH", 220667);
        user1.setHomeland(new Hillcrest());
        user1.createArmy(new Shooter(), new Squire(), new Enchanter(), new Medic(), new Basilisk());
        user1.setGoldcoins(200);
        users.add(user1);

        User user2 = new User("abishan", "ABISHAN", 220014);
        user2.setHomeland(new Marshland());
        user2.createArmy(new Ranger(), new Cavalier(), new Illusionist(), new Saint(), new Dragon());
        user2.setGoldcoins(150);
        users.add(user2);

        User user3 = new User("nived", "NIVED", 220436);
        user3.setHomeland(new Desert());
        user3.createArmy(new Sunfire(), new Swiftblade(), new Conjurer(), new Soother(), new Hydra());
        user3.setGoldcoins(300);
        users.add(user3);

        User user4 = new User("aadhi", "AADHI", 220001);
        user4.setHomeland(new Arcane());
        user4.createArmy(new Zing(), new Templar(), new Eldritch(), new Lightbringer(), new Pegasus());
        user4.setGoldcoins(180);
        users.add(user4);
    }

    public static void main(String[] args) {

        String RESET = "\033[0m"; // Text Reset
        String GREEN = "\033[0;32m"; // GREEN
        String YELLOW = "\033[0;33m"; // YELLOW
        String CYAN = "\033[0;36m"; // CYAN
        String RED = "\033[0;31m"; // RED
        System.out.println(GREEN + "\r\n" + //
                "                  _   _                           _                    \r\n" + //
                "  /\\/\\  _   _ ___| |_(_) ___    /\\/\\   __ _ _   _| |__   ___ _ __ ___  \r\n" + //
                " /    \\| | | / __| __| |/ __|  /    \\ / _` | | | | '_ \\ / _ \\ '_ ` _ \\ \r\n" + //
                "/ /\\/\\ \\ |_| \\__ \\ |_| | (__  / /\\/\\ \\ (_| | |_| | | | |  __/ | | | | |\r\n" + //
                "\\/    \\/\\__, |___/\\__|_|\\___| \\/    \\/\\__,_|\\__, |_| |_|\\___|_| |_| |_|\r\n" + //
                "        |___/                               |___/                      \r" + //
                "" + RESET);
        System.out.println("                                                        From CODE A.N.V");
        System.out.println(YELLOW + " __________________________________________________|_._._._._._._._._._.\r\n" + //
                " \\_________________________________________________|_#_#_#_#_#_#_#_#_#_|\r\n" + //
                "                                                   l" + RESET);
        while (true) {
            addDemoData();
            System.out.println();

            System.out.println(YELLOW + "                          Welcome to the Game\n" + RESET);
            System.out.println("------------------------------ Main Menu ------------------------------");
            System.out.println();
            System.out.println(GREEN + "1. Sign Up");
            System.out.println("2. Login");
            System.out.println("3. Exit" + RESET);
            System.out.println();
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    signUp();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    System.out.println(RED + "Exiting..." + RESET);
                    System.exit(0);
                    break;
                default:
                    System.out.println();
                    System.out.println(RED + "Invalid choice. Please try again." + RESET);
                    System.out.println();
            }
        }
    }

    private static void signUp() {
        String RESET = "\u001B[0m";
        String YELLOW = "\u001B[33m";
        String CYAN = "\u001B[36m";
        String RED = "\u001B[31m";

        System.out.println("\n----------------------------- SignUp Menu -----------------------------\n");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        // Check if the username already exists
        if (userExists(username)) {
            System.out.println(RED + "Username already exists. Please choose a different username." + RESET);
            System.out.println();
            return;
        }

        System.out.print("Enter player name: ");
        String playerName = scanner.nextLine();
        System.out.println();
        // new----------------------------------------------------
        System.out.println(CYAN + "Select your home ground for battles \n");
        System.out.println("1. Hillcrest");
        System.out.println("2. Marshland");
        System.out.println("3. Desert");
        System.out.println("4. Arcane\n" + RESET);
        System.out.print("Enter your choice: ");
        int playgroundChoice = scanner.nextInt();
        scanner.nextLine();
        System.out.println();

        String playground;
        switch (playgroundChoice) {
            case 1:
                playground = "Hillcrest";
                break;
            case 2:
                playground = "Marshland";
                break;
            case 3:
                playground = "Desert";
                break;
            case 4:
                playground = "Arcane";
                break;
            default:
                System.out.println(RED + "Invalid choice. Defaulting to Hillcrest.\n" + RESET);
                playground = "Hillcrest";
        }

        User newUser = new User(username, playerName, userID);
        newUser.setHomeland(new playground(playground));

        users.add(newUser);
        System.out.println();
        System.out.println(YELLOW + "Account created successfully.");
        System.out.println("Your user ID is : " + userID);
        System.out.println("You have been awarded " + newUser.getGoldCoins() + " gold coins." + RESET);
        System.out.println();
        System.out.println("Now, let's buy an army for your user.");
        System.out.println();
        openShop(newUser);
        // displayUsers(); // Display users after sign up
        userID++; // Increment userID for the next user
    }

    private static boolean userExists(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    private static void login() {
        String RESET = "\u001B[0m";
        String YELLOW = "\u001B[33m";
        String CYAN = "\u001B[36m";
        String RED = "\u001B[31m";
        System.out.println("\n----------------------------- Login Menu ------------------------------\n");
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.println();
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                System.out.println("-- Welcome, " + user.getPlayerName() + "!");
                System.out.println("-- User XP : " + user.getXP() + "\n");
                System.out.println("-- Available coins : " + YELLOW + user.getGoldCoins() + "\n");
                System.out.println(user.getArmyComposition() + RESET);
                while (true) {
                    System.out.println();
                    System.out.println(CYAN + "1. Play Battle");
                    System.out.println("2. Change Player Name");
                    System.out.println("3. Shop");
                    System.out.println("4. View your Army");
                    System.out.println("5. View your Gold Coins");
                    System.out.println("6. Back to Menu" + RESET);
                    System.out.println();
                    System.out.print("Enter your choice: ");
                    int choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.println();
                    switch (choice) {
                        case 1:
                            selectOpponent(user);
                            break;
                        case 2:
                            changePlayerName(user);
                            break;
                        case 3:
                            openShop(user);
                            break;
                        case 4:
                            System.out.println(YELLOW + user.getArmyComposition() + RESET);
                            break;
                        case 5:
                            System.out.println(YELLOW + "Gold coins: " + user.getGoldCoins() + RESET);
                            break;
                        case 6:
                            return;
                        default:
                            System.out.println(RED + "Invalid choice. Please try again." + RESET);
                    }
                }
            }
        }
        System.out.println(RED + "Username not found." + RESET);
        System.out.println();
    }

    private static void selectOpponent(User user) {
        List<User> availableOpponents = new ArrayList<>();
        for (User opponent : users) {
            if (!opponent.getUsername().equals(user.getUsername())) {
                availableOpponents.add(opponent);
            }
        }

        int index = 0;
        while (true) {
            if (index < availableOpponents.size()) {
                User opponent = availableOpponents.get(index);
                System.out.println(opponent.getPlayerName() + " - " + opponent.getXP() + "XP");
                System.out.println("1. Play");
                if (index < availableOpponents.size() - 1) {
                    System.out.println("2. Next");
                }
                System.out.println("3. Back to Menu");
                System.out.println();
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.println();
                switch (choice) {
                    case 1:
                        playBattle(user, opponent);
                        return;
                    case 2:
                        index++;
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }

            else {
                System.out.println("No more opponents available.");
                return;
            }
        }
    }

    private static void playBattle(User user, User opponent) {
        String RESET = "\033[0m"; // Text Reset
        String YELLOW = "\033[0;33m"; // YELLOW
        String CYAN = "\033[0;36m";
        String ORANGE = "\u001B[38;2;255;165;0m";

        System.out.println("\n------------------------------- Battle --------------------------------\n");
        if (!user.hasCharacterOfCategory(Archer.class) || !user.hasCharacterOfCategory(Knight.class)
                || !user.hasCharacterOfCategory(Mage.class) || !user.hasCharacterOfCategory(Healer.class)
                || !user.hasCharacterOfCategory(MythicalCreature.class)) {
            System.out.println("You need to have one character from each category before proceeding to the shop.");
            buyArmy(user);
        } // Redirect to buy characters
        System.out.println(YELLOW + user.getArmyComposition() + RESET);
        System.out.println();
        System.out.print("Starting battle in ");
        countdown();
        System.out.println();
        System.out.println(CYAN + user.getPlayerName() + RESET + " vs " + ORANGE + opponent.getPlayerName() + RESET);
        System.out.println();
        System.out.println(CYAN + "\r\n" + //
                "    ____  ___  ______________    ______     ____  _________________   _______    \r\n" + //
                "   / __ )/   |/_  __/_  __/ /   / ____/    / __ )/ ____/ ____/  _/ | / / ___/    \r\n" + //
                "  / __  / /| | / /   / / / /   / __/      / __  / __/ / / __ / //  |/ /\\__ \\     \r\n" + //
                " / /_/ / ___ |/ /   / / / /___/ /___     / /_/ / /___/ /_/ // // /|  /___/ /     \r\n" + //
                "/_____/_/  |_/_/   /_/ /_____/_____/    /_____/_____/\\____/___/_/ |_//____/      \r\n" + //
                "                                                                                 \r\n" + //
                "" + RESET);
        playBattle playBattle = new playBattle(user, opponent);

    }

    private static void buyEquipments(User user) {
        String RESET = "\u001B[0m";
        String GREEN = "\u001B[32m";
        String RED = "\u001B[31m";
        // check if he has all the characters
        if (!user.hasCharacterOfCategory(Archer.class) || !user.hasCharacterOfCategory(Knight.class)
                || !user.hasCharacterOfCategory(Mage.class) || !user.hasCharacterOfCategory(Healer.class)
                || !user.hasCharacterOfCategory(MythicalCreature.class)) {
            System.out.println(
                    RED + "You need to have one character from each category before proceeding to the shop." + RESET);
            buyArmy(user); // Redirect to buy characters
        }

        while (true) {
            System.out.println(GREEN + "Choose an equipment category");
            System.out.println("-----------------------------");
            System.out.println("1. Armour");
            System.out.println("2. Artefact");
            System.out.println("3. Back to Login Menu");
            System.out.println("-----------------------------" + RESET);
            System.out.println();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.println();
            switch (choice) {
                case 1:
                    buyArmour(user);
                    break;
                case 2:
                    buyArtefact(user);
                    break;
                case 3:
                    return;
                default:
                    System.out.println(RED + "Invalid choice. Please try again." + RESET);
            }
        }
    }

    private static void buyArtefact(User user) {
        String RESET = "\u001B[0m";
        String YELLOW = "\u001B[33m";
        String CYAN = "\u001B[36m";
        String RED = "\u001B[31m";
        System.out.println("\n---------------------------- Artefact Shop-----------------------------\n");
        System.out.println(YELLOW + "Gold left: " + user.getGoldCoins() + RESET);

        // Choose a character to buy artefact for
        System.out.println(CYAN + "Choose a character to buy artefact for\n");
        System.out.println("1. Archer");
        System.out.println("2. Knight");
        System.out.println("3. Mage");
        System.out.println("4. Healer");
        System.out.println("5. Mythical Creature");
        System.out.println("6. Cancel\n");
        System.out.println(RESET);
        int characterChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Character character = null;

        switch (characterChoice) {
            case 1:
                if (!user.hasCharacterOfCategory(Archer.class)) {
                    System.out.println(RED + "You don't have an archer.\n" + RESET);
                    buyArmy(user); // Redirect to buy characters
                    // return;
                }
                character = user.getArcher();
                break;
            case 2:
                if (!user.hasCharacterOfCategory(Knight.class)) {
                    System.out.println(RED + "You don't have a knight.\n" + RESET);
                    buyArmy(user); // Redirect to buy characters
                }
                character = user.getKnight();
                break;
            case 3:
                if (!user.hasCharacterOfCategory(Mage.class)) {
                    System.out.println(RED + "You don't have a mage.\n" + RESET);
                    buyArmy(user); // Redirect to buy characters
                    // return;
                }
                character = user.getMage();
                break;
            case 4:
                if (!user.hasCharacterOfCategory(Healer.class)) {
                    System.out.println(RED + "You don't have a healer.\n" + RESET);
                    buyArmy(user); // Redirect to buy characters
                    // return;
                }
                character = user.getHealer();
                break;
            case 5:
                if (!user.hasCharacterOfCategory(MythicalCreature.class)) {
                    System.out.println(RED + "You don't have a mythical creature.\n" + RESET);
                    buyArmy(user); // Redirect to buy characters
                    // return;
                }
                character = user.getMythicalCreature();
                break;
            case 6:
                System.out.println(RED + "Cancelled buying artefact.\n" + RESET);
                return;
            default:
                System.out.println(RED + "Invalid choice.\n" + RESET);
                return;
        }

        // Choose artefact to buy: Excalibur, Amulet, Crystal
        System.out.println(CYAN + "Choose an artefact to buy" + RESET);
        System.out.println("-------------------------");
        System.out.println(CYAN + "1. Excalibur - 150 gc");
        System.out.println("2. Amulet - 200 gc");
        System.out.println("3. Crystal - 210 gc");
        System.out.println("4. Skip buying artefact." + RESET);
        System.out.println("-------------------------\n");
        System.out.print("Enter your choice : ");
        int artefactChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Artefact artefact = null;

        switch (artefactChoice) {
            case 1:
                System.out.println(RED + "You chose Excalibur.\n" + RESET);
                artefact = new Excaliber();
                break;
            case 2:
                System.out.println(RED + "You chose Amulet.\n" + RESET);
                artefact = new Amulet();
                break;
            case 3:
                System.out.println(RED + "You chose Crystal.\n" + RESET);
                artefact = new Crystal();
                break;
            case 4:
                System.out.println(RED + "You chose to skip buying artefact.\n" + RESET);
                return;
            default:
                System.out.println(RED + "Invalid choice.\n" + RESET);
                return;
        }

        if (artefact != null) {
            if (user.getGoldCoins() >= artefact.getPrice()) {
                character.setArtefact(artefact);
                System.out.println("------------------------------------");
                user.setGoldcoins(user.getGoldCoins() - artefact.getPrice());
                System.out.println(
                        YELLOW + "Bought " + artefact.getName() + " for " + artefact.getPrice() + " gold." + RESET);
                System.out.println("------------------------------------\n");
            } else {
                System.out.println("------------------------------------");
                System.out.println(RED + "Not enough gold to buy " + artefact.getName() + "." + RESET);
                System.out.println("------------------------------------\n");
            }
        }
    }

    private static void buyArmour(User user) {
        String RESET = "\u001B[0m";
        String GREEN = "\u001B[32m";
        String YELLOW = "\u001B[33m";
        String PURPLE = "\u001B[35m";
        String RED = "\u001B[31m";
        System.out.println("\n----------------------------- Armour Shop------------------------------\n");

        System.out.println(YELLOW + "Gold left: " + user.getGoldCoins() + RESET);
        System.out.println(GREEN
                + "\nChoose a character to buy armor for:\n1. Archer\n2. Knight\n3. Mage\n4. Healer\n5. Mythical Creature \n6. Back to Shop\n"
                + RESET);
        System.out.print("Enter your choice : ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println();
        Character character = null;
        switch (choice) {
            case 1:
                System.out.println(PURPLE + "You have chosen your Archer.\n" + RESET);
                // check if he has archer
                if (!user.hasCharacterOfCategory(Archer.class)) {
                    System.out.println(RED + "You don't have an archer.\n" + RESET);
                    buyArmy(user); // Redirect to buy characters
                    return;
                } else {
                    character = user.getArcher();
                }

                break;
            case 2:
                System.out.println(PURPLE + "You have chosen your Knight.\n" + RESET);
                // check if he has knight
                if (!user.hasCharacterOfCategory(Knight.class)) {
                    System.out.println(RED + "You don't have a knight.\n" + RESET);
                    buyArmy(user); // Redirect to buy characters
                    return;
                } else {
                    character = user.getKnight();
                }
                break;
            case 3:
                System.out.println(PURPLE + "You have chosen your Mage.\n" + RESET);
                // check if he has mage
                if (!user.hasCharacterOfCategory(Mage.class)) {
                    System.out.println(RED + "You don't have a mage.\n" + RESET);
                    buyArmy(user); // Redirect to buy characters
                    return;
                } else {
                    character = user.getMage();
                }
                break;
            case 4:
                System.out.println(PURPLE + "You have chosen your Healer.\n" + RESET);
                // check if he has healer
                if (!user.hasCharacterOfCategory(Healer.class)) {
                    System.out.println(RED + "You don't have a healer.\n" + RESET);
                    buyArmy(user); // Redirect to buy characters
                    return;
                } else {
                    character = user.getHealer();
                }
                break;
            case 5:
                System.out.println(PURPLE + "You have chosen your Mythical Creature.\n" + RESET);
                // check if he has mythical creature
                if (!user.hasCharacterOfCategory(MythicalCreature.class)) {
                    System.out.println(RED + "You don't have a mythical creature.\n" + RESET);
                    buyArmy(user); // Redirect to buy characters
                    return;
                } else {
                    character = user.getMythicalCreature();
                }
                break;
            case 6:
                return;
            default:
                System.out.println(RED + "Invalid choice.\n" + RESET);
        }

        // Choose armor to buy: Chainmail, Regalia, Fleece
        System.out.println(GREEN
                + "Choose an armor to buy:\n1. Chainmail - 70 gc\n2. Regalia - 105 gc\n3. Fleece - 150 gc\n4. Skip buying armor\n"
                + RESET);

        System.out.print("Enter your choice : ");
        int armourChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println();
        Armour armour = null;
        switch (armourChoice) {
            case 1:
                System.out.println(PURPLE + "You have chosen the Chainmail.\n" + RESET);
                armour = new Chainmail();
                break;
            case 2:
                System.out.println(PURPLE + "You have chosen the Regalia.\n" + RESET);
                armour = new Regalia();
                break;
            case 3:
                System.out.println(PURPLE + "You have chosen the Fleece.\n" + RESET);
                armour = new Fleece();
                break;
            case 4:
                System.out.println(PURPLE + "You have chosen to skip buying an armor.\n" + RESET);
                return;
            default:
                System.out.println(PURPLE + "Invalid choice.\n" + RESET);
        }

        if (armour != null) {
            if (user.getGoldCoins() >= armour.getPrice()) {
                character.setArmour(armour);
                user.setGoldcoins(user.getGoldCoins() - armour.getPrice());
                System.out.println("------------------------------------");
                System.out.println(
                        YELLOW + "Bought " + armour.getName() + " for " + armour.getPrice() + " gold coins." + RESET);
                System.out.println("Gold left: " + user.getGoldCoins());
                System.out.println("------------------------------------\n");
            } else {
                warning();
                System.out.println("------------------------------------");
                System.out.println(RED + "Not enough gold to buy " + armour.getName() + "." + RESET);
                System.out.println(YELLOW + "Gold left: " + user.getGoldCoins() + RESET);
                System.out.println("------------------------------------");
                System.out.println();
                return;
            }
        }
    }

    private static void countdown() {
        try {
            for (int i = 3; i > 0; i--) {
                System.out.print(i + "... ");
                Thread.sleep(1000); // Wait for 1 second
            }
            System.out.println("Go!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void loading() {
        try {
            System.out.print("- Loading ... ");
            Thread.sleep(1000); // Wait for 1 second
            System.out.println("\n");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void warning() {
        try {
            System.out.print("- Warning ... ");
            Thread.sleep(1000); // Wait for 1 second
            System.out.println("\n");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void changePlayerName(User user) {
        System.out.println("---------------------------- Change Name ------------------------------\n");
        System.out.println("Current player name: " + user.getPlayerName() + "\n");
        System.out.print("Enter new player name: ");
        String newPlayerName = scanner.nextLine();
        user.setPlayerName(newPlayerName);
        System.out.println("Player name changed successfully.\n");
        System.out.println("New player name: " + user.getPlayerName() + "\n");
        // displayUsers(); // Display users after name change
    }

    private static void openShop(User user) {

        String RESET = "\u001B[0m";
        String GREEN = "\u001B[32m";
        String YELLOW = "\u001B[33m";
        String CYAN = "\u001B[36m";
        String RED = "\u001B[31m";

        System.out.println("-------------------------------- Shop ---------------------------------\n");
        System.out.println(GREEN + "                          Welcome to the Shop!" + RESET);
        System.out.println();
        System.out.println("Your Army Composition:");
        System.out.println(YELLOW + user.getArmyComposition());
        System.out.println("" + RESET);
        System.out.println(CYAN + "1. Buy Army");
        System.out.println("2. Buy Equipments");
        System.out.println("3. Sell Items");
        System.out.println("4. Back to menu" + RESET);// Added sell option
        System.out.println();
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println();

        switch (choice) {
            case 1:
                buyArmy(user);
                break;
            case 2:
                buyEquipments(user);
                break;
            case 3:
                sellItems(user); // Call the method for selling items
                break;
            case 4:
                return;
            default:
                System.out.println(RED + "Invalid choice. Please try again." + RESET);
        }
    }

    private static void sellItems(User user) {
        String RESET = "\u001B[0m";
        String CYAN = "\u001B[36m";
        String RED = "\u001B[31m";
        System.out.println(CYAN + "Welcome to the Sell Items section!" + RESET);
        System.out.println("-----------------------------------");
        System.out.println();
        System.out.println(CYAN + "1. Sell Army");
        // System.out.println("2. Sell Equipments");
        System.out.println("2. Back" + RESET);
        System.out.println();
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println();

        switch (choice) {
            case 1:
                sellArmy(user);
                break;
            // case 2:
            // sellEquipments(user);
            // break;
            case 2:
                return; // Back to shop
            default:
                System.out.println(RED + "Invalid choice. Please try again." + RESET);
                System.out.println();
        }
    }

    private static void sellArmy(User user) {
        System.out.println("------------------------------ Army Shop------------------------------");
        String RESET = "\u001B[0m";
        String GREEN = "\u001B[32m";
        String RED = "\u001B[31m";

        System.out.println(GREEN + "Which character would you like to sell?");
        System.out.println();
        System.out.println("1. Archer");
        System.out.println("2. Knight");
        System.out.println("3. Mage");
        System.out.println("4. Healer");
        System.out.println("5. Mythical Creature");
        System.out.println("6. Back" + RESET);
        System.out.println();
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println();

        switch (choice) {
            case 1:
                sellCharacter(user, user.getArcher());
                break;
            case 2:
                sellCharacter(user, user.getKnight());
                break;
            case 3:
                sellCharacter(user, user.getMage());
                break;
            case 4:
                sellCharacter(user, user.getHealer());
                break;
            case 5:
                sellCharacter(user, user.getMythicalCreature());
                break;
            case 6:
                return;
            default:
                System.out.println(RED + "Invalid choice. Please try again." + RESET);
        }
    }

    private static void sellCharacter(User user, Character character) {
        String RESET = "\u001B[0m";
        String CYAN = "\u001B[36m";
        String YELLOW = "\u001B[33m";
        String RED = "\u001B[31m";
        if (character != null) {
            double sellPrice = character.getPrice() * 0.9; // Calculate sell price (90% of current value)
            user.addGoldCoins((int) sellPrice); // Add sell price to user's gold coins
            user.removeCharacter(character); // Remove the character from user's inventory
            System.out
                    .println(CYAN + "Sold " + character.getName() + " for " + (int) sellPrice + " gold coins." + RESET);
            System.out.println(YELLOW + "Gold left: " + user.getGoldCoins() + RESET);
        } else {
            System.out.println(RED + "No character to sell." + RESET);
        }
    }

    private static void buyArmy(User user) {
        String RESET = "\u001B[0m";
        String GREEN = "\u001B[32m";
        String YELLOW = "\u001B[33m";
        String RED = "\u001B[31m";
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n------------------------------ Army Shop ------------------------------\n");

        while (true) {
            if (user.hasCharacterOfCategory(Archer.class) && user.hasCharacterOfCategory(Knight.class)
                    && user.hasCharacterOfCategory(Mage.class) && user.hasCharacterOfCategory(Healer.class)
                    && user.hasCharacterOfCategory(MythicalCreature.class)) {
                // If the user already has characters in each category, prompt them to sell
                // before buying more
                System.out.println(RED + "You need to sell your existing characters before buying new ones." + RESET);
                System.out.println();
                System.out.println(user.getArmyComposition());
                System.out.println();
                System.out.println("Redirecting to sell option...");
                loading();
                sellItems(user);
                return;
            }
            System.out.println();
            System.out.println("Welcome to the Army Shop!");
            System.out.println();

            Class<? extends Character> category = null;

            System.out.println(GREEN + "Choose a character category\n");
            System.out.println("1. Archer");
            System.out.println("2. Knight");
            System.out.println("3. Mage");
            System.out.println("4. Healer");
            System.out.println("5. Mythical Creature");
            System.out.println("6. Back to Shop" + RESET);
            System.out.println();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.println();

            if (choice == 6) {
                return; // User chose to go back to the shop
            }

            switch (choice) {
                case 1:
                    // check if he has archer
                    if (user.hasCharacterOfCategory(Archer.class)) {
                        System.out.println(RED + "You already have an archer.\n" + RESET);
                        continue; // Restart the loop
                    } else {
                        category = Archer.class;
                    }
                    break;
                case 2:
                    // check if he has knight
                    if (user.hasCharacterOfCategory(Knight.class)) {
                        System.out.println(RED + "You already have a knight.\n" + RESET);
                        continue; // Restart the loop
                    } else {
                        category = Knight.class;
                    }
                    break;
                case 3:
                    // check if he has mage
                    if (user.hasCharacterOfCategory(Mage.class)) {
                        System.out.println(RED + "You already have a mage.\n" + RESET);
                        continue; // Restart the loop
                    } else {
                        category = Mage.class;
                    }
                    break;
                case 4:
                    // check if he has healer
                    if (user.hasCharacterOfCategory(Healer.class)) {
                        System.out.println(RED + "You already have a healer.\n" + RESET);
                        continue; // Restart the loop
                    } else {
                        category = Healer.class;
                    }
                    break;
                case 5:
                    // check if he has mythical creature
                    if (user.hasCharacterOfCategory(MythicalCreature.class)) {
                        System.out.println(RED + "You already have a mythical creature.\n" + RESET);
                        continue; // Restart the loop
                    } else {
                        category = MythicalCreature.class;
                    }
                    break;
                default:
                    System.out.println("Invalid choice.");
                    continue; // Restart the loop
            }

            // Check if the user already has a character of this category
            if (user.hasCharacterOfCategory(category)) {
                System.out.println(RED + "You already have a character of this category.\n" + RESET);
                continue; // Restart the loop
            }

            Character character = createCharacter(category, scanner);
            if (character != null) {
                user.subtractGoldCoins(character.getPrice());
                user.addCharacter(character);
                System.out.println("Character purchased successfully!");
                System.out.println(YELLOW + "Remaining gold coins: " + user.getGoldCoins() + RESET);
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }

    private static Character createCharacter(Class<? extends Character> category, Scanner scanner) {
        String RESET = "\u001B[0m";
        String BLUE = "\u001B[34m";

        switch (category.getSimpleName()) {
            case "Archer":
                System.out.println(BLUE + "Choose an Archer\n");
                System.out.println("1. Shooter - 80 gc");
                System.out.println("2. Ranger - 115 gc");
                System.out.println("3. Sunfire - 160 gc");
                System.out.println("4. Zing - 200 gc");
                System.out.println("5. Sagittarius - 230 gc");
                System.out.println("6. Back to Shop");
                System.out.println("\n" + RESET);
                break;

            case "Knight":
                System.out.println(BLUE + "Choose a Knight\n");
                System.out.println("1. Squire - 85 gc");
                System.out.println("2. Cavalier - 110 gc");
                System.out.println("3. Templar - 155 gc");
                System.out.println("4. Zoro - 180 gc");
                System.out.println("5. Swiftblade - 250 gc");
                System.out.println("\n" + RESET);
                break;

            case "Mage":
                System.out.println(BLUE + "Choose a Mage\n");
                System.out.println("1. Warlock - 100 gc");
                System.out.println("2. Illusionist - 120 gc");
                System.out.println("3. Enchanter - 160 gc");
                System.out.println("4. Conjurer - 195 gc");
                System.out.println("5. Eldritch - 270 gc");
                System.out.println("6. Back to Shop");
                System.out.println("\n" + RESET);
                break;

            case "Healer":
                System.out.println(BLUE + "Choose a Healer\n");
                System.out.println("1. Soother - 95 gc");
                System.out.println("2. Medic - 125 gc");
                System.out.println("3. Alchemist - 150 gc");
                System.out.println("4. Saint - 200 gc");
                System.out.println("5. Lightbringer - 260 gc");
                System.out.println("6. Back to Shop");
                System.out.println("\n" + RESET);
                break;

            case "MythicalCreature":
                System.out.println(BLUE + "Choose a Mythical Creature\n");
                System.out.println("1. Dragon - 120 gc");
                System.out.println("2. Basilisk - 165 gc");
                System.out.println("3. Hydra - 205 gc");
                System.out.println("4. Pegasus - 340 gc");
                System.out.println("5. Phoenix - 275 gc");
                System.out.println("6. Back to Shop");
                System.out.println("\n" + RESET);
                break;

            default:
                return null;
        }

        int characterChoice;
        while (true) {
            System.out.print("Enter your choice: ");
            characterChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.println();
            if (characterChoice >= 1 && characterChoice <= 6) {
                break;
            } else {
                System.out.println("Invalid choice\n");
            }
        }

        switch (category.getSimpleName()) {
            case "Archer":
                switch (characterChoice) {
                    case 1:
                        return new Shooter();
                    case 2:
                        return new Ranger();
                    case 3:
                        return new Sunfire();
                    case 4:
                        return new Zing();
                    case 5:
                        return new Saggitarius();
                    default:
                        return null;
                }
            case "Knight":
                switch (characterChoice) {
                    case 1:
                        return new Squire();
                    case 2:
                        return new Cavalier();
                    case 3:
                        return new Templar();
                    case 4:
                        return new Zoro();
                    case 5:
                        return new Swiftblade();
                    default:
                        return null;
                }
            case "Mage":
                switch (characterChoice) {
                    case 1:
                        return new Warlock();
                    case 2:
                        return new Illusionist();
                    case 3:
                        return new Enchanter();
                    case 4:
                        return new Conjurer();
                    case 5:
                        return new Eldritch();
                    default:
                        return null;
                }
            case "Healer":
                switch (characterChoice) {
                    case 1:
                        return new Soother();
                    case 2:
                        return new Medic();
                    case 3:
                        return new Alchemist();
                    case 4:
                        return new Saint();
                    case 5:
                        return new Lightbringer();
                    default:
                        return null;
                }
            case "MythicalCreature":
                switch (characterChoice) {
                    case 1:
                        return new Dragon();
                    case 2:
                        return new Basilisk();
                    case 3:
                        return new Hydra();
                    case 4:
                        return new Pegasus();
                    case 5:
                        return new Phoenix();
                    default:
                        return null;
                }
            default:
                return null;
        }
    }
}