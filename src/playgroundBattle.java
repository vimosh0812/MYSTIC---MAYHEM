import java.util.ArrayList;

public class playgroundBattle {
    public static double buffcharacter(String playground, Archer archer , Boolean spotter) {
        ArrayList<String> Highlanders = new ArrayList<String>();
        ArrayList<String> Marshlanders = new ArrayList<String>();
        ArrayList<String> Sunchildren = new ArrayList<String>();
        ArrayList<String> Mystics = new ArrayList<String>();

        Highlanders.add("Shooter");
        Highlanders.add("Ranger");

        

        Sunchildren.add("Sunfire"); 
        Sunchildren.add("Zing"); 
        

        Mystics.add("Saggitarius");
        

        if (spotter){
            // System.err.println("working-a1");
            if (playground == "Hillcrest"){
                // System.out.println("i am in hillcrest");
                if (Highlanders.contains(archer.getName())){
                    archer.increaseAttack(1.0);;
                    archer.increaseDefence(1.0);
                    return 0;
                }
                // if (Marshlanders.contains(archer.getName())){
                //     archer.decreaseSpeed(1.0);
                //     return 0;
                    
                // }
                if (Sunchildren.contains(archer.getName())){
                    archer.decreaseSpeed(1.0);
                    return 0;
                }
            }
            if (playground == "Marshland"){
                // System.out.println("i am in marshland");
                // if (Marshlanders.contains(usercharacter.getName())){
                //     usercharacter.increaseDefence(2.0);
                //     return 0;
                    
                }
                if (Sunchildren.contains(archer.getName())){
                    archer.decreaseAttack(1.0);
                    return 0;
    
                }
                if (Mystics.contains(archer.getName())){
                    archer.decreaseSpeed(1.0);
                    return 0;
                }
            }
            if (playground == "Desert"){
                // System.out.println("i am in desert");
                // if (Marshlanders.contains(usercharacter.getName())){
                //     usercharacter.decreaseHealth(1.0);
                //     return 0;
                // }
                if (Sunchildren.contains(archer.getName())){
                    archer.increaseAttack(1.0);;
                    return 0;
    
                }
            }
            if (playground == "Arcane"){
                // System.out.println("i am in arcane");
                if (Mystics.contains(archer.getName())){
                    archer.increaseAttack(2.0);;
                    return 0;
                }
            }
        else{
            // System.err.println("workinga-2");
            if (playground == "Hillcrest"){
                
                
                if (Highlanders.contains(archer.getName())){
                    System.out.println();
                    System.out.println("EXTRA TURN");
                    System.out.println();
                    double damage = 0.5*(0.2*archer.attack);
                    damage=playBattle.round(damage);
                    // System.out.println("double damage");
                        //opponentcharacter.defence -= damage;
                    return damage;
                }
                
                // else{
                //     double health = 0.1*(0.2*archer.attack);
                //     //String formattedString = String.format("%.1f", health);

                //     // Parse the formatted string back to double
                //     //health= Double.parseDouble(formattedString);
                //     // if (Highlanders.contains(usercharacter.getName())){
                        
                //     // }
                //     return health;
                // }
                
                
            }
            if (playground == "Arcane"){
                
                if (Mystics.contains(archer.getName())){
                    System.out.println();
                    System.out.println("HEALS AFTER IT'S TURN");
                    System.out.println();
                    double hel=0.1*archer.getHealth();
                    hel=playBattle.round(hel);
                    archer.increasehealth(hel);
                    return 0;
                }
            }
        }
        return 0;
    }

    //-------------------------------------------------------------------------------------------------------------------------

    public static double buffcharacter(String playground, Knight knight , Boolean spotter) {
        ArrayList<String> Highlanders = new ArrayList<String>();
        ArrayList<String> Marshlanders = new ArrayList<String>();
        ArrayList<String> Sunchildren = new ArrayList<String>();
        ArrayList<String> Mystics = new ArrayList<String>();

        
        Highlanders.add("Cavalier");
        Highlanders.add("Zoro");
        

        Marshlanders.add("Squire");
        Marshlanders.add("Swiftblade");
        

        
        Sunchildren.add("Templar"); 
        

        if (spotter){
            // System.err.println("workingk-1");
            if (playground == "Hillcrest"){
                // System.out.println("i am in hillcrest");
                if (Highlanders.contains(knight.getName())){
                    knight.increaseAttack(1.0);;
                    knight.increaseDefence(1.0);
                    return 0;
                }
                if (Marshlanders.contains(knight.getName())){
                    knight.decreaseSpeed(1.0);
                    return 0;
                    
                }
                if (Sunchildren.contains(knight.getName())){
                    knight.decreaseSpeed(1.0);
                    return 0;
                }
            }
            if (playground == "Marshland"){
                // System.out.println("i am in marshland");
                if (Marshlanders.contains(knight.getName())){
                    knight.increaseDefence(2.0);
                    return 0;
                    
                }
                if (Sunchildren.contains(knight.getName())){
                    knight.decreaseAttack(1.0);
                    return 0;
    
                }
                // if (Mystics.contains(knight.getName())){
                //     knight.decreaseSpeed(1.0);
                //     return 0;
                // }
            }
            if (playground == "Desert"){
                // System.out.println("i am in desert");
                if (Marshlanders.contains(knight.getName())){
                    knight.decreaseHealth(1.0);
                    return 0;
                }
                if (Sunchildren.contains(knight.getName())){
                    knight.increaseAttack(1.0);;
                    return 0;
    
                }
            }
            // if (playground == "Arcane"){
            //     System.out.println("i am in arcane");
            //     if (Mystics.contains(usercharacter.getName())){
            //         usercharacter.increaseAttack(2.0);;
            //         return 0;
            //     }
            // }
        }
        else{
            if (playground == "Hillcrest"){
                
                
                if (Highlanders.contains(knight.getName())){
                    System.out.println();
                    System.out.println("EXTRA TURN");
                    System.out.println();
                    double damage = 0.5*(0.2*knight.attack);
                    damage=playBattle.round(damage);
                    // System.out.println("double damage");
                        //opponentcharacter.defence -= damage;
                    return damage;
                }
                
                // else{
                //     double health = 0.1*(0.2*knight.attack);
                //     //String formattedString = String.format("%.1f", health);

                //     // Parse the formatted string back to double
                //     //health= Double.parseDouble(formattedString);
                //     // if (Highlanders.contains(usercharacter.getName())){
                        
                //     // }
                //     return health;
                // }
                
                
            }
            // if (playground == "Arcane"){
            //     System.out.println("i am in arcane");
            //     if (Mystics.contains(usercharacter.getName())){
            //         double hel=0.1*usercharacter.getHealth();
            //         usercharacter.increasehealth(hel);
            //         return 0;
            //     }
            }
        

        return 0;
    }
    

    //-------------------------------------------------------------------------------------------------------------------------

    public static double buffcharacter(String playground, Mage mage , Boolean spotter) {
        ArrayList<String> Highlanders = new ArrayList<String>();
        ArrayList<String> Marshlanders = new ArrayList<String>();
        ArrayList<String> Sunchildren = new ArrayList<String>();
        ArrayList<String> Mystics = new ArrayList<String>();

        
        Highlanders.add("Enchanter");
        Highlanders.add("Conjurer");
        Marshlanders.add("Warlock");
        Mystics.add("Illusionist");
        Mystics.add("Eldritch");
        // System.out.println("---"+Highlanders.size());

        if (spotter){
            // System.out.println("workingm-1");
            if (playground == "Hillcrest"){
                // System.out.println("i am in hillcrest");
                if (Highlanders.contains(mage.getName())){
                    mage.increaseAttack(1.0);;
                    mage.increaseDefence(1.0);
                    return 0;
                }
                if (Marshlanders.contains(mage.getName())){
                    mage.decreaseSpeed(1.0);
                    return 0;
                    
                }
                // if (Sunchildren.contains(usercharacter.getName())){
                //     usercharacter.decreaseSpeed(1.0);
                //     return 0;
                // }
            }
            if (playground == "Marshland"){
                // System.out.println("i am in marshland");
                if (Marshlanders.contains(mage.getName())){
                    mage.increaseDefence(2.0);
                    return 0;
                    
                }
                // if (Sunchildren.contains(usercharacter.getName())){
                //     usercharacter.decreaseAttack(1.0);
                //     return 0;
    
                // }
                if (Mystics.contains(mage.getName())){
                    mage.decreaseSpeed(1.0);
                    return 0;
                }
            }
            if (playground == "Desert"){
                // System.out.println("i am in desert");
                if (Marshlanders.contains(mage.getName())){
                    mage.decreaseHealth(1.0);
                    return 0;
                // }
                // if (Sunchildren.contains(mage.getName())){
                //     mage.increaseAttack(1.0);;
                //     return 0;
    
                // }
            }
            if (playground == "Arcane"){
                // System.out.println("i am in arcane");
                if (Mystics.contains(mage.getName())){
                    mage.increaseAttack(2.0);
                    return 0;
                }
            }
            }
        }
        else{
            // System.out.println("workingm-2");
            if (playground == "Hillcrest"){
                // System.out.println("i am in hillcrest");
                // System.out.println(Highlanders.size());
 
                if (Highlanders.contains(mage.getName())){
                    // System.out.println("double damage");
                    System.out.println();
                    System.out.println("EXTRA TURN");
                    System.out.println();
                    double damage = 0.5*(0.2*mage.attack);
                    damage=playBattle.round(damage);
                    return damage;
                }
                
                // else{
                //     double health = 0.1*(0.2*usercharacter.attack);
                //     //String formattedString = String.format("%.1f", health);

                //     // Parse the formatted string back to double
                //     //health= Double.parseDouble(formattedString);
                //     // if (Highlanders.contains(usercharacter.getName())){
                        
                //     // }
                //     return health;
                // }
                
                
            }
            if (playground == "Arcane"){
                // System.out.println("i am in arcane");
                if (Mystics.contains(mage.getName())){
                    System.out.println();
                    System.out.println("HEALS AFTER IT'S TURN");
                    System.out.println();
                    double hel=0.1*mage.getHealth();
                    hel=playBattle.round(hel);
                    mage.increasehealth(hel);
                    return 0;
                }
            }
            
        }
        return 0;
    
    }
        
    

    //-------------------------------------------------------------------------------------------------------------------------

    public static double buffcharacter(String playground, MythicalCreature mythicalCreature , Boolean spotter) {
        ArrayList<String> Highlanders = new ArrayList<String>();
        ArrayList<String> Marshlanders = new ArrayList<String>();
        ArrayList<String> Sunchildren = new ArrayList<String>();
        ArrayList<String> Mystics = new ArrayList<String>();

        

        
        Marshlanders.add("Basilisk");
        Marshlanders.add("Hydra");

        
        Sunchildren.add("Dragon");
        Sunchildren.add("Phoenix");
        Mystics.add("Pegasus");
        if (spotter){
            // System.err.println("workingmy-1");
            if (playground == "Hillcrest"){
                // System.out.println("i am in hillcrest");
                // if (Highlanders.contains(usercharacter.getName())){
                //     usercharacter.increaseAttack(1.0);;
                //     usercharacter.increaseDefence(1.0);
                //     return 0;
                // }
                if (Marshlanders.contains(mythicalCreature.getName())){
                    mythicalCreature.decreaseSpeed(1.0);
                    return 0;
                    
                }
                if (Sunchildren.contains(mythicalCreature.getName())){
                    mythicalCreature.decreaseSpeed(1.0);
                    return 0;
                }
            }
            if (playground == "Marshland"){
                // System.out.println("i am in marshland");
                if (Marshlanders.contains(mythicalCreature.getName())){
                    mythicalCreature.increaseDefence(2.0);
                    return 0;
                    
                }
                if (Sunchildren.contains(mythicalCreature.getName())){
                    mythicalCreature.decreaseAttack(1.0);
                    return 0;
    
                }
                if (Mystics.contains(mythicalCreature.getName())){
                    mythicalCreature.decreaseSpeed(1.0);
                    return 0;
                }
            }
            if (playground == "Desert"){
                // System.out.println("i am in desert");
                if (Marshlanders.contains(mythicalCreature.getName())){
                    mythicalCreature.decreaseHealth(1.0);
                    return 0;
                }
                if (Sunchildren.contains(mythicalCreature.getName())){
                    mythicalCreature.increaseAttack(1.0);;
                    return 0;
    
                }
            }
            if (playground == "Arcane"){
                if (Mystics.contains(mythicalCreature.getName())){
                    mythicalCreature.increaseAttack(2.0);;
                    return 0;
                }
            }
        }
        else{
            if (playground == "Hillcrest"){
                if (Highlanders.contains(mythicalCreature.getName())){
                    System.out.println();
                    System.out.println("EXTRA TURN");
                    System.out.println();
                    double damage = 0.5*(0.2*mythicalCreature.attack);
                    damage=playBattle.round(damage);
                    return damage;
                }
            }
            if (playground == "Arcane"){
                if (Mystics.contains(mythicalCreature.getName())){
                    System.out.println();
                    System.out.println("HEALS AFTER IT'S TURN");
                    System.out.println();
                    double hel=0.1*mythicalCreature.getHealth();
                    hel=playBattle.round(hel);
                    mythicalCreature.increasehealth(hel);
                    return 0;
                }
            }
        }
        return 0;
    }

    //-------------------------------------------------------------------------------------------------------------------------

    public static double buffcharacter(String playground, Healer healer , Boolean spotter) {
        ArrayList<String> Highlanders = new ArrayList<String>();
        ArrayList<String> Marshlanders = new ArrayList<String>();
        ArrayList<String> Sunchildren = new ArrayList<String>();
        ArrayList<String> Mystics = new ArrayList<String>();

        
        Highlanders.add("Medic");

        
        Marshlanders.add("Alchemist");
        

        
        Sunchildren.add("Soother"); 
        Sunchildren.add("Lightbringer"); 
       
        Mystics.add("Saint");
       

        if (spotter){
            // System.err.println("workingh-1");
            if (playground == "Hillcrest"){
                // System.out.println("i am in hillcrest");
                if (Highlanders.contains(healer.getName())){
                    healer.increaseAttack(1.0);;
                    healer.increaseDefence(1.0);
                    return 0;
                }
                if (Marshlanders.contains(healer.getName())){
                    healer.decreaseSpeed(1.0);
                    return 0;
                    
                }
                if (Sunchildren.contains(healer.getName())){
                    healer.decreaseSpeed(1.0);
                    return 0;
                }
            }
            if (playground == "Marshland"){
                // System.out.println("i am in marshland");
                if (Marshlanders.contains(healer.getName())){
                    healer.increaseDefence(2.0);
                    return 0;
                    
                }
                if (Sunchildren.contains(healer.getName())){
                    healer.decreaseAttack(1.0);
                    return 0;
    
                }
                if (Mystics.contains(healer.getName())){
                    healer.decreaseSpeed(1.0);
                    return 0;
                }
            }
            if (playground == "Desert"){
                // System.out.println("i am in desert");
                if (Marshlanders.contains(healer.getName())){
                    healer.decreaseHealth(1.0);
                    return 0;
                }
                if (Sunchildren.contains(healer.getName())){
                    healer.increaseAttack(1.0);;
                    return 0;
    
                }
            }
            if (playground == "Arcane"){
                // System.out.println("i am in arcane");
                if (Mystics.contains(healer.getName())){
                    healer.increaseAttack(2.0);;
                    return 0;
                }
            }
        }
        else{
            //   System.err.println("workingh-2");
            if (playground == "Hillcrest"){
                // System.out.println("i am in hillcrest");
                // if (healer.getName()!="Medic"){
                if (Highlanders.contains(healer.getName())){
                    // System.out.println("double heal");
                //         double damage = 0.5*(0.2*healer.attack) - 0.1*(opponentcharacter.defence);
                //         //opponentcharacter.defence -= damage;
                //         return damage;
                //     }
                // }
                // else{
                    System.out.println();
                    System.out.println("EXTRA TURN");
                    System.out.println();
                    double health = 0.1*(0.2*healer.attack);
                    health=playBattle.round(health);
                    //String formattedString = String.format("%.1f", health);

                    // Parse the formatted string back to double
                    //health= Double.parseDouble(formattedString);
                    // if (Highlanders.contains(usercharacter.getName())){
                        
                    // }
                    return health;
                
                
                
            }
            }
            if (playground == "Arcane"){
                // System.out.println("i am in arcane");
                if (Mystics.contains(healer.getName())){
                    System.out.println();
                    System.out.println("HEALS AFTER IT'S TURN");
                    System.out.println();
                    double hel=0.1*healer.getHealth();
                    hel=playBattle.round(hel);
                    healer.increasehealth(hel);
                    return 0;
                }
            }
        }
        return 0;
    }

    //-------------------------------------------------------------------------------------------------------------------------
}
