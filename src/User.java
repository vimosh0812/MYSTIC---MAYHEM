import java.util.List;

public class User {
    ;
    private String username;
    private String playerName;
    private int userID;
    private int goldCoins = 500;
    private int XP;
    private List<Character> army;
    private int cartTotal = 0;
    private Archer archer;
    private Knight knight;
    private Mage mage;
    private MythicalCreature mythicalCreature;
    private Healer healer;
    private Artefact artefact;
    private Character character;
    //new 
    private String Homeground;

    private playground playground;
    public Object getArcher;

    User(String username, String playerName, int userID) {
        this.username = username;
        this.playerName = playerName;
        this.userID = userID;
        this.goldCoins = 500; // Initialize with 0 gold coins
        this.XP = 1; // Initialize with 0 XP
    }

    public void addToArmy(Character character) {
        army.add(character);
    }

    public List<Character> getArmy() {
        return army;
    }

    public void createArmy(Archer archer, Knight knight, Mage mage, Healer healer, MythicalCreature mythicalCreature ) {
        this.archer = archer;
        this.knight = knight;
        this.mage = mage;
        this.healer = healer;
        this.mythicalCreature = mythicalCreature;

    }
    public void setGoldcoins(int goldCoins) 
    {
        this.goldCoins = goldCoins;
    }

    public void addToCart(int amount) {
        this.cartTotal += amount;
    }

    // Getter for cart total
    public int getCartTotal() {
        return cartTotal;
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

    public void addGoldCoins( int amount) {
        goldCoins += amount;
    
    }

    public void addGoldCoins( double amount) {
        // double goldCoins=(double) goldCoins;
        goldCoins += amount;
        if(goldCoins<=0){
            goldCoins=0;
        }
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
    public Archer getArcher() {
        return archer;
    }

    // public int Archerhealth(){
    //     return archer.getHealth();
    // }
    
    public void setArcher(Archer archer) {
        this.archer = archer;
    }

    public Knight getKnight() {
        return this.knight;
    }

    public void setKnight(Knight knight) {
        this.knight = knight;
    }

    public Mage getMage() {
        return this.mage;
    }

    public void setMage(Mage mage) {
        this.mage = mage;
    }

    public Healer getHealer() {
        return this.healer;
    }

    public void setHealer(Healer healer) {
        this.healer = healer;
    }

    public MythicalCreature getMythicalCreature() {
        return this.mythicalCreature;
    }

    public void setMythicalCreature(MythicalCreature mythicalCreature) {
        this.mythicalCreature = mythicalCreature;
    }

    public playground getPlayground() {
        return this.playground;
    }

    public void setHomeland(playground playground) {
        this.playground  = playground;
    }

    // public void buyCharacter(Character character) {
    //     if (this.gold >= character.getPrice()) {
    //         this.gold -= character.getPrice();
    //         addCharacter(character);
    //     } else {
    //         System.out.println("Not enough gold");
    //     }
    // }

    public Artefact getArtefact() {
        return this.artefact;
    }

    public void setArtefact(Artefact artefact) {
        this.artefact = artefact;
    }

    public boolean hasCharacterOfCategory(Class<? extends Character> category) {
        if (category.equals(Archer.class)) {
            return this.getArcher() != null;
        } else if (category.equals(Knight.class)) {
            return this.getKnight() != null;
        } else if (category.equals(Mage.class)) {
            return this.getMage() != null;
        } else if (category.equals(Healer.class)) {
            return this.getHealer() != null;
        } else if (category.equals(MythicalCreature.class)) {
            return this.getMythicalCreature() != null;
        } else {
            return false;
        }
    }

    public void removeCharacter(Character character) {
        if (character instanceof Archer) {
            this.setArcher(null);
        } else if (character instanceof Knight) {
            this.setKnight(null);
        } else if (character instanceof Mage) {
            this.setMage(null);
        } else if (character instanceof Healer) {
            this.setHealer(null);
        } else if (character instanceof MythicalCreature) {
            this.setMythicalCreature(null);
        }
    }

    public String getArmyComposition() {
        
        StringBuilder armyComposition = new StringBuilder();

        if (this.getArcher() != null) {
            armyComposition.append("- Archer: ").append(this.getArcher().getName());
            if (this.getArcher().getArmour() != null) {
                armyComposition.append(" + ").append(this.getArcher().getArmour().getName());
            }
            if (this.getArcher().getArtefact() != null) {
                armyComposition.append(" + ").append(this.getArcher().getArtefact().getName());
            }
            armyComposition.append("\n");
        }

        if (this.getArcher() == null) {
            armyComposition.append("- Archer: You don't have selected any type of archers yet.");
            armyComposition.append("\n");
        }

        if (this.getKnight() != null) {
            armyComposition.append("- Knight: ").append(this.getKnight().getName());
            if (this.getKnight().getArmour() != null) {
                armyComposition.append(" + ").append(this.getKnight().getArmour().getName());
            }
            if (this.getKnight().getArtefact() != null) {
                armyComposition.append(" + ").append(this.getKnight().getArtefact().getName());
            }
            armyComposition.append("\n");
        }
        if (this.getKnight() == null) {
            armyComposition.append("- Knight: You don't have selected any type of knights yet");
            armyComposition.append("\n");
        }

        if (this.getMage() != null) {
            armyComposition.append("- Mage: ").append(this.getMage().getName());
            if (this.getMage().getArmour() != null) {
                armyComposition.append(" + ").append(this.getMage().getArmour().getName());
            }
            if (this.getMage().getArtefact() != null) {
                armyComposition.append(" + ").append(this.getMage().getArtefact().getName());
            }
            armyComposition.append("\n");
        }

        if (this.getMage() == null) {
            armyComposition.append("- Mage: You don't have selected any type of mages yet");
            armyComposition.append("\n");
        }
        if (this.getHealer() != null) {
            armyComposition.append("- Healer: ").append(this.getHealer().getName());
            if (this.getHealer().getArmour() != null) {
                armyComposition.append(" + ").append(this.getHealer().getArmour().getName());
            }
            if (this.getHealer().getArtefact() != null) {
                armyComposition.append(" + ").append(this.getHealer().getArtefact().getName());
            }
            armyComposition.append("\n");
        }
        if (this.getHealer() == null) {
            armyComposition.append("- Healer: You don't have selected any type of healers yet");
            armyComposition.append("\n");
        }

        if (this.getMythicalCreature() != null) {
            armyComposition.append("- Mythical Creature: ").append(this.getMythicalCreature().getName());
            if (this.getMythicalCreature().getArmour() != null) {
                armyComposition.append(" + ").append(this.getMythicalCreature().getArmour().getName());
            }
            if (this.getMythicalCreature().getArtefact() != null) {
                armyComposition.append(" + ").append(this.getMythicalCreature().getArtefact().getName());
            }
            armyComposition.append("\n");
        }

        if (this.getMythicalCreature() == null) {
            armyComposition.append("- Mythical Creature: You don't have selected any type of mythical creatures yet");
            armyComposition.append("\n");
        }
        // ---------------------------
        if (this.getArcher() == null || this.getKnight() == null || this.getHealer() == null || this.getMage() == null || this.getMythicalCreature() == null) {
            armyComposition.append("\n!! Go to shop & buy the suitable character");
            armyComposition.append("\n");
        }
        System.out.println("\n- Home Ground: " + this.getPlayground().getName()+"\n");
        return armyComposition.toString();
    }

    public void addCharacter(Character character) {
        if (character instanceof Archer) {
            this.setArcher((Archer) character);
        } else if (character instanceof Knight) {
            this.setKnight((Knight) character);
        } else if (character instanceof Mage) {
            this.setMage((Mage) character);
        } else if (character instanceof Healer) {
            this.setHealer((Healer) character);
        } else if (character instanceof MythicalCreature) {
            this.setMythicalCreature((MythicalCreature) character);
        }
    }

    // new
    // public void setHomeground(String Homeground) {
    //     this.Homeground = Homeground;
    // }

    // public String getHomeground() {
    //     return Homeground;
    public Character getCharacter() {
        return this.character;
    }
    
    public void setXP(int XP) {
        this.XP = XP;
    }

}