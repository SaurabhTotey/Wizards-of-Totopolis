package battle.spells;

import battle.Character;

/**
 * Created by Saurabh Totey on 5/28/2017.
 */
public class Attack extends Spell {

    {new Attack();}

    public Attack(){
        super("attack");
    }

    public Action[] castSpell(Character caster, Character defender){
        return new Action[]{new Action(0){
            public void doAction(){
                defender.health[0] -= caster.attack[0] + (int) Math.sqrt(defender.defense[0]);
            }
        }};
    }
}
