package battle.spells;

import java.util.HashMap;

import battle.Battle;
import battle.Character;

/**
 * Created by Saurabh Totey on 5/28/2017.
 */
public abstract class Spell {

    public enum Target{
        SELF, ANYONE, ANYONE_BUT_SELF, EVERYONE, EVERYONE_BUT_SELF
    }

    public static HashMap<String, Spell> spellNameToSpell = new HashMap<String, Spell>();

    public Target[] targets;

    public Spell(String name, Target[] targets){
        spellNameToSpell.put(name, this);
        this.targets = targets;
    }

    public abstract Action[] castSpell(Battle currentBattle, Character[] affecting);

}
