import battle.Character;
import battle.Player;

import java.io.Serializable;

/**
 * Created by Saurabh Totey on 5/28/2017.
 */
public class Main implements Serializable {

    public static Main main;
    public static String input = null;
    private static boolean willInterpretIncoming;

    public String identifier;
    public Character player;
    public transient Display gui;

    public Main(String id){
        this.gui = new Display();
        //this.player = new Player(getInput());
    }

    public static void main(String args[]){
        main = new Main("test");
    }

    public static String getInput(boolean allowEmptyInput){
        willInterpretIncoming = true;
        while(input == null || (!allowEmptyInput && input.isEmpty())){
            try{
                Thread.sleep(300);
            }catch(InterruptedException e){

            }
        }
        String toReturn = input;
        input = null;
        willInterpretIncoming = false;
        return toReturn;
    }

    public static void log(String outgoing){
        main.gui.displayText(outgoing);
        System.out.println(outgoing);
    }

    public static void interpretText(String incoming){
        input = incoming;
        if(!input.isEmpty()){
            System.out.println(incoming);
            main.gui.displayText(incoming);
        }
        if(willInterpretIncoming){
            //TODO interpret incoming
            input = null;
        }
    }

}
