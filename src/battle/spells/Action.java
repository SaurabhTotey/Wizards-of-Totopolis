package battle.spells;

import battle.Character;

/**
 * Created by Saurabh Totey on 5/28/2017.
 */
public abstract class Action {

    public int timeUntilUse;
    public Character[] essentialCharacters;

    public Action(int timeUntilUse, Character[] essentialCharacters){
        this.timeUntilUse = timeUntilUse;
        this.essentialCharacters = essentialCharacters;
    }

    public boolean isValid(){
        if(this.essentialCharacters != null){
            for(Character character : this.essentialCharacters){
                if(character.health[0] <= 0){
                    return false;
                }
            }
        }
        return true;
    }

    public abstract void doAction();

}
