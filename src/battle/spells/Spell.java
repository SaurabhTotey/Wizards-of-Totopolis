package battle.spells;

import java.util.HashMap;

import battle.Battle;
import battle.Character;

/**
 * Created by Saurabh Totey on 5/28/2017.
 */
public abstract class Spell {

    public static HashMap<String, Spell> spellNameToSpell = new HashMap<String, Spell>();

    public int cost;
    public String description;

    public Spell(String name, String description){
        spellNameToSpell.put(name, this);
        this.description = description;
    }

    public Spell(String name, String description, int cost){
        this(name, description);
        this.cost = cost;
    }

    public abstract Action[] castSpell(Battle currentBattle, Character caster);

}
