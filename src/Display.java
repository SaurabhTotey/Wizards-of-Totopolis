import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

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
            window.add(titleBanner, "dock north, width 100%, span, wrap, gap 5% 5% 5% 5%");

            mainPane = new JPanel(new MigLayout("fill"));

            inputField = new JTextField();
            inputField.setFont(defaultFont);
            inputField.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    Main.interpretText(inputField.getText());
                    inputField.setText("");
                }
            });
            mainPane.add(inputField, "dock south, width 100%, span, wrap");

            console = new JTextArea();
            console.setFont(defaultFont);
            console.setEditable(false);
            mainPane.add(new JScrollPane(console), "grow, push, span, wrap");

            window.add(mainPane, "grow, push, span, wrap, gap 5% 5% 5% 5%");

            new Thread(() -> {while(true){try{refreshFrame();Thread.sleep(300);}catch(InterruptedException e){}}}).start();
        });
    }

    private void refreshFrame(){
        SwingUtilities.invokeLater(() ->{
            window.repaint();
            window.revalidate();
        });
    }

    public void displayText(String textToDisplay){
        SwingUtilities.invokeLater(() -> {this.console.append(textToDisplay + "\n");});
    }

}
