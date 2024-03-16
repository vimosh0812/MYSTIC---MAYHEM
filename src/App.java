import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class App {

    private static final List<User> users = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static int userID = 1000;

    public static void main(String[] args) {
        while (true) {
            System.out.println("Welcome to the Game");
            System.out.println("--------------------------");
            System.out.println("Main Menu:");
            System.out.println();
            System.out.println("1. Sign Up");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            // System.out.println("4. Display Users");
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
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                // case 4:
                //     displayUsers();
                //     break;
                default:
                    System.out.println();
                    System.out.println("Invalid choice. Please try again.");
                    System.out.println();
            }
        }
    }

    private static void signUp() {
        System.out.println();
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        // Check if the username already exists
        if (userExists(username)) {
            System.out.println("Username already exists. Please choose a different username.");
            System.out.println();
            return;
        }

        System.out.print("Enter player name: ");
        String playerName = scanner.nextLine();

        User newUser = new User(username, playerName, userID);
        users.add(newUser);
        System.out.println();
        System.out.println("Account created successfully.");
        System.out.println("Your user ID is: " + userID);
        // Award 500 gold coins to the new user
        System.out.println("You have been awarded 500 gold coins.");
        System.out.println();
        newUser.addGoldCoins(500);
        System.out.println("Now, let's buy an army for your user.");
        System.out.println();
        openShop(newUser);
        //displayUsers(); // Display users after sign up
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
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                System.out.println("Welcome, " + user.getPlayerName() + "!");
                while (true) {
                    System.out.println();
                    System.out.println("1. Play Battle");
                    System.out.println("2. Change Player Name");
                    System.out.println("3. Shop");
                    System.out.println("4. Back to Menu");
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
                            return;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                }
            }
        }
        System.out.println("Username not found.");
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
            } else {
                System.out.println("No more opponents available.");
                return;
            }
        }
    }

    // private static void displayUsers() {
    //     System.out.println("List of Users:");
    //     for (User user : users) {
    //         System.out.println("Username: " + user.getUsername());
    //         System.out.println("Player Name: " + user.getPlayerName());
    //         System.out.println("User ID: " + user.getUserID());
    //         System.out.println("Gold Coins: " + user.getGoldCoins());
    //         System.out.println("Experience Points (XP): " + user.getXP());
    //         System.out.println("--------------------------");
    //     }
    // }

    private static void playBattle(User user, User opponent) {
        System.out.println("Starting battle in...");
        countdown();
        System.out.println(user.getPlayerName() + " vs " + opponent.getPlayerName());
        // Simulate battle result
        Random random = new Random();
        boolean userWins = random.nextBoolean(); // Simulate win/loss randomly
        if (userWins) {
            // Award 10% of opponent's gold coins to the winner
            int coinsWon = (int) (opponent.getGoldCoins() * 0.1);
            user.addGoldCoins(coinsWon);
            opponent.subtractGoldCoins(coinsWon);
            // Increase winner's XP by 1
            user.increaseXP(1);
            System.out.println("You won the battle! You earned " + coinsWon + " gold coins and gained 1 XP.");
        } else {
            // Increase opponent's XP by 1
            opponent.increaseXP(1);
            System.out.println("You lost the battle! Better luck next time.");
        }
    }

    private static void changePlayerName(User user) {
        System.out.print("Enter new player name: ");
        String newPlayerName = scanner.nextLine();
        user.setPlayerName(newPlayerName);
        System.out.println("Player name changed successfully.");
        //displayUsers(); // Display users after name change
    }

    private static User getUserByID(int userID) {
        for (User user : users) {
            if (user.getUserID() == userID) {
                return user;
            }
        }
        return null; // Return null if user not found
    }

    private static void openShop(User user) {
        System.out.println("Welcome to the Shop!");
        System.out.println("--------------------------");
        System.out.println("1. Buy Army");
        System.out.println("2. Buy Equipments");
        // System.out.println("3. Back to Menu");
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
            // case 3:
            //     return;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void buyArmy(User user) {
        // Implementation of buyArmy
        System.out.println("You have successfully bought an army!");
        System.out.println();
    }

    private static void buyEquipments(User user) {
        // Implementation of buyEquipments
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

    private static class User {
        private String username;
        private String playerName;
        private int userID;
        private int goldCoins;
        private int XP;

        public User(String username, String playerName, int userID) {
            this.username = username;
            this.playerName = playerName;
            this.userID = userID;
            this.goldCoins = 0; // Initialize with 0 gold coins
            this.XP = 0; // Initialize with 0 XP
        }

        public String getUsername() {
            return username;
        }

        public String getPlayerName() {
            return playerName;
        }

        public void setPlayerName(String playerName) {
            this.playerName = playerName;
        }

        public int getUserID() {
            return userID;
        }

        public int getGoldCoins() {
            return goldCoins;
        }

        public void addGoldCoins(int amount) {
            goldCoins += amount;
        }

        public void subtractGoldCoins(int amount) {
            goldCoins -= amount;
        }

        public int getXP() {
            return XP;
        }

        public void increaseXP(int amount) {
            XP += amount;
        }
    }
}
