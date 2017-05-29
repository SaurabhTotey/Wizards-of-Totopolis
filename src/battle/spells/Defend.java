package battle.spells;

import battle.Action;
import battle.Character;

/**
 * Created by Saurabh Totey on 5/28/2017.
 */
public class Defend extends Spell {

    public Defend(){
        super("defend");
    }

    public Action[] castSpell(Character caster, Character defender){
        return new Action[]{
                new Action(0){
                    public void doAction(){
                        caster.defense[0] = caster.defense[0] * 2;
                    }
                },
                new Action(2){
                    public void doAction(){
                        caster.defense[0] = caster.defense[0] / 2;
                    }
                }
        };
    }
}
