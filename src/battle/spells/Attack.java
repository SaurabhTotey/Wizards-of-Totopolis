package battle.spells;

import battle.Battle;
import battle.Character;

/**
 * Created by Saurabh Totey on 5/28/2017.
 */
public class Attack extends Spell {

    {new Attack();}

    public Attack(){
        super("attack", "A bread and butter attack spell.");
    }

    public Action[] castSpell(Battle currentBattle, Character caster){
        Character target = caster.decideTarget(currentBattle, false);
        return new Action[]{new Action(0, new Character[]{caster , target}, "attack"){
            public void doAction(){
                target.takeDamage(caster.attack[0] + ((int) Math.sqrt(target.defense[0])), false);
            }
        }};
    }
}
