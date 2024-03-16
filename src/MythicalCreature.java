public class MythicalCreature extends Character {
    static boolean mythicalCreatureInstance = false;

    public MythicalCreature(String name, int price, Double attack, Double defence, Double health, Double speed, String category) {
        super(name, price, attack, defence, health, speed, category);
    }
}

class Dragon extends MythicalCreature {
    public Dragon() {
        super("Dragon", 120, 12.0, 14.0, 15.0, 8.0,"Sunchildren");
    }
}

class Basilisk extends MythicalCreature {
    public Basilisk() {
        super("Basilisk", 165, 15.0, 11.0, 10.0, 12.0,"Marshlanders");
    }
}

class Hydra extends MythicalCreature {
    public Hydra() {
        super("Hydra", 205, 12.0, 16.0, 15.0, 11.0,"Marshlanders");
    }
}

class Phoenix extends MythicalCreature {
    public Phoenix() {
        super("Phoenix", 275, 17.0, 13.0, 17.0, 19.0,"Sunchildren");
    }
}

class Pegasus extends MythicalCreature {
    public Pegasus() {
        super("Pegasus", 340, 14.0, 18.0, 20.0, 20.0,"Mystics");
    }
}