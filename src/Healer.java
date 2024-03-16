public class Healer extends Character {
    static boolean healerInstance = false;

    public Healer(String name, int price, Double attack, Double defence, Double health, Double speed, String category ) {
        super(name, price, attack, defence, health, speed, category);
    }
}

class Soother extends Healer {
    public Soother() {
        super("Soother", 95, 10.0, 8.0, 9.0, 6.0,"Sunchildren");
    }
}

class Medic extends Healer {
    public Medic() {
        super("Medic", 125, 12.0, 9.0, 10.0, 7.0,"Highlanders");
    }
}

class Alchemist extends Healer {
    public Alchemist() {
        super("Alchemist", 150, 13.0, 13.0, 13.0, 13.0,"Marshlanders");
    }
}

class Saint extends Healer {
    public Saint() {
        super("Saint", 200, 16.0, 14.0, 17.0, 9.0,"Mystics");
    }
}

class Lightbringer extends Healer {
    public Lightbringer() {
        super("Lightbringer", 260, 17.0, 15.0, 19.0, 12.0,"Sunchildren");
    }
}