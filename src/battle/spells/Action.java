package battle.spells;

import battle.Character;

/**
 * Created by Saurabh Totey on 5/28/2017.
 */
public abstract class Action {

    public String actionName;
    public int timeUntilUse;
    public Character[] essentialCharacters;

    public Action(int timeUntilUse, Character[] cancelIfDie, String actionName){
        this.timeUntilUse = timeUntilUse;
        this.essentialCharacters = cancelIfDie;
        this.actionName = actionName;
    }

    public boolean isValid(){
        if(this.essentialCharacters != null){
            for(Character character : this.essentialCharacters){
                if(character.isDead()){
                    return false;
                }
            }
        }
        return true;
    }

    public abstract void doAction();
    public abstract String getActionDescription();

}
