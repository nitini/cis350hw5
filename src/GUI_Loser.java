import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI_Loser extends GUI_EndState implements ActionListener
{

    public GUI_Loser(String Letters, JFrame frame, String result)
    {
       super(Letters, frame, result);
        super.endStateFrame.setSize(new Dimension(300,470));
        super.endStateFrame.setLayout(new FlowLayout());
        super.secretWordLabel = new JLabel("The answer is "+Letters+".");
        
        ImageIcon icon = new ImageIcon("loser.gif"); 
        JLabel loserPic = new JLabel(icon);
        super.endStateFrame.add(secretWordLabel);
        super.endStateFrame.add(super.gameResultLabel);
        super.endStateFrame.add(super.rtnBtn);
        super.endStateFrame.add(loserPic);

    }
}