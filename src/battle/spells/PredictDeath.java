package battle.spells;

import battle.Battle;
import battle.Character;

import static battle.spells.Spell.Target.SELF;

/**
 * Created by Saurabh Totey on 6/11/2017.
 */
public class PredictDeath extends Spell {

    {new PredictDeath();}

    public PredictDeath(){
        super("predict death", new Target[]{SELF});
    }

    public Action[] castSpell(Battle currentBattle, Character[] affecting){
        return new Action[]{new Action(1, null){
            public void doAction(){
                if(affecting[1].isDead()){
                    affecting[1].health[0] = affecting[1].health[1];
                }else{
                    affecting[1].health[0] = 0;
                }
            }
        }};
    }

}
