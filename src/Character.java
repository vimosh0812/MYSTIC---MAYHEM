public abstract class Character {

    String name,category;
    double attack,defence,health,speed;
    boolean check;
    int price;

    // private Archer archer;
    // private Knight knight;
    // private Mage mage;
    // private MythicalCreature mythicalCreature;
    // private Healer healer;

    Armour armour;
    Artefact artefact;
    String RED = "\033[0;31m";
    String RESET = "\033[0m";   
    String GREEN = "\033[0;32m";
    String YELLOW = "\033[0;33m";
    String BLUE = "\033[0;36m";
    

    Character(String name, int price, double attack, double defence, double health, double speed,String category) {
        this.name = name;
        this.price = price;
        this.attack = attack;
        this.defence = defence;
        this.health = health;
        this.speed = speed;
        this.category = category;
        
    }
    public void check() {
        check = true;
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }

    public double getAttack() {
        return this.attack;
    }

    public double getDefence() {
        return this.defence;
    }

    public double getHealth() {
        if(isDead()){
            return 0.0;
        }
        else{
        return this.health;
        }
    }

    public double getSpeed() {
        return this.speed;
    }

    public String getCategory() {
        return this.category;
    }

    public Armour getArmour() {
        return this.armour;
    }

    public void setArmour(Armour armour) {
        if (this.armour != null) {
            this.defence -= this.armour.getDefence();
            this.health -= this.armour.getHealth();
            this.speed -= this.armour.getSpeed();

            this.price -= this.armour.getPrice() * 20/100;
            this.armour = null;
        }
        
        this.armour = armour;
        this.defence += armour.getDefence();
        this.health += armour.getHealth();
        this.speed += armour.getSpeed();

        this.price += armour.getPrice() * 20/100;
    }


    public Artefact getArtefact() {
        return this.artefact;
    }

    public void setArtefact(Artefact artefact) {
        if (this.artefact != null) {
            this.attack -= this.artefact.getAttack();
            this.defence -= this.artefact.getDefence();
            this.health -= this.artefact.getHealth();
            this.speed -= this.artefact.getSpeed();

            this.price -= this.artefact.getPrice() * 20/100;
            this.artefact = null;
        }

        this.artefact = artefact;
        this.attack += artefact.getAttack();
        this.defence += artefact.getDefence();
        this.health += artefact.getHealth();
        this.speed += artefact.getSpeed();

        this.price += artefact.getPrice() * 20/100;
    }



    public void getdamage(double damage){
        // if (this.health > 0.0){
        //     this.health -= damage;
        // }
        this.health -= damage;
        
        if (this.health <= 0.0) {
            this.health = 0.0;
            System.out.println(RED+this.name + " died"+RESET);
        }
        
    }

    public void increasehealth(double health){
        this.health += health;
        this.health=roundo(this.health);
        System.out.println(YELLOW+this.name + " got healed to health "+this.health+RESET);
    }
    public boolean isDead(){
        //System.out.println(this.name + " helath after died "+this.health);
        return this.health<= 0.0;
        
    }

    public double setHealth(double health) {
        return this.health = health;
    }
    public void increaseDefence(double defence){
        this.defence += defence;
        this.defence=roundo(this.defence);
        //System.out.println(GREEN+this.name + " got buffed to defence "+this.defence+RESET);
    }
    public void increaseAttack(double attack){
        this.attack += attack;
        this.attack=roundo(this.attack);
        //System.out.println(GREEN+this.name + " got buffed to attack "+this.attack+RESET);
    }
    public void increaseSpeed(double speed){
        this.speed += speed;
        //System.out.println(GREEN+this.name + " got buffed to speed "+this.speed+RESET);
    }
    public void decreaseDefence(double defence){
        this.defence -= defence;
        //System.out.println(BLUE+this.name + " got debuffed to defence "+this.defence+RESET);
    }
    public void decreaseAttack(double attack){
        this.attack -= attack;
        // System.out.println(BLUE+this.name + " got debuffed to attack "+this.attack+RESET);
    }
    public void decreaseSpeed(double speed){
        this.speed -= speed;
        //System.out.println(BLUE+this.name + " got debuffed to speed "+this.speed+RESET);
    }
    public void decreaseHealth(double health){
        this.health -= health;
        if (this.health < 0){
            this.health =0.0;
        } 
        //System.out.println(BLUE+this.name + " got debuffed to health "+this.health+RESET);
    }

    public double roundo(double dbl) {
        return Math.round(dbl * 10.0) / 10.0;
    }
    // public Archer getArcher() {
    //     return archer;
    // }
    // public void setArcher(Archer archer) {
    //     this.archer = archer;
    // }
    // public Knight getKnight() {
    //     return knight;
    // }
    // public void setKnight(Knight knight) {
    //     this.knight = knight;
    // }
    // public Mage getMage() {
    //     return mage;
    // }
    // public void setMage(Mage mage) {
    //     this.mage = mage;
    // }
    // public MythicalCreature getMythicalCreature() {
    //     return mythicalCreature;
    // }
    // public void setMythicalCreature(MythicalCreature mythicalCreature) {
    //     this.mythicalCreature = mythicalCreature;
    // }
    // public Healer getHealer() {
    //     return healer;
    // }
    // public void setHealer(Healer healer) {
    //     this.healer = healer;
    // }

    
    
}