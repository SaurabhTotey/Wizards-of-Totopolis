package display;

import battle.Character;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Saurabh Totey on 5/28/2017.
 */
public class Display {

    public JFrame window;
    public Font titleFont;
    public Font defaultFont;
    public JPanel mainPane;
    public JLabel titleBanner;
    public JTextArea console;
    public JTextField inputField;

    private JTextField name = new JTextField("???");
    private JProgressBar experience = new JProgressBar();
    private JTextField health = new JTextField("???");
    private JTextField attack = new JTextField("???");
    private JTextField defense = new JTextField("???");
    private JTextField speed = new JTextField("???");
    private JTextField[] allFields = new JTextField[]{name, health, attack, defense, speed};

    public Display(){
        SwingUtilities.invokeLater(() -> {
            window = new JFrame("Wizards of Totopolis!");
            window.setLayout(new MigLayout("fill"));
            window.setVisible(true);
            window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
            GraphicsDevice[] allDevices = env.getScreenDevices();
            int topLeftX, topLeftY, screenX, screenY, windowPosX, windowPosY;
            topLeftX = allDevices[0].getDefaultConfiguration().getBounds().x;
            topLeftY = allDevices[0].getDefaultConfiguration().getBounds().y;
            screenX = allDevices[0].getDefaultConfiguration().getBounds().width;
            screenY = allDevices[0].getDefaultConfiguration().getBounds().height;
            window.setBounds(0, 0, screenX / 2, screenY / 2);
            windowPosX = ((screenX - window.getWidth()) / 2 + topLeftX);
            windowPosY = ((screenY - window.getHeight()) / 2 + topLeftY);
            window.setLocation(windowPosX, windowPosY);
            window.setLayout(new MigLayout());

            titleFont = new Font(Font.SERIF, Font.BOLD, screenX / 70);
            defaultFont = new Font(Font.MONOSPACED, Font.PLAIN, screenX / 130);

            titleBanner = new JLabel("Wizards of Totopolis");
            titleBanner.setFont(titleFont);
            titleBanner.setHorizontalAlignment(SwingConstants.CENTER);
            window.add(titleBanner, "dock north, width 100%, span, wrap, gap 1% 1% 1% 1%");

            mainPane = new JPanel(new MigLayout("fill"));

            inputField = new JTextField();
            inputField.setFont(defaultFont);
            inputField.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    main.Main.interpretText(inputField.getText());
                    inputField.setText("");
                }
            });
            mainPane.add(inputField, "dock south, width 100%, span, wrap");

            console = new JTextArea();
            console.setFont(defaultFont);
            console.setEditable(false);
            mainPane.add(new JScrollPane(console), "grow, push, span, wrap");

            JPanel playerPanel = new JPanel(new MigLayout("fillx"));

            for(JTextField field : this.allFields){
                field.setFont(defaultFont);
                field.setEditable(false);
                field.setBackground(Color.WHITE);
                field.setHorizontalAlignment(SwingConstants.CENTER);
            }

            JLabel nameLabel = new JLabel("Name: ");
            nameLabel.setFont(defaultFont);
            playerPanel.add(nameLabel, "grow");
            playerPanel.add(this.name, "grow, span, wrap");

            for(int i = 0; i < 2; i++){
                playerPanel.add(new JLabel(" "), "span, wrap");
            }

            JLabel healthLabel = new JLabel("Health: ");
            healthLabel.setFont(defaultFont);
            playerPanel.add(healthLabel, "grow");
            playerPanel.add(this.health, "grow");

            JLabel attackLabel = new JLabel("Attack: ");
            attackLabel.setFont(defaultFont);
            playerPanel.add(attackLabel, "grow");
            playerPanel.add(this.attack, "grow, wrap");

            JLabel defenseLabel = new JLabel("Defense: ");
            defenseLabel.setFont(defaultFont);
            playerPanel.add(defenseLabel, "grow");
            playerPanel.add(this.defense, "grow");

            JLabel speedLabel = new JLabel("Speed: ");
            speedLabel.setFont(defaultFont);
            playerPanel.add(speedLabel, "grow");
            playerPanel.add(this.speed, "grow, wrap");

            window.add(playerPanel, "dock east, width 25%, gap 1% 1% 1% 1%");
            window.add(mainPane, "grow, push, span, gap 1% 1% 1% 1%");

            new Thread(() -> {while(true){try{refreshFrame();Thread.sleep(300);}catch(InterruptedException e){}}}).start();
        });
    }

    private void refreshFrame(){
        SwingUtilities.invokeLater(() ->{
            try{
                this.name.setText(main.Main.main.player.name);
                for(int i = 0; i < this.allFields.length - 1; i++){
                    this.allFields[i + 1].setText(main.Main.main.player.allStats[i][0] + " / " + main.Main.main.player.allStats[i][1]);
                }
            }catch(Exception e){}
            window.repaint();
            window.revalidate();
        });
    }

    public void displayText(String textToDisplay){
        SwingUtilities.invokeLater(() -> {this.console.append(textToDisplay + "\n");});
    }

}
