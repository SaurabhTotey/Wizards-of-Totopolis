package battle;

import battle.spells.Spell;

import java.io.Serializable;

/**
 * Created by Saurabh Totey on 5/28/2017.
 */
public class Player extends Character implements Serializable {

    int money;

    public Player(String name){
        this.name = name;
    }

    public void addExperience(int experienceToAdd){
        super.addExperience(experienceToAdd);
        //TODO add stats gambling
    }

    public Spell selectSpell(Battle currentBattle){
        //TODO return not randomly selected spell
        return super.selectSpell(currentBattle);
    }

    public Character decideTarget(Battle currentBattle, boolean canDecideSelf){
        //TODO return not randomly decided target
        return super.decideTarget(currentBattle, canDecideSelf);
    }

}
