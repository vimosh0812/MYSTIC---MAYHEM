public class Equipment {
    private String name;
    private int price, health, attack, defence,speed;

    public Equipment(String name, int price, int health, int attack, int defence, int speed) {
        this.name = name;
        this.price = price;
        this.health = health;
        this.attack = attack;
        this.defence = defence;
        this.speed = speed;
    }

    // Getters
    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }

    public int getHealth() {
        return this.health;
    }

    public int getAttack() {
        return this.attack;
    }

    public int getDefence() {
        return this.defence;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
