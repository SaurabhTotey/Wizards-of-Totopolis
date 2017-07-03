package battle.spells;

import battle.Battle;
import battle.Character;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Saurabh Totey on 6/12/2017.
 */
public class Flash extends Spell {

    {new Flash();}

    public Flash(){
        super("flash", "A spell that damages all other characters and temporarily lowers their speed");
    }

    public Action[] castSpell(Battle currentBattle, Character caster){
        ArrayList<Action> toReturn = new ArrayList<Action>();
        for(Character contestant : currentBattle.contestants){
            if(contestant != caster){
                toReturn.addAll(Arrays.asList(
                    new Action(0, new Character[]{caster, contestant}, "flash start"){
                        public void doAction(){
                            contestant.takeDamage(caster.attack[0] - contestant.defense[0], false);
                            contestant.speed[0] /= 2;
                        }
                    },
                    new Action(2, new Character[]{caster, contestant}, "flash finish"){
                        public void doAction(){
                            contestant.speed[0] *= 2;
                        }
                    }
                ));
            }
        }
        return (Action[]) toReturn.toArray();
    }

}
