public class Mage extends Character {
    static boolean mageInstance = false;

    public Mage(String name, int price, Double attack, Double defence, Double health, Double speed, String category) {
        super(name, price, attack, defence, health, speed,category);
    }
}

class Warlock extends Mage {
    public Warlock() {
        
        super("Warlock", 100, 12.0, 7.0, 10.0, 12.0,"Marshlanders");
    }
}

class Illusionist extends Mage {
    public Illusionist() {
        super("Illusionist", 120, 13.0, 8.0, 12.0, 14.0,"Mystics");
    }
}

class Enchanter extends Mage {
    public Enchanter() {
        super("Enchanter", 160, 16.0, 10.0, 13.0, 16.0,"Highlanders");
    }
}

class Conjurer extends Mage {
    public Conjurer() {
        super("Conjurer", 195, 18.0, 15.0, 14.0, 12.0,"Highlanders");
    }
}

class Eldritch extends Mage {
    public Eldritch() {
        super("Eldritch", 270, 19.0, 17.0, 18.0, 14.0,"Mystics");
    }
}