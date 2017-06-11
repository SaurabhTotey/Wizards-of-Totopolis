import battle.Battle;
import battle.Character;
import battle.Player;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Saurabh Totey on 5/28/2017.
 */
public class Main implements Serializable {

    public static Main main;
    public static Display gui;
    public static String input = null;
    private static boolean willInterpretIncoming;

    public String identifier;
    public Character player;
    public Battle currentBattle;

    public Main(String id){
        this.identifier = id;
        gui = new Display();
        while(gui == null || gui.console == null){
            try{Thread.sleep(300);}catch(InterruptedException e){}
        }
        output("So you want to enter wizardry? What's your name?");
        this.player = new Player(getInput(false));
        output("Oh no! It looks like a new challenger approaches for battle!");
        getInput(true);
    }

    public static void main(String args[]){
        main = new Main("test");
    }

    public static String getInput(boolean allowEmptyInput){
        willInterpretIncoming = false;
        while(input == null || input.isEmpty() && !allowEmptyInput){
            try{
                Thread.sleep(300);
            }catch(InterruptedException e){

            }
        }
        String toReturn = input;
        input = null;
        willInterpretIncoming = true;
        return toReturn;
    }

    public static void output(String outgoing){
        outgoing = "[" + new SimpleDateFormat("dd/MM/yy HH:mm:ss").format(Calendar.getInstance().getTime()) + "] >>> " + outgoing;
        gui.displayText(outgoing);
        System.out.println(outgoing);
    }

    public static void interpretText(String incoming){
        input = incoming;
        if(!input.isEmpty()){
            incoming = "[" + new SimpleDateFormat("dd/MM/yy HH:mm:ss").format(Calendar.getInstance().getTime()) + "] <<< " + incoming;
            System.out.println(incoming);
            gui.displayText(incoming);
        }
        if(willInterpretIncoming){
            //TODO interpret incoming
            input = null;
        }
    }

}
