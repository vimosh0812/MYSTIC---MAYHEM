public class Artefact extends Equipment {
    Artefact(String name, int price, int attack, int defence, int health, int speed) {
        super(name, price, attack, defence, health, speed);
    }
}

class Excaliber extends Artefact {
    Excaliber() {
        super("Excaliber", 150, 2, 0, 0, 0);
    }
}

class Amulet extends Artefact {
    Amulet() {
        super("Amulet", 200, 1, -1, 1, 1);
    }
}

class Crystal extends Artefact {
    Crystal() {
        super("Crystal", 210, 2, 1, -1, -1);
    }
}