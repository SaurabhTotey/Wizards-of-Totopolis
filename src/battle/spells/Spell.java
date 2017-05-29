package battle.spells;

import battle.Action;
import java.util.HashMap;
import battle.Character;

/**
 * Created by Saurabh Totey on 5/28/2017.
 */
public abstract class Spell {

    public static HashMap<String, Spell> spellNameToSpell = new HashMap<String, Spell>();

    public Spell(String name){
        spellNameToSpell.put(name, this);
    }

    public abstract Action[] castSpell(Character caster, Character defender);

}
