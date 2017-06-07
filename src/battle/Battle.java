package battle;

import battle.spells.Action;
import battle.spells.Spell;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Saurabh Totey on 6/7/2017.
 */
public class Battle {

    public ArrayList<Action> battleProcedure = new ArrayList<Action>();
    public ArrayList<Character> contestants;

    public Battle(Player[] contestants){
        this.contestants = new ArrayList<Character>(Arrays.asList(contestants));
    }

    public void step(){
        //Executes all of the actions in the battle
        for(Action toDo : this.battleProcedure){
            if(toDo.timeUntilUse == 0){
                toDo.doAction();
            }
            toDo.timeUntilUse--;
            if(toDo.timeUntilUse < 0){
                this.battleProcedure.remove(toDo);
            }
        }
        //Sorts participating players according to their respective speeds: if they have equal speeds, their order is random
        Collections.sort(this.contestants);
        Collections.reverse(this.contestants);
        for(int i = 0; i < this.contestants.size() - 1; i++){
            if(this.contestants.get(i).compareTo(this.contestants.get(i + 1)) == 0 && Math.random() < 0.5){
                Collections.swap(this.contestants, i, i + 1);
            }
        }
        //Goes through all of the players and gets their spells
        for(Character contestant : this.contestants){
            //TODO select defender for each of the spells casted
            this.battleProcedure.addAll(Arrays.asList(Spell.spellNameToSpell.get(contestant.selectSpell()).castSpell(contestant, null)));
        }
    }

}
