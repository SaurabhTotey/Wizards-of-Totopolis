package battle.spells;

import battle.Battle;
import battle.Character;

/**
 * Created by Saurabh Totey on 5/28/2017.
 */
public class Defend extends Spell {

    {new Defend();}

    public Defend(){
        super("defend", "A spell that temporarily doubles the caster's defense.");
    }

    public Action[] castSpell(Battle currentBattle, Character caster){
        return new Action[]{
                new Action(0, new Character[]{caster}, "defend start"){
                    public void doAction(){
                        caster.defense[0] = caster.defense[0] * 2;
                    }
                    public String getActionDescription(){
                        return caster.name + " has used doubled their defense!";
                    }
                },
                new Action(2, new Character[]{caster}, "defend finish"){
                    public void doAction(){
                        caster.defense[0] = caster.defense[0] / 2;
                    }
                    public String getActionDescription(){
                        return caster.name + "'s defense doubling has run out!";
                    }
                }
        };
    }
}
