package battle.spells;

import battle.Battle;
import battle.Character;
import static battle.spells.Spell.Target.SELF;

/**
 * Created by Saurabh Totey on 5/28/2017.
 */
public class Defend extends Spell {

    {new Defend();}

    public Defend(){
        super("defend",  new Target[]{SELF});
    }

    public Action[] castSpell(Battle currentBattle, Character[] affecting){
        return new Action[]{
                new Action(0, affecting){
                    public void doAction(){
                        affecting[1].defense[0] = affecting[1].defense[0] * 2;
                    }
                },
                new Action(2, affecting){
                    public void doAction(){
                        affecting[1].defense[0] = affecting[1].defense[0] / 2;
                    }
                }
        };
    }
}
