package display;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Display 
{

	JFrame frame;
	JPanel panel;
	JLabel label;
	
	public Display()
	{
		createFrame();
	}
	
	public void createFrame()
	{
			
		// Set look and field 
        try 
        {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) 
            {
                if ("Nimbus".equals(info.getName())) 
                {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } 
        catch (ClassNotFoundException | InstantiationException |
                IllegalAccessException | UnsupportedLookAndFeelException e) 
        {
           // If Nimbus is not available, you can set the GUI to another look and feel.
        	e.printStackTrace();
        }
		
		frame = new JFrame("Solar System Calculator");
		frame.setSize(700, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		panel = new JPanel(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(10, 10, 10, 10);
		

		label = new JLabel();
		label.setText("");
		label.setFont(new Font("Bookman Old Style", Font.PLAIN, 70));
		
		constraints.gridx = 1;
		constraints.gridy = 1;
		panel.add(label, constraints);
		
		frame.add(panel, BorderLayout.NORTH);
		frame.setVisible(true);
		//frame.pack();
		
	}
	
	public void setLabelText(String newText)
	{
		label.setText(newText);
	}
	
}
