package battle.spells;

import battle.Battle;
import battle.Character;

/**
 * Created by Saurabh Totey on 6/11/2017.
 */
public class PredictDeath extends Spell {

    {new PredictDeath();}

    public PredictDeath(){
        super("predict death", "A spell that revives a target if the user correctly predicts that the target will die a turn after casting the spell, but can fail the more it is used in the battle.", 500);
    }

    public Action[] castSpell(Battle currentBattle, Character caster){
        Character target = caster.decideTarget(currentBattle, true);
        double failChance = 0;
        int numFound = 0;
        for(Action toDo : currentBattle.battleProcedure){
            if(toDo.actionName.contains("predict death - ")){
                numFound++;
                failChance += numFound / 10.0;
            }
        }
        if(Math.random() < failChance){
            return new Action[]{new Action(1, null, "predict death - false"){
                public void doAction(){
                    timeUntilUse--; //Makes it so this action isn't removed from the battle after being used
                }
                public String getActionDescription(){
                    return caster.name + " tried predicting their death, but the spell failed!";
                }
            }};
        }
        return new Action[]{new Action(1, null, "predict death - true"){
            boolean didPredictionWork;
            public void doAction(){
                didPredictionWork = target.isDead();
                if(didPredictionWork){
                    target.health[0] = target.health[1] / 10;
                }
                timeUntilUse--; //Makes it so the action doesn't get removed after being used; it won't trigger again, but it will be findable to see how many times this spell was used
            }
            public String getActionDescription(){
                return caster.name + ((didPredictionWork)? " successfully predicted their death and avoided it!" : " tried predicting their death, but they didn't die!");
            }
        }};
    }

}
