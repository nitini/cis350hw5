import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI_Winner extends GUI_EndState implements ActionListener
{

    private JLabel answerLabel;
    private ImageIcon background;
    private JPanel imagePanel;
    
    public GUI_Winner(String Letters,JFrame frame, String result)
    {
    	super(Letters, frame, result);
        bg(super.endStateFrame);
        answerLabel = new JLabel("The answer is ");
        super.secretWordLabel = new JLabel(Letters);
        secretWordLabel.setFont(new Font("Default",Font.PLAIN,23));
        secretWordLabel.setForeground(Color.red);
        super.endStateFrame.add(answerLabel);
        super.endStateFrame.add(secretWordLabel);
        super.endStateFrame.add(super.gameResultLabel);
        super.endStateFrame.add(super.rtnBtn);

    }

    public void bg(JFrame frame)
    {
        background = new ImageIcon("Congrats.gif");
        JLabel label = new JLabel(background);
        label.setBounds(0, 0, background.getIconWidth(),
            background.getIconHeight());
        imagePanel = (JPanel) frame.getContentPane();
        imagePanel.setOpaque(false);
        imagePanel.setLayout(new FlowLayout());
        frame.getLayeredPane().setLayout(null);
        frame.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
        frame.setSize(background.getIconWidth(), background.getIconHeight());
        frame.setResizable(false);

    }

}