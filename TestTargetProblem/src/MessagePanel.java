import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;


public class MessagePanel extends JPanel
{
	
	public MessagePanel(){
		super();
		
		JPanel supPanel = new JPanel(new BorderLayout());
		JTabbedPane tabs = new JTabbedPane();
		
		
		
		supPanel.add(tabs,BorderLayout.CENTER);
	}
	
}