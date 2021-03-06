package battle;

import battle.spells.Spell;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Saurabh Totey on 5/28/2017.
 */
public class Character implements Serializable, Comparable<Character>{

    public String name;
    public int experience;
    public int[] health = {100, 100};
    public int[] attack = {5, 5};
    public int[] defense = {5, 5};
    public int[] speed = {5, 5};
    public int[][] allStats = {health, attack, defense, speed};
    public ArrayList<String> availableSpells = new ArrayList<String>();
    public String[] currentSpells = new String[10];

    public static int getExperienceForLevel(int desiredLevel){
        return (int) Math.pow(desiredLevel, 2);
    }

    public int getLevel(){
        return (int) Math.sqrt(this.experience);
    }

    public void addExperience(int experienceToAdd){
        int levelBefore = getLevel();
        this.experience += experienceToAdd;
        for(int i = levelBefore; i < this.getLevel(); i++){
            for(int[] stat : this.allStats){
                stat[1] += ((int) Math.random() * 3) + 3;
            }
        }
        this.refresh();
    }

    public boolean isDead(){
        return this.health[0] <= 0;
    }

    public void refresh(){
        for(int[] stat : this.allStats){
            stat[1] = stat[0];
        }
    }

    public void takeDamage(int damageToDeal, boolean allowNegativeDamageToHeal){
        this.health[0] -= (allowNegativeDamageToHeal && damageToDeal < 0)? damageToDeal : 0;
    }

    public Spell selectSpell(Battle currentBattle){
        return Spell.spellNameToSpell.get(this.currentSpells[(int) (Math.random() * this.currentSpells.length)]);
    }

    public Character decideTarget(Battle currentBattle, boolean canDecideSelf){
    Character decided;
        do{
            decided = currentBattle.contestants.get((int) (Math.random() * currentBattle.contestants.size()));
        }while(!canDecideSelf && decided == this);
        return decided;
    }

    public int compareTo(Character other){
        return this.speed[0] - other.speed[0];
    }

}
