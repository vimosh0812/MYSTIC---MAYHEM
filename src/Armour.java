public class Armour extends Equipment {
    Armour(String name, int price, int attack, int defence, int health, int speed) {
        super(name, price, attack, defence, health, speed);
    }
}

class Chainmail extends Armour {
    Chainmail() {
        super("Chainmail", 70, 0, 1, 0, -1);
    }
}

class Regalia extends Armour {
    Regalia() {
        super("Regalia", 105, 0, 1, 0, 0);
    }
}

class Fleece extends Armour {
    Fleece() {
        super("Fleece", 150, 0, 2, 1, 1);
    }
}
