// public class Archer extends Character {

//     public Archer(String name, int price, Double attack, Double defence, Double health, Double speed) {
//         super(name, price, attack, defence, health, speed);
//     }
// }

// class Shooter extends Archer {
//     public Shooter() {
//         super("Shooter", 80, 11.0, 4.0, 6.0, 9.0);
//     }
    
// }

// class Saggitarius extends Archer {
//     public Saggitarius() {
//         super("Saggitarius", 230, 18.0, 7.0, 12.0, 17.0);
//     }
// }

// class Ranger extends Archer {
//     public Ranger() {
//         super("Ranger", 115, 14.0, 5.0, 8.0, 10.0);
//     }
// }

// class Sunfire extends Archer {
//     public Sunfire() {
//         super("Sunfire", 160, 15.0, 5.0, 7.0, 14.0);
//     }
// }

// class Zing extends Archer {
//     public Zing() {
//         super("Zing", 200, 16.0, 9.0, 11.0, 14.0);
//     }
// }

public class Archer extends Character {

    public Archer(String name, int price, Double attack, Double defence, Double health, Double speed, String category) {
        super(name, price, attack, defence, health, speed,category);
    }
}

class Shooter extends Archer {
    public Shooter() {
        super("Shooter", 80, 11.0, 4.0, 6.0, 9.0, "Highlanders");
    }
    
}

class Saggitarius extends Archer {
    public Saggitarius() {
        super("Saggitarius", 230, 18.0, 7.0, 12.0, 17.0,"Mystics");
    }
}

class Ranger extends Archer {
    public Ranger() {
        super("Ranger", 115, 14.0, 5.0, 8.0, 10.0,"Highlanders");
    }
}

class Sunfire extends Archer {
    public Sunfire() {
        super("Sunfire", 160, 15.0, 5.0, 7.0, 14.0,"Sunchildren");
    }
}

class Zing extends Archer {
    public Zing() {
        super("Zing", 200, 16.0, 9.0, 11.0, 14.0,"Sunchildren");
    }
}