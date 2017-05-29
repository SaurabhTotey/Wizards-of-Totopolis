import java.io.Serializable;

/**
 * Created by Saurabh Totey on 5/28/2017.
 */
public class Player extends Character implements Serializable {

    public Player(String name){
        this.name = name;
    }

    public void addExperience(int experienceToAdd){
        super.addExperience(experienceToAdd);
        //TODO
    }

}
