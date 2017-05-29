import java.io.Serializable;

/**
 * Created by Saurabh Totey on 5/28/2017.
 */
public class Character implements Serializable{

    public String name;
    public int experience;
    public int[] health = {100, 100};
    public int[] attack = {5, 5};
    public int[] defense = {5, 5};
    public int[] speed = {5, 5};
    private int[][] allStats = {health, attack, defense, speed};

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

    public void refresh(){
        for(int[] stat : this.allStats){
            stat[1] = stat[0];
        }
    }

}
