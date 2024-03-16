public class Knight extends Character {

    public Knight(String name, int price, Double attack, Double defence, Double health, Double speed, String category) {
        super(name, price, attack, defence, health, speed,category);
    }
}

class Squire extends Knight {
    public Squire() {
        super("Squire", 85, 8.0, 9.0, 7.0, 8.0,"Marshlanders");
    }
}

class Cavalier extends Knight {
    public Cavalier() {
        super("Cavalier", 110, 10.0, 12.0, 7.0, 10.0,"Highlanders");
    }
}

class Templar extends Knight {
    public Templar() {
        super("Templar", 155, 14.0, 16.0, 12.0, 12.0,"Sunchildren");
    }
}

class Zoro extends Knight {
    public Zoro() {
        super("Zoro", 180, 17.0, 16.0, 13.0, 14.0,"Highlanders");

    }
}

class Swiftblade extends Knight {
    Swiftblade() {
        super("Swiftblade", 250, 18.0, 20.0, 17.0, 13.0,"Marshlanders");
    }
}