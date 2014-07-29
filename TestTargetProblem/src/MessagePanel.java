import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


public class MessagePanel extends JPanel
{
	
	public MessagePanel(){
		super(new BorderLayout());
		
		JTabbedPane tabs = new JTabbedPane();
		
		JPanel genPanel = new JPanel();
		JPanel solvePanel = new JPanel();
		
		genPanel.add(new JButton("sdfsdfsdf"));
		genPanel.add(new JButton("dsfsdfsdfdsf"));
		
		
		tabs.addTab("<html><body marginwidth=15 marginheight=5><h2>Generate</h2></body></html>",genPanel);
		tabs.addTab("<html><body marginwidth=15 marginheight=5><h2>Solve</h2></body></html>",solvePanel);
		
		
		
		
		
		
		
		tabs.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		this.add(tabs);
		this.setPreferredSize(new Dimension(500,500));
		this.setVisible(true);
	}
	
}
