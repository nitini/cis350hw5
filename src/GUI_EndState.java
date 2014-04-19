import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class GUI_EndState implements ActionListener {
	
    protected JFrame parentFrame;
    protected JFrame endStateFrame;
    protected JLabel secretWordLabel;
    protected JLabel gameResultLabel;
    protected JButton rtnBtn;
    
    public GUI_EndState (String Letters, JFrame frame, String result) {
    	 parentFrame = frame;
    	 endStateFrame = new JFrame(result);
         endStateFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    	 gameResultLabel = new JLabel(result);
    	 rtnBtn = new JButton("Return to the main menu");  
         rtnBtn.addActionListener(this); 
         endStateFrame.setVisible(true);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		
        endStateFrame.dispose();
        parentFrame.dispose();
    	new Start().createAndShowGUI();
		
	}

}
