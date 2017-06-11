package battle.spells;

import battle.Battle;
import battle.Character;
import static battle.spells.Spell.Target.ANYONE_BUT_SELF;

/**
 * Created by Saurabh Totey on 5/28/2017.
 */
public class Attack extends Spell {

    {new Attack();}

    public Attack(){
        super("attack", new Target[]{ANYONE_BUT_SELF});
    }

    public Action[] castSpell(Battle currentBattle, Character[] affecting){
        return new Action[]{new Action(0, affecting){
            public void doAction(){
                affecting[1].health[0] -= affecting[0].attack[0] + (int) Math.sqrt(affecting[1].defense[0]);
            }
        }};
    }
}
