public class playground {

    private String name;

    public playground(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
}
class Hillcrest extends playground {
    Hillcrest() {
        super("Hillcrest");
    }
}
class Marshland extends playground {
    Marshland() {
        super("Marshland");
    }
}
class Desert extends playground {
    Desert() {
        super("Desert");
    }
}
class Arcane extends playground {
    Arcane() {
        super("Arcane");
    }
}
